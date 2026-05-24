package homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class OpportunityPage extends BasePage {

    private final By PAGE_LOADED_INDICATOR = By.xpath("//span[contains(@class, 'module-title')]");

    public OpportunityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public OpportunityPage isPageOpened() {
        log.info("Waiting for Opportunity page to load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    // Проверяет, была ли создана Возможность с указанным названием
    public boolean isOpportunityCreated(String opportunityName) {
        log.info("Checking if opportunity '{}' was created", opportunityName);
        By locator = By.xpath("//span[contains(text(), '" + opportunityName + "')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
