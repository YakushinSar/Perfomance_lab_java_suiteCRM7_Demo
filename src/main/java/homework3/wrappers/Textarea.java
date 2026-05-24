package homework3.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Textarea {

    WebDriver driver;
    String label;

    public Textarea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing '{}' into textarea '{}'", text, label);
        driver.findElement(By.id(label.toLowerCase())).sendKeys(text);
    }
}
