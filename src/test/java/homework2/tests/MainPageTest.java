package homework2.tests;

import homework2.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test(description = "Проверка перехода на страницу AddAccountPage",
            testName = "Переход на страницу создания нового аккаунта AddAccountPage",
            priority = 1)
    public void testCreateAccount() {
        boolean isOpened = new LoginPage(driver, wait)
                .openLoginPage()
                .isPageOpened()
                .loginInLoginPage("will", "will")
                .isPageOpened()
                .goToAddAccountPage()
                .isPageOpened() != null;

        Assert.assertTrue(isOpened, "Страница создания аккаунта не загрузилась!");
    }
}