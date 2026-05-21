package homework3.factory;

import com.github.javafaker.Faker;
import homework3.dto.AccountDTO;

public class AccountFactory {

    private static final Faker faker = new Faker();

    // Полностью случайный аккаунт
    public static AccountDTO getRandomAccount() {
        return new AccountDTO(
                faker.company().name(),                    // name
                faker.phoneNumber().phoneNumber(),         // phone
                faker.phoneNumber().phoneNumber(),         // fax
                faker.internet().url(),                    // website
                faker.internet().emailAddress(),           // email
                faker.address().streetAddress(),           // street
                faker.address().city(),                    // city
                faker.address().state(),                   // state
                faker.address().zipCode(),                 // postalCode
                faker.address().country(),                 // country
                getRandomType(),                           // type (случайный)
                getRandomIndustry(),                       // industry (случайный)
                faker.lorem().sentence()                   // description
        );
    }

    // Аккаунт с заданными type и industry
    public static AccountDTO getAccountWithTypeAndIndustry(String type, String industry) {
        return new AccountDTO(
                faker.company().name(),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().url(),
                faker.internet().emailAddress(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                type,
                industry,
                faker.lorem().sentence()
        );
    }

    // метод для лучайный тип аккаунта
    private static String getRandomType() {
        String[] types = {"Customer", "Investor", "Partner", "Analyst", "Competitor"};
        return types[faker.random().nextInt(types.length)];
    }

    // метод для случайная индустрия
    private static String getRandomIndustry() {
        String[] industries = {"Banking", "Technology", "Healthcare", "Education", "Retail"};
        return industries[faker.random().nextInt(industries.length)];
    }
}