package homework3.tests;

import homework3.dto.AccountDTO;
import homework3.factory.AccountFactory;
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
        // Используем Factory для генерации данных
        AccountDTO account = AccountFactory.getRandomAccount();
        String uniqueName = account.getName();

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

    @Test(description = "Создание аккаунта с заданными типом и индустрией",
            testName = "Создание аккаунта с конкретными параметрами",
            priority = 2)
    public void checkAddNewAccountWithTypeAndIndustry() {
        // Используем Factory с конкретными параметрами
        AccountDTO account = AccountFactory.getAccountWithTypeAndIndustry("Investor", "Banking");
        String uniqueName = account.getName();

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