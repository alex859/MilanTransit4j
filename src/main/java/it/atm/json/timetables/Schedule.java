
package it.atm.json.timetables;

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
    "Hour",
    "ScheduleDetail",
    "NightDetail"
})
public class Schedule {

    @JsonProperty("Hour")
    private Integer Hour;
    @JsonProperty("ScheduleDetail")
    private String ScheduleDetail;
    @JsonProperty("NightDetail")
    private String NightDetail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Hour
     */
    @JsonProperty("Hour")
    public Integer getHour() {
        return Hour;
    }

    /**
     * 
     * @param Hour
     *     The Hour
     */
    @JsonProperty("Hour")
    public void setHour(Integer Hour) {
        this.Hour = Hour;
    }

    /**
     * 
     * @return
     *     The ScheduleDetail
     */
    @JsonProperty("ScheduleDetail")
    public String getScheduleDetail() {
        return ScheduleDetail;
    }

    /**
     * 
     * @param ScheduleDetail
     *     The ScheduleDetail
     */
    @JsonProperty("ScheduleDetail")
    public void setScheduleDetail(String ScheduleDetail) {
        this.ScheduleDetail = ScheduleDetail;
    }

    /**
     * 
     * @return
     *     The NightDetail
     */
    @JsonProperty("NightDetail")
    public String getNightDetail() {
        return NightDetail;
    }

    /**
     * 
     * @param NightDetail
     *     The NightDetail
     */
    @JsonProperty("NightDetail")
    public void setNightDetail(String NightDetail) {
        this.NightDetail = NightDetail;
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
        return new HashCodeBuilder().append(Hour).append(ScheduleDetail).append(NightDetail).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Schedule) == false) {
            return false;
        }
        Schedule rhs = ((Schedule) other);
        return new EqualsBuilder().append(Hour, rhs.Hour).append(ScheduleDetail, rhs.ScheduleDetail).append(NightDetail, rhs.NightDetail).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
