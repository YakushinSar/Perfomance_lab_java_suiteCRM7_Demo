package homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class MainPage extends BasePage {

    public final String MAINPAGE_URL = "https://demo.suiteondemand.com/index.php?module=Home&action=Demo";
    private final By PAGE_LOADED_INDICATOR = By.xpath("//a[@id='moduleTab_Home']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public MainPage isPageOpened() {
        log.info("Waiting for Main page to load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    //    переход на страницу AddAccountPage
    public AddAccountPage goToAddAccountPage() {
        log.info("Navigating to Add Account page");
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
        return new AddAccountPage(driver, wait);
    }

    //    переход на страницу OpportunityPage
    public AddOpportunityPage goToAddOpportunityPage() {
        log.info("Navigating to Add Opportunity page");
        driver.get("https://demo.suiteondemand.com/index.php?module=Opportunities&action=EditView&return_module=Opportunities&return_action=DetailView");
        return new AddOpportunityPage(driver, wait);
    }
}


