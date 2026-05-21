package homework3.tests;

import homework3.pages.LoginPage;
import homework3.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = Retry.class)
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