package org.alex859.milantransit4j.service.impl;

import it.atm.json.allRoutes.AllRoutesResponse;
import it.atm.json.allRoutes.JourneyPattern;
import it.atm.json.routeDetails.*;
import it.atm.json.timetables.Timetables;
import org.alex859.milantransit4j.service.RouteImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

   private String url;
   private RestTemplate restTemplate;

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

      // save details
      // save geometry
      final Map<Stop, Point> stopPointMap = stopsToClosestPointMap(routeDetails.getStops(), routeDetails.getGeometry().getSegments().stream()
              .flatMap(s -> s.getPoints().stream())
              .collect(toList()));

      stopPointMap.forEach((k, v) -> LOGGER.debug("({}, {}) -> ({}, {})", k.getLocation().getY(), k.getLocation().getX(), v.getY(), v.getX()));

      routeDetails.getStops().stream()
              .filter(s -> s != null)
              .forEach(this::process);
   }

   protected void process(final Stop stop)
   {
      LOGGER.info("Processing stop {}", stop.getDescription());

      // save details

//      stop.getLinks().stream()
//              .filter(l -> "timetable".equals(l.getRel()))
//              .map(l -> getResponse(l.getHref(), Timetables.class))
//              .filter(t -> t != null)
//              .forEach(this::process);

   }

   protected void process(final Timetables t)
   {
      LOGGER.info("Processing TimeTables {}-{}-{}", t.getStopCode(), t.getLineCode(), t.getDirection());
   }

   protected Map<Stop, Point> stopsToClosestPointMap(final List<Stop> stops, List<Point> points)
   {
      return stops.parallelStream()
              .collect(toMap(
                      Function.identity(),
                      s -> points.stream().min((p1, p2) -> distance(s, p1).compareTo(distance(s, p2))).get()));
   }

   protected Double distance(final Stop stop, final Point point)
   {
      return distance(stop.getLocation().getY(), point.getY(), stop.getLocation().getX(), point.getX());
   }

   protected Double distance(final Location location, final Point point)
   {
      return distance(location.getY(), point.getY(), location.getX(), point.getX());
   }

   /**
    * Calculate distance between two points in latitude and longitude taking
    * into account height difference. If you are not interested in height
    * difference pass 0.0. Uses Haversine method as its base.
    *
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
}
