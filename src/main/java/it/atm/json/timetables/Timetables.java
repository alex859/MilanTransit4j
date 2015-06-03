
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
    "FromDate",
    "StopCode",
    "LineCode",
    "Direction",
    "TimeSchedules",
    "Notes"
})
public class Timetables {

    @JsonProperty("FromDate")
    private String FromDate;
    @JsonProperty("StopCode")
    private String StopCode;
    @JsonProperty("LineCode")
    private String LineCode;
    @JsonProperty("Direction")
    private String Direction;
    @JsonProperty("TimeSchedules")
    private List<TimeSchedule> TimeSchedules = new ArrayList<TimeSchedule>();
    @JsonProperty("Notes")
    private List<Object> Notes = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FromDate
     */
    @JsonProperty("FromDate")
    public String getFromDate() {
        return FromDate;
    }

    /**
     * 
     * @param FromDate
     *     The FromDate
     */
    @JsonProperty("FromDate")
    public void setFromDate(String FromDate) {
        this.FromDate = FromDate;
    }

    /**
     * 
     * @return
     *     The StopCode
     */
    @JsonProperty("StopCode")
    public String getStopCode() {
        return StopCode;
    }

    /**
     * 
     * @param StopCode
     *     The StopCode
     */
    @JsonProperty("StopCode")
    public void setStopCode(String StopCode) {
        this.StopCode = StopCode;
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
     *     The Direction
     */
    @JsonProperty("Direction")
    public String getDirection() {
        return Direction;
    }

    /**
     * 
     * @param Direction
     *     The Direction
     */
    @JsonProperty("Direction")
    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    /**
     * 
     * @return
     *     The TimeSchedules
     */
    @JsonProperty("TimeSchedules")
    public List<TimeSchedule> getTimeSchedules() {
        return TimeSchedules;
    }

    /**
     * 
     * @param TimeSchedules
     *     The TimeSchedules
     */
    @JsonProperty("TimeSchedules")
    public void setTimeSchedules(List<TimeSchedule> TimeSchedules) {
        this.TimeSchedules = TimeSchedules;
    }

    /**
     * 
     * @return
     *     The Notes
     */
    @JsonProperty("Notes")
    public List<Object> getNotes() {
        return Notes;
    }

    /**
     * 
     * @param Notes
     *     The Notes
     */
    @JsonProperty("Notes")
    public void setNotes(List<Object> Notes) {
        this.Notes = Notes;
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
        return new HashCodeBuilder().append(FromDate).append(StopCode).append(LineCode).append(Direction).append(TimeSchedules).append(Notes).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Timetables) == false) {
            return false;
        }
        Timetables rhs = ((Timetables) other);
        return new EqualsBuilder().append(FromDate, rhs.FromDate).append(StopCode, rhs.StopCode).append(LineCode, rhs.LineCode).append(Direction, rhs.Direction).append(TimeSchedules, rhs.TimeSchedules).append(Notes, rhs.Notes).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
