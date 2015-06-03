
package it.atm.json.allRoutes;

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
    "JourneyPatterns",
    "Links"
})
public class AllRoutesResponse {

    @JsonProperty("JourneyPatterns")
    private List<JourneyPattern> JourneyPatterns = new ArrayList<JourneyPattern>();
    @JsonProperty("Links")
    private List<Link_> Links = new ArrayList<Link_>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The JourneyPatterns
     */
    @JsonProperty("JourneyPatterns")
    public List<JourneyPattern> getJourneyPatterns() {
        return JourneyPatterns;
    }

    /**
     * 
     * @param JourneyPatterns
     *     The JourneyPatterns
     */
    @JsonProperty("JourneyPatterns")
    public void setJourneyPatterns(List<JourneyPattern> JourneyPatterns) {
        this.JourneyPatterns = JourneyPatterns;
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
        return new HashCodeBuilder().append(JourneyPatterns).append(Links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllRoutesResponse) == false) {
            return false;
        }
        AllRoutesResponse rhs = ((AllRoutesResponse) other);
        return new EqualsBuilder().append(JourneyPatterns, rhs.JourneyPatterns).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
