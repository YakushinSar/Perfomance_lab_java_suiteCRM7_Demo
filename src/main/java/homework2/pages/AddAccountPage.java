package homework2.pages;

import homework2.dto.AccountDTO;
import homework2.wrappers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAccountPage extends BasePage {

    private final By ADDACCOUNT_PAGE_LOADED = By.xpath("//h2[normalize-space()='CREATE']");
    private final By PAGE_LOADED_INDICATOR = By.xpath("//h2[normalize-space()='CREATE']");

    public AddAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public AddAccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOADED_INDICATOR));
        return this;
    }

    // Новый метод с DTO
    public AddAccountPage createAccount(AccountDTO account) {
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());

        WebElement emailField = driver.findElement(By.id("Accounts0emailAddress0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.sendKeys(account.getEmail());

        WebElement optedOutCheckbox = driver.findElement(By.id("Accounts0emailAddressOptOutFlag0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optedOutCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optedOutCheckbox);

        WebElement invalidCheckbox = driver.findElement(By.id("Accounts0emailAddressInvalidFlag0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invalidCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", invalidCheckbox);

        new AddressTextArea(driver, "Billing Address", "Street").write(account.getStreet());
        new AddressInput(driver, "Billing Address", "City").write(account.getCity());
        new AddressInput(driver, "Billing Address", "State/Region").write(account.getState());
        new AddressInput(driver, "Billing Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Billing Address", "Country").write(account.getCountry());

        new AddressTextArea(driver, "Shipping Address", "Street").write(account.getStreet());
        new AddressInput(driver, "Shipping Address", "City").write(account.getCity());
        new AddressInput(driver, "Shipping Address", "State/Region").write(account.getState());
        new AddressInput(driver, "Shipping Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Shipping Address", "Country").write(account.getCountry());

        new Select(driver, "Type").select(account.getType());
        new Select(driver, "Industry").select(account.getIndustry());
        new Textarea(driver, "description").write(account.getDescription());

        return this;
    }

    //  Старый метод, для создания нового аккаунта на странице AddAccountPage
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
    public AccountPage clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new AccountPage(driver, wait);
    }
}

