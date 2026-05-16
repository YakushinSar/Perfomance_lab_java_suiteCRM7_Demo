package homework1.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void check() {
        WebElement checkbox = driver.findElement(By.xpath(String.format("//label[contains(text(), '%s')]/input", label)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
