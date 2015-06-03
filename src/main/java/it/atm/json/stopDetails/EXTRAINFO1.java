
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
    "Info",
    "DataType"
})
public class EXTRAINFO1 {

    @JsonProperty("Info")
    private String Info;
    @JsonProperty("DataType")
    private Integer DataType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Info
     */
    @JsonProperty("Info")
    public String getInfo() {
        return Info;
    }

    /**
     * 
     * @param Info
     *     The Info
     */
    @JsonProperty("Info")
    public void setInfo(String Info) {
        this.Info = Info;
    }

    /**
     * 
     * @return
     *     The DataType
     */
    @JsonProperty("DataType")
    public Integer getDataType() {
        return DataType;
    }

    /**
     * 
     * @param DataType
     *     The DataType
     */
    @JsonProperty("DataType")
    public void setDataType(Integer DataType) {
        this.DataType = DataType;
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
        return new HashCodeBuilder().append(Info).append(DataType).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EXTRAINFO1) == false) {
            return false;
        }
        EXTRAINFO1 rhs = ((EXTRAINFO1) other);
        return new EqualsBuilder().append(Info, rhs.Info).append(DataType, rhs.DataType).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
