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
import java.util.Collections;
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

      allRoutesResponse.getJourneyPatterns().parallelStream()
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
      final Map<String, Map<Point, Stop>> segmentPointToStopMap = routeDetails.getGeometry().getSegments().stream()
              .collect(toMap(this::getSegmentKey, s ->
                              stopsToClosestPointMap(routeDetails.getStops(), s.getPoints()))
              );

      for (final Segment segment : routeDetails.getGeometry().getSegments())
      {
         Stop lastStop = null;
         Point lastPoint = null;
         Double distance = 0.;
         final Map<Point, Stop> pointToStopMap = segmentPointToStopMap.get(getSegmentKey(segment));
         for (final Point point : segment.getPoints())
         {
            if (lastPoint != null)
            {
               distance += distance(lastPoint, point);
            }
            lastPoint = point;

            final Stop currentStop = pointToStopMap.get(point);
            if (currentStop != null)
            {
               // should not change that much, but we need it for junction, like to compute the correct distance
               // between Pagano and Buonarroti
               distance += distance(currentStop, lastPoint);
               if (lastStop != null)
               {
                  LOGGER.debug("{} -({})-> {}", lastStop.getDescription(), distance, currentStop.getDescription());
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

   protected Map<Point, Stop> stopsToClosestPointMap(final List<Stop> stops, List<Point> points)
   {
      return stops.parallelStream()
              .map(s -> findClosestPointAndDistance(s, points))
              .filter(w -> w.getDistance() < 250)
              .collect(groupingBy(StopPointDistanceWrapper::getPoint))
              .values().stream()
              .map(l -> l.stream()
                      .min((v1, v2) -> v1.getDistance().compareTo(v2.getDistance())).get())
              .collect(toMap(StopPointDistanceWrapper::getPoint, StopPointDistanceWrapper::getStop));
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
