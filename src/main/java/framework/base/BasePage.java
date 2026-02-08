package framework.base;

import framework.actions.ElementActions;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver, ScreenshotUtil screenshot) {
        this.driver = driver;
        this.actions = new ElementActions(driver, screenshot);
    }
}
