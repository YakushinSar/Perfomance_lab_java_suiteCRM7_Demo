package homework1.pages;

import homework1.wrappers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAccountPage extends BasePage {

    private final By ADDACCOUNT_PAGE_LOADED = By.xpath("//h2[normalize-space()='CREATE']");

    public AddAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADDACCOUNT_PAGE_LOADED));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //  для создания нового аккаунта на странице AddAccountPage
    public void createAccount(String name, String phone, String fax, String website,
                              String email, String street, String city, String state,
                              String postalCode, String country, String type,
                              String industry, String description) {
        // Инпуты
        new Input(driver, "Name").write(name);
        new Input(driver, "Office Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);

        // Email Address
        WebElement emailField = driver.findElement(By.id("Accounts0emailAddress0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.sendKeys(email);

// Чекбоксы Opted Out и Invalid
        WebElement optedOutCheckbox = driver.findElement(By.id("Accounts0emailAddressOptOutFlag0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optedOutCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optedOutCheckbox);

        WebElement invalidCheckbox = driver.findElement(By.id("Accounts0emailAddressInvalidFlag0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invalidCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", invalidCheckbox);
// AddressTextArea
        // Billing Address
        new AddressTextArea(driver, "Billing Address", "Street").write(street);
        new AddressInput(driver, "Billing Address", "City").write(city);
        new AddressInput(driver, "Billing Address", "State/Region").write(state);
        new AddressInput(driver, "Billing Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Billing Address", "Country").write(country);

// Shipping Address
        new AddressTextArea(driver, "Shipping Address", "Street").write(street);
        new AddressInput(driver, "Shipping Address", "City").write(city);
        new AddressInput(driver, "Shipping Address", "State/Region").write(state);
        new AddressInput(driver, "Shipping Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Shipping Address", "Country").write(country);

        // Дропдауны
        new Select(driver, "Type").select(type);
        new Select(driver, "Industry").select(industry);

        // Textarea
        new Textarea(driver, "description").write(description);
    }

    //       для клика на кнопку SAVE
    public void clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
    }
}

