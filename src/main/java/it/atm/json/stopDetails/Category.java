
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
    "CategoryId",
    "CategoryName",
    "HasTimeTables",
    "Icons"
})
public class Category {

    @JsonProperty("CategoryId")
    private String CategoryId;
    @JsonProperty("CategoryName")
    private String CategoryName;
    @JsonProperty("HasTimeTables")
    private Boolean HasTimeTables;
    @JsonProperty("Icons")
    private Object Icons;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The CategoryId
     */
    @JsonProperty("CategoryId")
    public String getCategoryId() {
        return CategoryId;
    }

    /**
     * 
     * @param CategoryId
     *     The CategoryId
     */
    @JsonProperty("CategoryId")
    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    /**
     * 
     * @return
     *     The CategoryName
     */
    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * 
     * @param CategoryName
     *     The CategoryName
     */
    @JsonProperty("CategoryName")
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    /**
     * 
     * @return
     *     The HasTimeTables
     */
    @JsonProperty("HasTimeTables")
    public Boolean getHasTimeTables() {
        return HasTimeTables;
    }

    /**
     * 
     * @param HasTimeTables
     *     The HasTimeTables
     */
    @JsonProperty("HasTimeTables")
    public void setHasTimeTables(Boolean HasTimeTables) {
        this.HasTimeTables = HasTimeTables;
    }

    /**
     * 
     * @return
     *     The Icons
     */
    @JsonProperty("Icons")
    public Object getIcons() {
        return Icons;
    }

    /**
     * 
     * @param Icons
     *     The Icons
     */
    @JsonProperty("Icons")
    public void setIcons(Object Icons) {
        this.Icons = Icons;
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
        return new HashCodeBuilder().append(CategoryId).append(CategoryName).append(HasTimeTables).append(Icons).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(CategoryId, rhs.CategoryId).append(CategoryName, rhs.CategoryName).append(HasTimeTables, rhs.HasTimeTables).append(Icons, rhs.Icons).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
