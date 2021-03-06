
package it.atm.json.routeDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Id",
    "Code",
    "Direction",
    "Line",
    "Stops",
    "Geometry",
    "Links"
})
public class RouteDetails {

    @JsonProperty("Id")
    private String Id;
    @JsonProperty("Code")
    private String Code;
    @JsonProperty("Direction")
    private String Direction;
    @JsonProperty("Line")
    private it.atm.json.routeDetails.Line Line;
    @JsonProperty("Stops")
    private List<Stop> Stops = new ArrayList<Stop>();
    @JsonProperty("Geometry")
    private it.atm.json.routeDetails.Geometry Geometry;
    @JsonProperty("Links")
    private List<Link_> Links = new ArrayList<Link_>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Id
     */
    @JsonProperty("Id")
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    @JsonProperty("Id")
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Code
     */
    @JsonProperty("Code")
    public String getCode() {
        return Code;
    }

    /**
     * 
     * @param Code
     *     The Code
     */
    @JsonProperty("Code")
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * 
     * @return
     *     The Direction
     */
    @JsonProperty("Direction")
    public String getDirection() {
        return Direction;
    }

    /**
     * 
     * @param Direction
     *     The Direction
     */
    @JsonProperty("Direction")
    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    /**
     * 
     * @return
     *     The Line
     */
    @JsonProperty("Line")
    public it.atm.json.routeDetails.Line getLine() {
        return Line;
    }

    /**
     * 
     * @param Line
     *     The Line
     */
    @JsonProperty("Line")
    public void setLine(it.atm.json.routeDetails.Line Line) {
        this.Line = Line;
    }

    /**
     * 
     * @return
     *     The Stops
     */
    @JsonProperty("Stops")
    public List<Stop> getStops() {
        return Stops;
    }

    /**
     * 
     * @param Stops
     *     The Stops
     */
    @JsonProperty("Stops")
    public void setStops(List<Stop> Stops) {
        this.Stops = Stops;
    }

    /**
     * 
     * @return
     *     The Geometry
     */
    @JsonProperty("Geometry")
    public it.atm.json.routeDetails.Geometry getGeometry() {
        return Geometry;
    }

    /**
     * 
     * @param Geometry
     *     The Geometry
     */
    @JsonProperty("Geometry")
    public void setGeometry(it.atm.json.routeDetails.Geometry Geometry) {
        this.Geometry = Geometry;
    }

    /**
     * 
     * @return
     *     The Links
     */
    @JsonProperty("Links")
    public List<Link_> getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    @JsonProperty("Links")
    public void setLinks(List<Link_> Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Id).append(Code).append(Direction).append(Line).append(Stops).append(Geometry).append(Links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RouteDetails) == false) {
            return false;
        }
        RouteDetails rhs = ((RouteDetails) other);
        return new EqualsBuilder().append(Id, rhs.Id).append(Code, rhs.Code).append(Direction, rhs.Direction).append(Line, rhs.Line).append(Stops, rhs.Stops).append(Geometry, rhs.Geometry).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
