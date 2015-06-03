
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
    "LineId",
    "OperatorCode",
    "LineCode",
    "LineDescription",
    "TransportMode",
    "Suburban"
})
public class Line_ {

    @JsonProperty("LineId")
    private String LineId;
    @JsonProperty("OperatorCode")
    private String OperatorCode;
    @JsonProperty("LineCode")
    private String LineCode;
    @JsonProperty("LineDescription")
    private String LineDescription;
    @JsonProperty("TransportMode")
    private Integer TransportMode;
    @JsonProperty("Suburban")
    private Boolean Suburban;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The LineId
     */
    @JsonProperty("LineId")
    public String getLineId() {
        return LineId;
    }

    /**
     * 
     * @param LineId
     *     The LineId
     */
    @JsonProperty("LineId")
    public void setLineId(String LineId) {
        this.LineId = LineId;
    }

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
        return new HashCodeBuilder().append(LineId).append(OperatorCode).append(LineCode).append(LineDescription).append(TransportMode).append(Suburban).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Line_) == false) {
            return false;
        }
        Line_ rhs = ((Line_) other);
        return new EqualsBuilder().append(LineId, rhs.LineId).append(OperatorCode, rhs.OperatorCode).append(LineCode, rhs.LineCode).append(LineDescription, rhs.LineDescription).append(TransportMode, rhs.TransportMode).append(Suburban, rhs.Suburban).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
