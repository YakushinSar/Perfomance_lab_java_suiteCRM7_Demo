package homework2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public final String MAINPAGE_URL = "https://demo.suiteondemand.com/index.php?module=Home&action=Demo";
    private final By PAGE_LOADED_INDICATOR = By.xpath("//a[@id='moduleTab_Home']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public MainPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    //    переход на страницу AddAccountPage
    public AddAccountPage goToAddAccountPage() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
        return new AddAccountPage(driver, wait);
    }

    //    переход на страницу OpportunityPage
    public AddOpportunityPage goToAddOpportunityPage() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Opportunities&action=EditView&return_module=Opportunities&return_action=DetailView");
        return new AddOpportunityPage(driver, wait);
    }
}


