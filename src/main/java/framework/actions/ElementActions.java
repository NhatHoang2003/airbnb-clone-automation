package framework.actions;

import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HighlightUtil;
import utils.ScreenshotUtil;

public class ElementActions {

    private final WebDriver driver;
    private final WaitUtil wait;
    private final ScreenshotUtil screenshot;

    public ElementActions(WebDriver driver, ScreenshotUtil screenshot) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
        this.screenshot = screenshot;
    }


    public ElementActions clicksBy(By locator, String stepName) {
        WebElement element = wait.waitFor(locator, WaitType.CLICKABLE);

        HighlightUtil.highlightElement(driver, element);

        element.click();

        screenshot.capture(stepName);
        return this;
    }

    public ElementActions clicksElement(WebElement element, String stepName) {
        wait.waitFor(element, WaitType.CLICKABLE);

        HighlightUtil.highlightElement(driver, element);

        element.click();

        screenshot.capture(stepName);
        return this;
    }


    public ElementActions typeBy(By locator, String text, String stepName) {
        WebElement element = wait.waitFor(locator, WaitType.VISIBLE);

        HighlightUtil.highlightElement(driver, element);

        element.clear();
        element.sendKeys(text);

        screenshot.capture(stepName);
        return this;
    }

    public ElementActions typeElement(WebElement element, String text, String stepName) {
        wait.waitFor(element, WaitType.VISIBLE);

        HighlightUtil.highlightElement(driver, element);

        element.clear();
        element.sendKeys(text);

        screenshot.capture(stepName);
        return this;
    }
}
