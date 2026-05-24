package homework3.factory;

import com.github.javafaker.Faker;
import homework3.dto.OpportunityDTO;

public class OpportunityFactory {

    private static final Faker faker = new Faker();

    public static OpportunityDTO getRandomOpportunity() {
        return new OpportunityDTO(
                faker.company().name() + " Opp",           // name
                faker.company().name(),                    // accountName
                faker.date().future(30, java.util.concurrent.TimeUnit.DAYS).toString(), // closeDate
                String.valueOf(faker.number().numberBetween(1000, 100000)), // amount
                getRandomSalesStage(),                     // salesStage
                getRandomType(),                           // type
                getRandomLeadSource(),                     // leadSource
                faker.lorem().sentence(),                  // nextStep
                faker.company().name(),                    // campaign
                faker.lorem().sentence()                   // description
        );
    }

    public static OpportunityDTO getOpportunityWithSalesStage(String salesStage) {
        return new OpportunityDTO(
                faker.company().name() + " Opp " + System.currentTimeMillis(),
                faker.company().name(),
                faker.date().future(30, java.util.concurrent.TimeUnit.DAYS).toString(),
                String.valueOf(faker.number().numberBetween(1000, 100000)),
                salesStage,                              // ← заданный salesStage
                getRandomType(),
                getRandomLeadSource(),
                faker.lorem().sentence(),
                faker.company().name(),
                faker.lorem().sentence()
        );
    }

    private static String getRandomSalesStage() {
        String[] stages = {"Prospecting", "Qualification", "Needs Analysis", "Value Proposition", "Closing"};
        return stages[faker.random().nextInt(stages.length)];
    }

    private static String getRandomType() {
        String[] types = {"New Business", "Existing Business", "Replacement"};
        return types[faker.random().nextInt(types.length)];
    }

    private static String getRandomLeadSource() {
        String[] sources = {"Cold Call", "Email", "Partner", "Website", "Referral"};
        return sources[faker.random().nextInt(sources.length)];
    }
}