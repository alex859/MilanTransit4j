package org.alex859.milantransit4j.service.impl;

import it.atm.json.routeDetails.RouteDetails;
import it.atm.json.routeDetails.Stop;
import org.alex859.milantransit4j.model.graph.RouteSegmentRelationship;
import org.alex859.milantransit4j.model.graph.StopNode;
import org.alex859.milantransit4j.service.GraphPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class Neo4jGraphPersister implements GraphPersister
{
   private static final Logger LOGGER = LoggerFactory.getLogger(Neo4jGraphPersister.class);

   private Neo4jTemplate neo4jTemplate;

   @Override
   @Transactional
   public StopNode getOrCreateStopNode(final Stop stop, final RouteDetails routeDetails)
   {
      final String id = String.join("_", stop.getCode(), routeDetails.getId());

      StopNode stopNode = neo4jTemplate.repositoryFor(StopNode.class).findBySchemaPropertyValue("atmCompoundCode", id);

      if (stopNode == null)
      {
         LOGGER.debug("Creating new StopNode {}", id);
         stopNode = new StopNode();
         stopNode.setName(stop.getDescription());
         stopNode.setAtmCompoundCode(id);
         stopNode.setAtmCode(Integer.valueOf(stop.getCode()));
         if (stop.getLocation() != null)
         {
            stopNode.setLatitude(stop.getLocation().getY());
            stopNode.setLongitude(stop.getLocation().getX());
         }
         else
         {
            LOGGER.debug("Found StopNode {}", id);
         }
         neo4jTemplate.save(stopNode);
      }

      return stopNode;
   }

   @Override
   @Transactional
   public RouteSegmentRelationship createRouteSegmentRelationship(final StopNode from, final StopNode to, final RouteDetails routeDetails, final Double distance)
   {
      final RouteSegmentRelationship relationship = neo4jTemplate.createRelationshipBetween(from, to, RouteSegmentRelationship.class, routeDetails.getId(), false);
      relationship.setDistance(distance);
      relationship.setCode(routeDetails.getId());
      relationship.setType(routeDetails.getLine().getTransportMode());
      return relationship;
   }

   @Autowired
   public void setNeo4jTemplate(final Neo4jTemplate neo4jTemplate)
   {
      this.neo4jTemplate = neo4jTemplate;
   }
}
