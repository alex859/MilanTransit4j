
package it.atm.json.stopDetails;

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
    "EXTRAINFO1"
})
public class Details {

    @JsonProperty("EXTRAINFO1")
    private it.atm.json.stopDetails.EXTRAINFO1 EXTRAINFO1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The EXTRAINFO1
     */
    @JsonProperty("EXTRAINFO1")
    public it.atm.json.stopDetails.EXTRAINFO1 getEXTRAINFO1() {
        return EXTRAINFO1;
    }

    /**
     * 
     * @param EXTRAINFO1
     *     The EXTRAINFO1
     */
    @JsonProperty("EXTRAINFO1")
    public void setEXTRAINFO1(it.atm.json.stopDetails.EXTRAINFO1 EXTRAINFO1) {
        this.EXTRAINFO1 = EXTRAINFO1;
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
        return new HashCodeBuilder().append(EXTRAINFO1).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return new EqualsBuilder().append(EXTRAINFO1, rhs.EXTRAINFO1).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
