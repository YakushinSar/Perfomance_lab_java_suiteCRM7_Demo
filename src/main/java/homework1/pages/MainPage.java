package homework1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    public final String MAINPAGE_URL = "https://demo.suiteondemand.com/index.php?module=Home&action=Demo";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //    переход на страницу AddAccountPage
    public void goToAddAccountPage() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
    }
}


