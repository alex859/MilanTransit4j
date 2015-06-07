package org.alex859.milantransit4j.model.graph;

import org.alex859.milantransit4j.model.GeoPoint;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@NodeEntity
public class StopNode extends GeoPoint
{
   @GraphId
   private Long graphId;

   @Indexed
   private String atmCompoundCode;

   @Indexed
   private Integer atmCode;

   private String name;

   public Integer getAtmCode()
   {
      return atmCode;
   }

   public void setAtmCode(final Integer atmCode)
   {
      this.atmCode = atmCode;
   }

   public Long getGraphId()
   {
      return graphId;
   }

   public void setGraphId(final Long graphId)
   {
      this.graphId = graphId;
   }

   public String getName()
   {
      return name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public String getAtmCompoundCode()
   {
      return atmCompoundCode;
   }

   public void setAtmCompoundCode(final String atmCompoundCode)
   {
      this.atmCompoundCode = atmCompoundCode;
   }
}
