package homework2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

    private final By PAGE_LOADED_INDICATOR = By.xpath("//span[contains(@class, 'module-title')]");

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public AccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    public boolean isAccountCreated(String accountName) {
        By accountLocator = By.xpath("//span[contains(text(), '" + accountName + "')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
