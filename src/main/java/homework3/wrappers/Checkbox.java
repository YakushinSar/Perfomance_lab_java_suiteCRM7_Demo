package homework3.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Checkbox {

    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void check() {
        log.info("Checking checkbox '{}'", label);
        WebElement checkbox = driver.findElement(By.xpath(String.format("//label[contains(text(), '%s')]/input", label)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
