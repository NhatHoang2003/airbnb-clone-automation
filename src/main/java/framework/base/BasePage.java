package framework.base;

import framework.actions.ElementActions;
import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtil;

public class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;
    protected ScreenshotUtil screenshotUtil;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver, ScreenshotUtil screenshot) {
        this.driver = driver;
        this.screenshotUtil = screenshot;
        this.actions = new ElementActions(driver, screenshot);
        this.waitUtil = new WaitUtil(driver);
    }

    protected void click(By locator) {
        waitUtil.waitFor(locator, WaitType.CLICKABLE).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUtil.waitFor(locator, WaitType.VISIBLE);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitUtil.waitFor(locator, WaitType.VISIBLE).getText();
    }

    public void highlight(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red';" +
                        "arguments[0].style.boxShadow='0 0 10px red';",
                element
        );
    }

    public void slowDown() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element =
                    waitUtil.waitFor(locator, WaitType.VISIBLE);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
