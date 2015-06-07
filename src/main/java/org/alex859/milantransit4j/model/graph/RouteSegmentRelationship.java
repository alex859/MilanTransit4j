package org.alex859.milantransit4j.model.graph;

import org.springframework.data.neo4j.annotation.*;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@RelationshipEntity
public class RouteSegmentRelationship
{
   @GraphId
   private Long graphId;

   @StartNode
   private StopNode start;
   @EndNode
   private StopNode end;

   @RelationshipType
   private String code;

   private Double distance;
   private Integer type;

   public Double getDistance()
   {
      return distance;
   }

   public void setDistance(final Double distance)
   {
      this.distance = distance;
   }

   public StopNode getEnd()
   {
      return end;
   }

   public void setEnd(final StopNode end)
   {
      this.end = end;
   }

   public Long getGraphId()
   {
      return graphId;
   }

   public void setGraphId(final Long graphId)
   {
      this.graphId = graphId;
   }

   public String getCode()
   {
      return code;
   }

   public void setCode(final String code)
   {
      this.code = code;
   }

   public StopNode getStart()
   {
      return start;
   }

   public void setStart(final StopNode start)
   {
      this.start = start;
   }

   public Integer getType()
   {
      return type;
   }

   public void setType(final Integer type)
   {
      this.type = type;
   }
}
