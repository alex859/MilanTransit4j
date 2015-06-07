package org.alex859.milantransit4j.service;

import it.atm.json.routeDetails.RouteDetails;
import it.atm.json.routeDetails.Stop;
import org.alex859.milantransit4j.model.graph.RouteSegmentRelationship;
import org.alex859.milantransit4j.model.graph.StopNode;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface GraphPersister
{
   StopNode getOrCreateStopNode(Stop stop, RouteDetails routeDetails);
   RouteSegmentRelationship createRouteSegmentRelationship(StopNode from, StopNode to, RouteDetails routeDetails, Double distance);
}
