package homework1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAccountPageTest extends BaseTest {
    @Test(description = "Создание нового аккаунта на AddAccountPage",
            testName = "Успешное создание аккаунта",
            priority = 1)
    public void checkAddNewAccount() {
        loginPage.openLoginPage();
        loginPage.loginInLoginPage("will", "will");
        mainPage.goToAddAccountPage();

        String uniqueName = "Test Account " + System.currentTimeMillis();

        addAccountPage.createAccount(
                uniqueName,                    // name
                "+123456",                     // phone
                "+1234567",                    // fax
                "avito.ru",                    // website
                "test@mail.com",               // email
                "Test Street",                 // street
                "Test City",                   // city
                "Test State",                  // state
                "12345",                       // postalCode
                "Test Country",                // country
                "Investor",                    // type
                "Banking",                     // industry
                "Test description"             // description
        );
        addAccountPage.clickSave();

        // Проверка, что аккаунт создан
        Assert.assertTrue(accountPage.isAccountCreated(uniqueName),
                "Аккаунт '" + uniqueName + "' не был создан");
    }
}

