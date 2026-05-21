package homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
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

}