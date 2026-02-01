package framework.actions;

import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HighlightUtil;

public class ElementActions {

    private final WebDriver driver;
    private final WaitUtil waitUtil;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public void clicksBy(By locator) {
        WebElement element = waitUtil.waitFor(locator, WaitType.CLICKABLE);
        HighlightUtil.highlightElement(driver, element);
        element.click();
    }

    public void clicksElement(WebElement element) {
        waitUtil.waitFor(element, WaitType.CLICKABLE);
        HighlightUtil.highlightElement(driver, element);
        element.click();
    }

    public void typeBy(By locator, String text) {
        WebElement element = waitUtil.waitFor(locator, WaitType.VISIBLE);
        HighlightUtil.highlightElement(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    public void typeElement(WebElement element, String text) {
        waitUtil.waitFor(element, WaitType.VISIBLE);
        HighlightUtil.highlightElement(driver, element);
        element.clear();
        element.sendKeys(text);
    }
}
