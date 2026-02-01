package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightUtil {

    public static void highlightElement(WebDriver driver, WebElement element) {

        if (!ConfigLoader.isHighlightEnabled()) {
            return;
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int duration = ConfigLoader.getHighlightDuration();

        js.executeScript(
                "arguments[0].setAttribute('data-old-style', arguments[0].getAttribute('style') || '');" +
                        "arguments[0].style.outline='3px solid red';" +
                        "arguments[0].style.backgroundColor='yellow';",
                element
        );

        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {}

        js.executeScript(
                "arguments[0].setAttribute('style', arguments[0].getAttribute('data-old-style'));",
                element
        );
    }
}
