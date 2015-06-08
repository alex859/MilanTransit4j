package org.alex859.milantransit4j.service.impl;

import it.atm.json.allRoutes.AllRoutesResponse;
import it.atm.json.allRoutes.JourneyPattern;
import it.atm.json.routeDetails.*;
import it.atm.json.timetables.Timetables;
import org.alex859.milantransit4j.model.graph.RouteSegmentRelationship;
import org.alex859.milantransit4j.model.graph.StopNode;
import org.alex859.milantransit4j.service.GraphPersister;
import org.alex859.milantransit4j.service.RouteImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class AtmRouteImporter implements RouteImporter
{
   private static final Logger LOGGER = LoggerFactory.getLogger(AtmRouteImporter.class);

   private static final int MIN_DISTANCE_TO_LINK = 50;

   private String url;
   private RestTemplate restTemplate;
   private GraphPersister graphPersister;

   @Override
   public void importRoute()
   {
      LOGGER.info("Getting route list");

      final AllRoutesResponse allRoutesResponse = getResponse(url, AllRoutesResponse.class);

      allRoutesResponse.getJourneyPatterns().stream()
              .filter(jp -> jp != null)
              .forEach(this::process);
   }

   protected void process(final JourneyPattern journeyPattern)
   {
      LOGGER.info("Processing journey pattern {}", journeyPattern.getLine().getLineDescription());

      journeyPattern.getLinks().stream()
              .filter(l -> "self".equals(l.getRel()))
              .map(l -> decode(l.getHref()))
              .map(url -> getResponse(url, RouteDetails.class))
              .filter(rd -> rd != null)
              .forEach(this::process);
   }

   protected void process(final RouteDetails routeDetails)
   {
      LOGGER.info("Processing route {}", routeDetails.getLine().getLineDescription());
      final List<Point> allPoints = routeDetails.getGeometry().getSegments().stream()
              .flatMap(s -> s.getPoints().stream())
              .collect(toList());

      final Map<Point, Stop> pointToStopMap = getPointToClosestStopMap(routeDetails.getStops(), allPoints);
      final Map<Segment, Map<Point, Stop>> additionalPointToStopBySegmentMap = getAdditionalPointToStopMap(routeDetails.getGeometry().getSegments(), pointToStopMap);

      for (final Segment segment : routeDetails.getGeometry().getSegments())
      {
         final Map<Point, Stop> additionalPointToStopMap = additionalPointToStopBySegmentMap.get(segment);
         Stop lastStop = null;
         Point lastPoint = null;
         Double distance = 0.;
         for (final Point point : segment.getPoints())
         {
            if (lastPoint != null)
            {
               distance += distance(lastPoint, point);
            }
            lastPoint = point;

            Stop currentStop = pointToStopMap.get(point);
            if (currentStop == null)
            {
               // check if we have it in the additional ones
               currentStop = additionalPointToStopMap.get(point);
            }
            if (currentStop != null)
            {
               // should not change that much, but we need it for junction, like to compute the correct distance
               // between Pagano and Wagner
               distance += distance(currentStop, lastPoint);
               if (lastStop != null)
               {
                  LOGGER.info("{} -({})-> {}", lastStop.getDescription(), distance, currentStop.getDescription());
                  final StopNode lastStopNode = graphPersister.getOrCreateStopNode(lastStop, routeDetails);
                  final StopNode currentStopNode = graphPersister.getOrCreateStopNode(currentStop, routeDetails);
                  final RouteSegmentRelationship routeSegmentRelationship = graphPersister.createRouteSegmentRelationship(lastStopNode, currentStopNode, routeDetails, distance);
                  distance = 0.;
               }

               lastStop = currentStop;
            }


         }
      }
      //pointToStopMap.forEach((k, v) -> LOGGER.debug("({}, {}) -> ({}, {})", k.getLocation().getY(), k.getLocation().getX(), v.getY(), v.getX()));

      routeDetails.getStops().stream()
              .filter(s -> s != null)
              .forEach(this::process);
   }

   /**
    * We want to check that the first and last point of each segment map to a stop.
    * If this is not true we make it map to the closest stop of the other segments.
    * In this way we can deal with Pagano -> Buonarroti issue and probably more.
    *
    * @param segments The segments to be processed
    * @param pointToStopMap The current point to stop map
    * @return The point to stop entries to be added, grouped by segment
    */
   protected Map<Segment, Map<Point, Stop>> getAdditionalPointToStopMap(final List<Segment> segments, final Map<Point, Stop> pointToStopMap)
   {
      final Map<Segment, Map<Point, Stop>> map = new HashMap<>();

      for (final Segment segment : segments)
      {
         final Map<Point, Stop> pointSegmentMap = new HashMap<>();
         final Point firstPoint = segment.getPoints().get(0);
         final Point lastPoint = segment.getPoints().get(segment.getPoints().size() - 1);
         pointSegmentMap.put(firstPoint, findClosestStopNotInSegment(firstPoint, segment, pointToStopMap));
         pointSegmentMap.put(lastPoint, findClosestStopNotInSegment(lastPoint, segment, pointToStopMap));
         map.put(segment, pointSegmentMap);
      }

      return map;
   }

   protected Stop findClosestStopNotInSegment(final Point point, final Segment segment, final Map<Point, Stop> pointToStopMap)
   {
      final Stop currentClosestStop = pointToStopMap.get(point);
      if (currentClosestStop == null)
      {
         return pointToStopMap.entrySet().stream()
                 .filter(e -> !segment.getPoints().contains(e.getKey()))
                 .map(Map.Entry::getValue)
                 .min((s1, s2) -> distance(s1, point).compareTo(distance(s2, point))).get();
      }

      return currentClosestStop;
   }

   protected StopPointDistanceWrapper findClosestPointAndDistance(final Stop stop, final List<Point> points)
   {
      Point closestPoint = null;
      Double minDistance = Double.MAX_VALUE;

      for (final Point point : points)
      {
         final Double distance = distance(stop, point);
         if (distance < minDistance)
         {
            minDistance = distance;
            closestPoint = point;
         }
      }

      return new StopPointDistanceWrapper(stop, closestPoint, minDistance);
   }

   protected String getSegmentKey(final Segment segment)
   {
      final Point firstPoint = segment.getPoints().iterator().next();

      return String.join("_", firstPoint.getY().toString(), firstPoint.getX().toString());
   }

   protected void process(final Stop stop)
   {
      LOGGER.debug("Processing stop {}", stop.getDescription());

      // save details

//      stop.getLinks().stream()
//              .filter(l -> "timetable".equals(l.getRel()))
//              .map(l -> getResponse(l.getHref(), Timetables.class))
//              .filter(t -> t != null)
//              .forEach(this::process);

   }

   protected void process(final Timetables t)
   {
      LOGGER.debug("Processing TimeTables {}-{}-{}", t.getStopCode(), t.getLineCode(), t.getDirection());
   }

   protected Map<Point, Stop> getPointToClosestStopMap(final List<Stop> stops, List<Point> points)
   {
      return stops.stream()
              .collect(toMap(Function.identity(), s -> points.stream().min((p1, p2) -> distance(s, p1).compareTo(distance(s, p2))).get()))
              .entrySet().stream()
              .collect(toMap(Map.Entry::getValue, Map.Entry::getKey));
   }

   protected Double distance(final Stop stop, final Point point)
   {
      return distance(stop.getLocation().getY(), point.getY(), stop.getLocation().getX(), point.getX());
   }

   protected Double distance(final Stop stop1, final Stop stop2)
   {
      return distance(stop1.getLocation().getY(), stop2.getLocation().getY(), stop1.getLocation().getX(), stop2.getLocation().getX());
   }

   protected Double distance(final Location location, final Point point)
   {
      return distance(location.getY(), point.getY(), location.getX(), point.getX());
   }

   protected Double distance(final Point point1, final Point point2)
   {
      return distance(point1.getY(), point2.getY(), point1.getX(), point2.getX());
   }

   /**
    * Calculate distance between two points in latitude and longitude taking
    * into account height difference. If you are not interested in height
    * difference pass 0.0. Uses Haversine method as its base.
    * <p>
    * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
    * el2 End altitude in meters
    *
    * @return Distance in Meters
    */
   protected Double distance(double lat1, double lat2, double lon1,
                             double lon2)
   {

      final int R = 6371; // Radius of the earth

      final Double latDistance = Math.toRadians(lat2 - lat1);
      final Double lonDistance = Math.toRadians(lon2 - lon1);
      final Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
              + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
              * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
      final Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
      return R * c * 1000; // convert to meters
   }

   protected <T> T getResponse(final String url, Class<T> clazz)
   {
      try
      {
         return restTemplate.getForObject(url, clazz);
      } catch (Exception e)
      {
         LOGGER.warn("Error getting URL: {}", url);
         return null;
      }
   }

   protected String decode(final String encoded)
   {
      try
      {
         return URLDecoder.decode(encoded, "UTF-8");
      } catch (UnsupportedEncodingException e)
      {
         e.printStackTrace();
      }

      return null;
   }

   @Value("${atm.journeyPatterns.url}")
   public void setUrl(final String url)
   {
      this.url = url;
   }

   @Autowired
   public void setRestTemplate(final RestTemplate restTemplate)
   {
      this.restTemplate = restTemplate;
   }

   @Autowired
   public void setGraphPersister(final GraphPersister graphPersister)
   {
      this.graphPersister = graphPersister;
   }

   protected class PointSegmentStopWrapper
   {
      private final Point point;
      private final Segment segment;
      private final Stop stop;

      public PointSegmentStopWrapper(final Point point, final Segment segment, final Stop stop)
      {
         this.point = point;
         this.segment = segment;
         this.stop = stop;

      }

      public Point getPoint()
      {
         return point;
      }

      public Segment getSegment()
      {
         return segment;
      }

      public Stop getStop()
      {
         return stop;
      }
   }

   protected static class StopPointDistanceWrapper
   {
      final Stop stop;
      final Point point;
      final Double distance;

      public StopPointDistanceWrapper(final Stop stop, final Point point, final Double distance)
      {
         this.distance = distance;
         this.stop = stop;
         this.point = point;
      }

      public Double getDistance()
      {
         return distance;
      }

      public Point getPoint()
      {
         return point;
      }

      public Stop getStop()
      {
         return stop;
      }

      @Override
      public String toString()
      {
         return "StopPointDistanceWrapper{" +
                 "stop=" + stop.getDescription() +
                 ", distance=" + distance +
                 '}';
      }
   }
}
