package framework.wait;

import framework.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private WebDriverWait wait;
    private WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ====== BY ======
    public WebElement waitFor(By locator, WaitType type) {
        switch (type) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case PRESENT:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            default:
                return driver.findElement(locator);
        }
    }

    // ====== WEBELEMENT ======
    public WebElement waitFor(WebElement element, WaitType type) {
        switch (type) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(element));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOf(element));
            default:
                return element;
        }
    }
}
