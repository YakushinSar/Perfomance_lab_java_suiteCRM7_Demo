package homework2.dto;

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

    public OpportunityDTO(String name, String accountName, String closeDate,
                          String amount, String salesStage, String type,
                          String leadSource, String nextStep, String campaign,
                          String description) {
        this.name = name;
        this.accountName = accountName;
        this.closeDate = closeDate;
        this.amount = amount;
        this.salesStage = salesStage;
        this.type = type;
        this.leadSource = leadSource;
        this.nextStep = nextStep;
        this.campaign = campaign;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public String getAmount() {
        return amount;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public String getType() {
        return type;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getNextStep() {
        return nextStep;
    }

    public String getCampaign() {
        return campaign;
    }

    public String getDescription() {
        return description;
    }
}