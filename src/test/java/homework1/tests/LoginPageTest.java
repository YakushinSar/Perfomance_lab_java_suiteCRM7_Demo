package homework1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "Проверка входа в систему с валидными данными",
            testName = "Успешная авторизация на странице LoginPage",
            priority = 1)
    public void checkLoginWithPositiveCred() {
        loginPage.openLoginPage();
        loginPage.loginInLoginPage("will", "will");

        Assert.assertEquals(driver.getCurrentUrl(), mainPage.MAINPAGE_URL);
    }
}
