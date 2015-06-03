
package it.atm.json.routeGeometry;

import java.util.HashMap;
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
    "X",
    "Y"
})
public class Point {

    @JsonProperty("X")
    private Double X;
    @JsonProperty("Y")
    private Double Y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The X
     */
    @JsonProperty("X")
    public Double getX() {
        return X;
    }

    /**
     * 
     * @param X
     *     The X
     */
    @JsonProperty("X")
    public void setX(Double X) {
        this.X = X;
    }

    /**
     * 
     * @return
     *     The Y
     */
    @JsonProperty("Y")
    public Double getY() {
        return Y;
    }

    /**
     * 
     * @param Y
     *     The Y
     */
    @JsonProperty("Y")
    public void setY(Double Y) {
        this.Y = Y;
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
        return new HashCodeBuilder().append(X).append(Y).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Point) == false) {
            return false;
        }
        Point rhs = ((Point) other);
        return new EqualsBuilder().append(X, rhs.X).append(Y, rhs.Y).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
