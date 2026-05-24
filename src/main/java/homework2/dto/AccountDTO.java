package homework2.dto;

public class AccountDTO {
    private String name;
    private String phone;
    private String fax;
    private String website;
    private String email;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String type;
    private String industry;
    private String description;

    public AccountDTO(String name, String phone, String fax, String website,
                      String email, String street, String city, String state,
                      String postalCode, String country, String type,
                      String industry, String description) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.website = website;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.type = type;
        this.industry = industry;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }

    public String getDescription() {
        return description;
    }
}