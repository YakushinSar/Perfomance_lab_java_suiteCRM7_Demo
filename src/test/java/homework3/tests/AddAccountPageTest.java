package homework3.tests;

import homework3.dto.AccountDTO;
import homework3.pages.LoginPage;
import homework3.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = Retry.class)
public class AddAccountPageTest extends BaseTest {

    @Test(description = "Создание нового аккаунта на AddAccountPage",
            testName = "Успешное создание аккаунта",
            priority = 1)
    public void checkAddNewAccount() {
        String uniqueName = "Test Account " + System.currentTimeMillis();

        AccountDTO account = new AccountDTO(
                uniqueName, "+123456", "+1234567", "avito.ru",
                "test@mail.com", "Test Street", "Test City", "Test State",
                "12345", "Test Country", "Investor", "Banking", "Test description"
        );

        boolean isCreated = new LoginPage(driver, wait)
                .openLoginPage()
                .isPageOpened()
                .loginInLoginPage("will", "will")
                .isPageOpened()
                .goToAddAccountPage()
                .isPageOpened()
                .createAccount(account)
                .clickSave()
                .isPageOpened()
                .isAccountCreated(uniqueName);

        Assert.assertTrue(isCreated, "Аккаунт '" + uniqueName + "' не был создан");
    }
}