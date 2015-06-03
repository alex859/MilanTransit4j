
package it.atm.json.routeDetails;

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
    "Rel",
    "Href",
    "Title"
})
public class Link_ {

    @JsonProperty("Rel")
    private String Rel;
    @JsonProperty("Href")
    private String Href;
    @JsonProperty("Title")
    private Object Title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Rel
     */
    @JsonProperty("Rel")
    public String getRel() {
        return Rel;
    }

    /**
     * 
     * @param Rel
     *     The Rel
     */
    @JsonProperty("Rel")
    public void setRel(String Rel) {
        this.Rel = Rel;
    }

    /**
     * 
     * @return
     *     The Href
     */
    @JsonProperty("Href")
    public String getHref() {
        return Href;
    }

    /**
     * 
     * @param Href
     *     The Href
     */
    @JsonProperty("Href")
    public void setHref(String Href) {
        this.Href = Href;
    }

    /**
     * 
     * @return
     *     The Title
     */
    @JsonProperty("Title")
    public Object getTitle() {
        return Title;
    }

    /**
     * 
     * @param Title
     *     The Title
     */
    @JsonProperty("Title")
    public void setTitle(Object Title) {
        this.Title = Title;
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
        return new HashCodeBuilder().append(Rel).append(Href).append(Title).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link_) == false) {
            return false;
        }
        Link_ rhs = ((Link_) other);
        return new EqualsBuilder().append(Rel, rhs.Rel).append(Href, rhs.Href).append(Title, rhs.Title).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
