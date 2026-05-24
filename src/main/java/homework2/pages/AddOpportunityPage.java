package homework2.pages;

import homework2.dto.OpportunityDTO;
import homework2.wrappers.Input;
import homework2.wrappers.Select;
import homework2.wrappers.Textarea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOpportunityPage extends BasePage {

    private final By PAGE_LOADED_INDICATOR = By.xpath("//h2[normalize-space()='CREATE']");

    public AddOpportunityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public AddOpportunityPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    // Новый метод с DTO
    public AddOpportunityPage createOpportunity(OpportunityDTO opportunity) {
        new Input(driver, "Opportunity Name").write(opportunity.getName());
        new Input(driver, "Account Name").write(opportunity.getAccountName());
        new Input(driver, "Expected Close Date").write(opportunity.getCloseDate());
        new Input(driver, "Opportunity Amount").write(opportunity.getAmount());
        new Select(driver, "Sales Stage").select(opportunity.getSalesStage());
        new Select(driver, "Type").select(opportunity.getType());
        new Select(driver, "Lead Source").select(opportunity.getLeadSource());
        new Input(driver, "Next Step").write(opportunity.getNextStep());
        new Input(driver, "Campaign").write(opportunity.getCampaign());
        new Textarea(driver, "description").write(opportunity.getDescription());
        return this;
    }

    // Старый метод, создаёт новую возможность Opportunity
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
    public OpportunityPage clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new OpportunityPage(driver, wait);
    }
}
