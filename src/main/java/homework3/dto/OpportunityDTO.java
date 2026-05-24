package homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class OpportunityDTO {
    private String name;
    private String accountName;
    private String closeDate;
    private String amount;
    private String salesStage;
    private String type;
    private String leadSource;
    private String nextStep;
    private String campaign;
    private String description;

}