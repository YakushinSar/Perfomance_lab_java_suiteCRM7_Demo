package lesson3.pages;

import lesson3.dto.Account;
import lesson3.dto.AccountLombok;
import lesson3.wrappers.AdressTextArea;
import lesson3.wrappers.Input;
import lesson3.wrappers.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");

    }

    //  Метод для Account (обычный DTO, dto передается в качестве параметров метода (Account account)
    public void addNewAccount(Account account) {
//        проверка инпутов
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
//        проверка текстареа
        new AdressTextArea(driver, "Billing Address", "Street").write(account.getStreet());
        new AdressTextArea(driver, "Shipping Address", "Street").write(account.getStreet());
//      работа с выпадающим списком
        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry").select(account.getIndustry());
    }

    // 2. Перегруженный метод для AccountLombok (Lombok DTO с Builder)
    public void addNewAccount(AccountLombok account) {
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new AdressTextArea(driver, "Billing Address", "Street").write(account.getStreet());
        new AdressTextArea(driver, "Shipping Address", "Street").write(account.getStreet());
        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry").select(account.getIndustry());
    }

    // метод для клика на кнопку SAVE
    public void clickSave() {
        driver.findElement(By.id("SAVE")).click();
    }
}
