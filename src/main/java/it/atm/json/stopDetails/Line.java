
package it.atm.json.stopDetails;

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
    "Line",
    "Direction",
    "BookletUrl",
    "WaitMessage",
    "JourneyPatternId",
    "TrafficBulletins",
    "Links"
})
public class Line {

    @JsonProperty("Line")
    private Line_ Line;
    @JsonProperty("Direction")
    private String Direction;
    @JsonProperty("BookletUrl")
    private String BookletUrl;
    @JsonProperty("WaitMessage")
    private Object WaitMessage;
    @JsonProperty("JourneyPatternId")
    private String JourneyPatternId;
    @JsonProperty("TrafficBulletins")
    private List<Object> TrafficBulletins = new ArrayList<Object>();
    @JsonProperty("Links")
    private List<Link> Links = new ArrayList<Link>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Line
     */
    @JsonProperty("Line")
    public Line_ getLine() {
        return Line;
    }

    /**
     * 
     * @param Line
     *     The Line
     */
    @JsonProperty("Line")
    public void setLine(Line_ Line) {
        this.Line = Line;
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
     *     The BookletUrl
     */
    @JsonProperty("BookletUrl")
    public String getBookletUrl() {
        return BookletUrl;
    }

    /**
     * 
     * @param BookletUrl
     *     The BookletUrl
     */
    @JsonProperty("BookletUrl")
    public void setBookletUrl(String BookletUrl) {
        this.BookletUrl = BookletUrl;
    }

    /**
     * 
     * @return
     *     The WaitMessage
     */
    @JsonProperty("WaitMessage")
    public Object getWaitMessage() {
        return WaitMessage;
    }

    /**
     * 
     * @param WaitMessage
     *     The WaitMessage
     */
    @JsonProperty("WaitMessage")
    public void setWaitMessage(Object WaitMessage) {
        this.WaitMessage = WaitMessage;
    }

    /**
     * 
     * @return
     *     The JourneyPatternId
     */
    @JsonProperty("JourneyPatternId")
    public String getJourneyPatternId() {
        return JourneyPatternId;
    }

    /**
     * 
     * @param JourneyPatternId
     *     The JourneyPatternId
     */
    @JsonProperty("JourneyPatternId")
    public void setJourneyPatternId(String JourneyPatternId) {
        this.JourneyPatternId = JourneyPatternId;
    }

    /**
     * 
     * @return
     *     The TrafficBulletins
     */
    @JsonProperty("TrafficBulletins")
    public List<Object> getTrafficBulletins() {
        return TrafficBulletins;
    }

    /**
     * 
     * @param TrafficBulletins
     *     The TrafficBulletins
     */
    @JsonProperty("TrafficBulletins")
    public void setTrafficBulletins(List<Object> TrafficBulletins) {
        this.TrafficBulletins = TrafficBulletins;
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
        return new HashCodeBuilder().append(Line).append(Direction).append(BookletUrl).append(WaitMessage).append(JourneyPatternId).append(TrafficBulletins).append(Links).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(Line, rhs.Line).append(Direction, rhs.Direction).append(BookletUrl, rhs.BookletUrl).append(WaitMessage, rhs.WaitMessage).append(JourneyPatternId, rhs.JourneyPatternId).append(TrafficBulletins, rhs.TrafficBulletins).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
