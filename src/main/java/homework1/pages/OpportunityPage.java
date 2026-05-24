package homework1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpportunityPage extends BasePage {

    public OpportunityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Проверяет, была ли создана Возможность с указанным названием
    public boolean isOpportunityCreated(String opportunityName) {
        By locator = By.xpath("//span[contains(text(), '" + opportunityName + "')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
