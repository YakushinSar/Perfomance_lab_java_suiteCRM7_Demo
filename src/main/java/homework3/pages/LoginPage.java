package homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='username_password']");
    private final By LOGIN_BUTTON = By.xpath("//input[@id='bigbutton']");
    private final By MAIN_PAGE_LOADED = By.xpath("//a[@id='moduleTab_Home']");
    private final By PAGE_LOADED_INDICATOR = By.xpath("//input[@id='bigbutton']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public LoginPage isPageOpened() {
        log.info("Waiting for Login page to load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    //  открыть страницу LoginPage
    public LoginPage openLoginPage() {
        log.info("Opening login page: {}", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    //  авторизация на LoginPage
    public MainPage loginInLoginPage(String username, String password) {
        log.info("Logging in with username: '{}'", username);
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_LOADED));
        return new MainPage(driver, wait);
    }
}
