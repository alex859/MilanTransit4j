
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
    "Code",
    "Description",
    "Location",
    "PointType",
    "Links"
})
public class Stop {

    @JsonProperty("OperatorCode")
    private String OperatorCode;
    @JsonProperty("Code")
    private String Code;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Location")
    private it.atm.json.routeDetails.Location Location;
    @JsonProperty("PointType")
    private Integer PointType;
    @JsonProperty("Links")
    private List<Link> Links = new ArrayList<Link>();
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
     *     The Description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    /**
     * 
     * @param Description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 
     * @return
     *     The Location
     */
    @JsonProperty("Location")
    public it.atm.json.routeDetails.Location getLocation() {
        return Location;
    }

    /**
     * 
     * @param Location
     *     The Location
     */
    @JsonProperty("Location")
    public void setLocation(it.atm.json.routeDetails.Location Location) {
        this.Location = Location;
    }

    /**
     * 
     * @return
     *     The PointType
     */
    @JsonProperty("PointType")
    public Integer getPointType() {
        return PointType;
    }

    /**
     * 
     * @param PointType
     *     The PointType
     */
    @JsonProperty("PointType")
    public void setPointType(Integer PointType) {
        this.PointType = PointType;
    }

    /**
     * 
     * @return
     *     The Links
     */
    @JsonProperty("Links")
    public List<Link> getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    @JsonProperty("Links")
    public void setLinks(List<Link> Links) {
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
        return new HashCodeBuilder().append(OperatorCode).append(Code).append(Description).append(Location).append(PointType).append(Links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stop) == false) {
            return false;
        }
        Stop rhs = ((Stop) other);
        return new EqualsBuilder().append(OperatorCode, rhs.OperatorCode).append(Code, rhs.Code).append(Description, rhs.Description).append(Location, rhs.Location).append(PointType, rhs.PointType).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
