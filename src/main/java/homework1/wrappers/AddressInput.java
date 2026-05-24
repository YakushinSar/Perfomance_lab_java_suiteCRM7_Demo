package homework1.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressInput {

    WebDriver driver;
    String addressLabel;
    String label;

    public AddressInput(WebDriver driver, String addressLabel, String label) {
        this.driver = driver;
        this.addressLabel = addressLabel;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[contains(@class, 'edit-view-row-item')]//*[contains(text(), '%s')]/ancestor::" +
                "tr//input", addressLabel, label))).sendKeys(text);
    }
}
