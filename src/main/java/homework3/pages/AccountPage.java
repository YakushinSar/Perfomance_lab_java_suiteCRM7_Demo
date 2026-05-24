package homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class AccountPage extends BasePage {

    private final By PAGE_LOADED_INDICATOR = By.xpath("//span[contains(@class, 'module-title')]");

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public AccountPage isPageOpened() {
        log.info("Waiting for Account page to load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    public boolean isAccountCreated(String accountName) {
        log.info("Checking if account '{}' was created", accountName);
        By accountLocator = By.xpath("//span[contains(text(), '" + accountName + "')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
