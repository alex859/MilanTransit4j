
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
    "DayTypeDescription",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat",
    "Sun",
    "Hol"
})
public class DayType {

    @JsonProperty("DayTypeDescription")
    private String DayTypeDescription;
    @JsonProperty("Mon")
    private Boolean Mon;
    @JsonProperty("Tue")
    private Boolean Tue;
    @JsonProperty("Wed")
    private Boolean Wed;
    @JsonProperty("Thu")
    private Boolean Thu;
    @JsonProperty("Fri")
    private Boolean Fri;
    @JsonProperty("Sat")
    private Boolean Sat;
    @JsonProperty("Sun")
    private Boolean Sun;
    @JsonProperty("Hol")
    private Boolean Hol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DayTypeDescription
     */
    @JsonProperty("DayTypeDescription")
    public String getDayTypeDescription() {
        return DayTypeDescription;
    }

    /**
     * 
     * @param DayTypeDescription
     *     The DayTypeDescription
     */
    @JsonProperty("DayTypeDescription")
    public void setDayTypeDescription(String DayTypeDescription) {
        this.DayTypeDescription = DayTypeDescription;
    }

    /**
     * 
     * @return
     *     The Mon
     */
    @JsonProperty("Mon")
    public Boolean getMon() {
        return Mon;
    }

    /**
     * 
     * @param Mon
     *     The Mon
     */
    @JsonProperty("Mon")
    public void setMon(Boolean Mon) {
        this.Mon = Mon;
    }

    /**
     * 
     * @return
     *     The Tue
     */
    @JsonProperty("Tue")
    public Boolean getTue() {
        return Tue;
    }

    /**
     * 
     * @param Tue
     *     The Tue
     */
    @JsonProperty("Tue")
    public void setTue(Boolean Tue) {
        this.Tue = Tue;
    }

    /**
     * 
     * @return
     *     The Wed
     */
    @JsonProperty("Wed")
    public Boolean getWed() {
        return Wed;
    }

    /**
     * 
     * @param Wed
     *     The Wed
     */
    @JsonProperty("Wed")
    public void setWed(Boolean Wed) {
        this.Wed = Wed;
    }

    /**
     * 
     * @return
     *     The Thu
     */
    @JsonProperty("Thu")
    public Boolean getThu() {
        return Thu;
    }

    /**
     * 
     * @param Thu
     *     The Thu
     */
    @JsonProperty("Thu")
    public void setThu(Boolean Thu) {
        this.Thu = Thu;
    }

    /**
     * 
     * @return
     *     The Fri
     */
    @JsonProperty("Fri")
    public Boolean getFri() {
        return Fri;
    }

    /**
     * 
     * @param Fri
     *     The Fri
     */
    @JsonProperty("Fri")
    public void setFri(Boolean Fri) {
        this.Fri = Fri;
    }

    /**
     * 
     * @return
     *     The Sat
     */
    @JsonProperty("Sat")
    public Boolean getSat() {
        return Sat;
    }

    /**
     * 
     * @param Sat
     *     The Sat
     */
    @JsonProperty("Sat")
    public void setSat(Boolean Sat) {
        this.Sat = Sat;
    }

    /**
     * 
     * @return
     *     The Sun
     */
    @JsonProperty("Sun")
    public Boolean getSun() {
        return Sun;
    }

    /**
     * 
     * @param Sun
     *     The Sun
     */
    @JsonProperty("Sun")
    public void setSun(Boolean Sun) {
        this.Sun = Sun;
    }

    /**
     * 
     * @return
     *     The Hol
     */
    @JsonProperty("Hol")
    public Boolean getHol() {
        return Hol;
    }

    /**
     * 
     * @param Hol
     *     The Hol
     */
    @JsonProperty("Hol")
    public void setHol(Boolean Hol) {
        this.Hol = Hol;
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
        return new HashCodeBuilder().append(DayTypeDescription).append(Mon).append(Tue).append(Wed).append(Thu).append(Fri).append(Sat).append(Sun).append(Hol).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DayType) == false) {
            return false;
        }
        DayType rhs = ((DayType) other);
        return new EqualsBuilder().append(DayTypeDescription, rhs.DayTypeDescription).append(Mon, rhs.Mon).append(Tue, rhs.Tue).append(Wed, rhs.Wed).append(Thu, rhs.Thu).append(Fri, rhs.Fri).append(Sat, rhs.Sat).append(Sun, rhs.Sun).append(Hol, rhs.Hol).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
