package homework2.tests;

import homework2.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "Проверка входа в систему с валидными данными",
            testName = "Успешная авторизация на странице LoginPage",
            priority = 1)
    public void checkLoginWithPositiveCred() {
        new LoginPage(driver, wait)
                .openLoginPage()
                .isPageOpened()
                .loginInLoginPage("will", "will")
                .isPageOpened();

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://demo.suiteondemand.com/index.php?module=Home&action=Demo");
    }
}