package pages.home;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import static pages.home.HomeLocator.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    public HomePage open() {
        driver.get(ConfigReader.getBaseUrl());
        return this;
    }

    public HomePage clickProfileIcon() {
        actions.clicksBy(PROFILE_ICON, "Click profile icon");
        return this;
    }

    public HomePage clickLoginOption() {
        actions.clicksBy(LOGIN_MENU_OPTION, "Click login option");
        return this;
    }

    public HomePage clickRegistrationOption() {
        actions.clicksBy(REGISTRATION_MENU_OPTION, "Click registration option");
        return this;
    }
}
