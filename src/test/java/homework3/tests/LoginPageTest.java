package homework3.tests;

import homework3.pages.LoginPage;
import homework3.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = Retry.class)
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