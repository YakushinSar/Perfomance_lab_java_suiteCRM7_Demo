package homework1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test(description = "Проверка перехода на страницу AddAccountPage",
            testName = "Переход на страницу создания нового аккаунта AddAccountPage",
            priority = 1)
    public void testCreateAccount() {
        loginPage.openLoginPage();
        loginPage.loginInLoginPage("will", "will");
        mainPage.goToAddAccountPage();

        Assert.assertTrue(addAccountPage.isPageOpened(), "Страница создания аккаунта не загрузилась!");
    }
}
