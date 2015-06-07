package org.alex859.milantransit4j.model;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public class GeoPoint
{
   private Double latitude;
   private Double longitude;

   public Double getLatitude()
   {
      return latitude;
   }

   public void setLatitude(final Double latitude)
   {
      this.latitude = latitude;
   }

   public Double getLongitude()
   {
      return longitude;
   }

   public void setLongitude(final Double longitude)
   {
      this.longitude = longitude;
   }
}
