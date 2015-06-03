
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
    "OperatorCode",
    "LineCode",
    "LineDescription",
    "Suburban",
    "TransportMode",
    "Links"
})
public class Line {

    @JsonProperty("OperatorCode")
    private String OperatorCode;
    @JsonProperty("LineCode")
    private String LineCode;
    @JsonProperty("LineDescription")
    private String LineDescription;
    @JsonProperty("Suburban")
    private Boolean Suburban;
    @JsonProperty("TransportMode")
    private Integer TransportMode;
    @JsonProperty("Links")
    private List<Object> Links = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OperatorCode
     */
    @JsonProperty("OperatorCode")
    public String getOperatorCode() {
        return OperatorCode;
    }

    /**
     * 
     * @param OperatorCode
     *     The OperatorCode
     */
    @JsonProperty("OperatorCode")
    public void setOperatorCode(String OperatorCode) {
        this.OperatorCode = OperatorCode;
    }

    /**
     * 
     * @return
     *     The LineCode
     */
    @JsonProperty("LineCode")
    public String getLineCode() {
        return LineCode;
    }

    /**
     * 
     * @param LineCode
     *     The LineCode
     */
    @JsonProperty("LineCode")
    public void setLineCode(String LineCode) {
        this.LineCode = LineCode;
    }

    /**
     * 
     * @return
     *     The LineDescription
     */
    @JsonProperty("LineDescription")
    public String getLineDescription() {
        return LineDescription;
    }

    /**
     * 
     * @param LineDescription
     *     The LineDescription
     */
    @JsonProperty("LineDescription")
    public void setLineDescription(String LineDescription) {
        this.LineDescription = LineDescription;
    }

    /**
     * 
     * @return
     *     The Suburban
     */
    @JsonProperty("Suburban")
    public Boolean getSuburban() {
        return Suburban;
    }

    /**
     * 
     * @param Suburban
     *     The Suburban
     */
    @JsonProperty("Suburban")
    public void setSuburban(Boolean Suburban) {
        this.Suburban = Suburban;
    }

    /**
     * 
     * @return
     *     The TransportMode
     */
    @JsonProperty("TransportMode")
    public Integer getTransportMode() {
        return TransportMode;
    }

    /**
     * 
     * @param TransportMode
     *     The TransportMode
     */
    @JsonProperty("TransportMode")
    public void setTransportMode(Integer TransportMode) {
        this.TransportMode = TransportMode;
    }

    /**
     * 
     * @return
     *     The Links
     */
    @JsonProperty("Links")
    public List<Object> getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    @JsonProperty("Links")
    public void setLinks(List<Object> Links) {
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
        return new HashCodeBuilder().append(OperatorCode).append(LineCode).append(LineDescription).append(Suburban).append(TransportMode).append(Links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Line) == false) {
            return false;
        }
        Line rhs = ((Line) other);
        return new EqualsBuilder().append(OperatorCode, rhs.OperatorCode).append(LineCode, rhs.LineCode).append(LineDescription, rhs.LineDescription).append(Suburban, rhs.Suburban).append(TransportMode, rhs.TransportMode).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
