package homework1.tests;

import homework1.pages.AccountPage;
import homework1.pages.AddAccountPage;
import homework1.pages.LoginPage;
import homework1.pages.MainPage;
import homework1.utils.TestListener;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    AccountPage accountPage;
    AddAccountPage addAccountPage;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    @Description("Настройка браузера")
    public void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        // Неявное ожидание (запасной вариант)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Явное ожидание для конкретных проверок
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        accountPage = new AccountPage(driver, wait);
        addAccountPage = new AddAccountPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        mainPage = new MainPage(driver, wait);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
