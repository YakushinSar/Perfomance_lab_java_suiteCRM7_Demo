package homework1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='username_password']");
    private final By LOGIN_BUTTON = By.xpath("//input[@id='bigbutton']");
    private final By MAIN_PAGE_LOADED = By.xpath("//a[@id='moduleTab_Home']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //  открыть страницу LoginPage
    public void openLoginPage() {
        driver.get(BASE_URL);
    }

    //  авторизация на LoginPage
    public void loginInLoginPage(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_LOADED));
    }
}
