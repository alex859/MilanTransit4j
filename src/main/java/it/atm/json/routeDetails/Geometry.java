
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
    "Segments",
    "BoundingBox_NE",
    "BoundingBox_SW"
})
public class Geometry {

    @JsonProperty("Segments")
    private List<Segment> Segments = new ArrayList<Segment>();
    @JsonProperty("BoundingBox_NE")
    private it.atm.json.routeDetails.BoundingBox_NE BoundingBox_NE;
    @JsonProperty("BoundingBox_SW")
    private it.atm.json.routeDetails.BoundingBox_SW BoundingBox_SW;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Segments
     */
    @JsonProperty("Segments")
    public List<Segment> getSegments() {
        return Segments;
    }

    /**
     * 
     * @param Segments
     *     The Segments
     */
    @JsonProperty("Segments")
    public void setSegments(List<Segment> Segments) {
        this.Segments = Segments;
    }

    /**
     * 
     * @return
     *     The BoundingBox_NE
     */
    @JsonProperty("BoundingBox_NE")
    public it.atm.json.routeDetails.BoundingBox_NE getBoundingBox_NE() {
        return BoundingBox_NE;
    }

    /**
     * 
     * @param BoundingBox_NE
     *     The BoundingBox_NE
     */
    @JsonProperty("BoundingBox_NE")
    public void setBoundingBox_NE(it.atm.json.routeDetails.BoundingBox_NE BoundingBox_NE) {
        this.BoundingBox_NE = BoundingBox_NE;
    }

    /**
     * 
     * @return
     *     The BoundingBox_SW
     */
    @JsonProperty("BoundingBox_SW")
    public it.atm.json.routeDetails.BoundingBox_SW getBoundingBox_SW() {
        return BoundingBox_SW;
    }

    /**
     * 
     * @param BoundingBox_SW
     *     The BoundingBox_SW
     */
    @JsonProperty("BoundingBox_SW")
    public void setBoundingBox_SW(it.atm.json.routeDetails.BoundingBox_SW BoundingBox_SW) {
        this.BoundingBox_SW = BoundingBox_SW;
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
        return new HashCodeBuilder().append(Segments).append(BoundingBox_NE).append(BoundingBox_SW).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Geometry) == false) {
            return false;
        }
        Geometry rhs = ((Geometry) other);
        return new EqualsBuilder().append(Segments, rhs.Segments).append(BoundingBox_NE, rhs.BoundingBox_NE).append(BoundingBox_SW, rhs.BoundingBox_SW).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
