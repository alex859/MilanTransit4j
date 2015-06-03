
package it.atm.json.timetables;

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
    "DayType",
    "Schedule"
})
public class TimeSchedule {

    @JsonProperty("DayType")
    private it.atm.json.timetables.DayType DayType;
    @JsonProperty("Schedule")
    private List<it.atm.json.timetables.Schedule> Schedule = new ArrayList<it.atm.json.timetables.Schedule>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DayType
     */
    @JsonProperty("DayType")
    public it.atm.json.timetables.DayType getDayType() {
        return DayType;
    }

    /**
     * 
     * @param DayType
     *     The DayType
     */
    @JsonProperty("DayType")
    public void setDayType(it.atm.json.timetables.DayType DayType) {
        this.DayType = DayType;
    }

    /**
     * 
     * @return
     *     The Schedule
     */
    @JsonProperty("Schedule")
    public List<it.atm.json.timetables.Schedule> getSchedule() {
        return Schedule;
    }

    /**
     * 
     * @param Schedule
     *     The Schedule
     */
    @JsonProperty("Schedule")
    public void setSchedule(List<it.atm.json.timetables.Schedule> Schedule) {
        this.Schedule = Schedule;
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
        return new HashCodeBuilder().append(DayType).append(Schedule).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimeSchedule) == false) {
            return false;
        }
        TimeSchedule rhs = ((TimeSchedule) other);
        return new EqualsBuilder().append(DayType, rhs.DayType).append(Schedule, rhs.Schedule).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
