
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
    "Code",
    "Description",
    "Location",
    "CustomerCode",
    "Municipality",
    "Address",
    "Telephone",
    "Fax",
    "SiteUrl",
    "Email",
    "Category",
    "Details",
    "Lines",
    "Links"
})
public class StopDetails {

    @JsonProperty("Code")
    private String Code;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Location")
    private it.atm.json.stopDetails.Location Location;
    @JsonProperty("CustomerCode")
    private String CustomerCode;
    @JsonProperty("Municipality")
    private String Municipality;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("Telephone")
    private String Telephone;
    @JsonProperty("Fax")
    private String Fax;
    @JsonProperty("SiteUrl")
    private String SiteUrl;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("Category")
    private it.atm.json.stopDetails.Category Category;
    @JsonProperty("Details")
    private it.atm.json.stopDetails.Details Details;
    @JsonProperty("Lines")
    private List<Line> Lines = new ArrayList<Line>();
    @JsonProperty("Links")
    private List<Link_> Links = new ArrayList<Link_>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    public it.atm.json.stopDetails.Location getLocation() {
        return Location;
    }

    /**
     * 
     * @param Location
     *     The Location
     */
    @JsonProperty("Location")
    public void setLocation(it.atm.json.stopDetails.Location Location) {
        this.Location = Location;
    }

    /**
     * 
     * @return
     *     The CustomerCode
     */
    @JsonProperty("CustomerCode")
    public String getCustomerCode() {
        return CustomerCode;
    }

    /**
     * 
     * @param CustomerCode
     *     The CustomerCode
     */
    @JsonProperty("CustomerCode")
    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    /**
     * 
     * @return
     *     The Municipality
     */
    @JsonProperty("Municipality")
    public String getMunicipality() {
        return Municipality;
    }

    /**
     * 
     * @param Municipality
     *     The Municipality
     */
    @JsonProperty("Municipality")
    public void setMunicipality(String Municipality) {
        this.Municipality = Municipality;
    }

    /**
     * 
     * @return
     *     The Address
     */
    @JsonProperty("Address")
    public String getAddress() {
        return Address;
    }

    /**
     * 
     * @param Address
     *     The Address
     */
    @JsonProperty("Address")
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 
     * @return
     *     The Telephone
     */
    @JsonProperty("Telephone")
    public String getTelephone() {
        return Telephone;
    }

    /**
     * 
     * @param Telephone
     *     The Telephone
     */
    @JsonProperty("Telephone")
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    /**
     * 
     * @return
     *     The Fax
     */
    @JsonProperty("Fax")
    public String getFax() {
        return Fax;
    }

    /**
     * 
     * @param Fax
     *     The Fax
     */
    @JsonProperty("Fax")
    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    /**
     * 
     * @return
     *     The SiteUrl
     */
    @JsonProperty("SiteUrl")
    public String getSiteUrl() {
        return SiteUrl;
    }

    /**
     * 
     * @param SiteUrl
     *     The SiteUrl
     */
    @JsonProperty("SiteUrl")
    public void setSiteUrl(String SiteUrl) {
        this.SiteUrl = SiteUrl;
    }

    /**
     * 
     * @return
     *     The Email
     */
    @JsonProperty("Email")
    public String getEmail() {
        return Email;
    }

    /**
     * 
     * @param Email
     *     The Email
     */
    @JsonProperty("Email")
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * 
     * @return
     *     The Category
     */
    @JsonProperty("Category")
    public it.atm.json.stopDetails.Category getCategory() {
        return Category;
    }

    /**
     * 
     * @param Category
     *     The Category
     */
    @JsonProperty("Category")
    public void setCategory(it.atm.json.stopDetails.Category Category) {
        this.Category = Category;
    }

    /**
     * 
     * @return
     *     The Details
     */
    @JsonProperty("Details")
    public it.atm.json.stopDetails.Details getDetails() {
        return Details;
    }

    /**
     * 
     * @param Details
     *     The Details
     */
    @JsonProperty("Details")
    public void setDetails(it.atm.json.stopDetails.Details Details) {
        this.Details = Details;
    }

    /**
     * 
     * @return
     *     The Lines
     */
    @JsonProperty("Lines")
    public List<Line> getLines() {
        return Lines;
    }

    /**
     * 
     * @param Lines
     *     The Lines
     */
    @JsonProperty("Lines")
    public void setLines(List<Line> Lines) {
        this.Lines = Lines;
    }

    /**
     * 
     * @return
     *     The Links
     */
    @JsonProperty("Links")
    public List<Link_> getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    @JsonProperty("Links")
    public void setLinks(List<Link_> Links) {
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
        return new HashCodeBuilder().append(Code).append(Description).append(Location).append(CustomerCode).append(Municipality).append(Address).append(Telephone).append(Fax).append(SiteUrl).append(Email).append(Category).append(Details).append(Lines).append(Links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StopDetails) == false) {
            return false;
        }
        StopDetails rhs = ((StopDetails) other);
        return new EqualsBuilder().append(Code, rhs.Code).append(Description, rhs.Description).append(Location, rhs.Location).append(CustomerCode, rhs.CustomerCode).append(Municipality, rhs.Municipality).append(Address, rhs.Address).append(Telephone, rhs.Telephone).append(Fax, rhs.Fax).append(SiteUrl, rhs.SiteUrl).append(Email, rhs.Email).append(Category, rhs.Category).append(Details, rhs.Details).append(Lines, rhs.Lines).append(Links, rhs.Links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
