package framework.base;

import framework.actions.ElementActions;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }
}

