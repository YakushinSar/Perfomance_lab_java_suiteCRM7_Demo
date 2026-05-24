package homework1.pages;

import homework1.wrappers.Input;
import homework1.wrappers.Select;
import homework1.wrappers.Textarea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOpportunityPage extends BasePage {

    public AddOpportunityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Создаёт новую возможность Opportunity
    public void createOpportunity(String name, String accountName, String closeDate,
                                  String amount, String salesStage, String type,
                                  String leadSource, String nextStep,
                                  String campaign, String description) {
        new Input(driver, "Opportunity Name").write(name);
        new Input(driver, "Account Name").write(accountName);
        new Input(driver, "Expected Close Date").write(closeDate);
        new Input(driver, "Opportunity Amount").write(amount);
        new Select(driver, "Sales Stage").select(salesStage);
        new Select(driver, "Type").select(type);
        new Select(driver, "Lead Source").select(leadSource);
        // Probability (%) удалён
        new Input(driver, "Next Step").write(nextStep);
        new Input(driver, "Campaign").write(campaign);
        new Textarea(driver, "description").write(description);
    }

    //Нажимает на кнопку SAVE
    public void clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
    }
}
