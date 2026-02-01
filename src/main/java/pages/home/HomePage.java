package pages.home;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import static pages.home.HomeLocator.*;

public class HomePage extends BasePage {

    private ScreenshotUtil screenshotUtil;

    public HomePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver);
        this.screenshotUtil = screenshotUtil;
    }

    public HomePage open() {
        driver.get(ConfigReader.getBaseUrl());
        return this;
    }


    public HomePage clickProfileIcon() {
        actions.clicksBy(PROFILE_ICON);
        screenshotUtil.capture(PROFILE_ICON, "Step1_click_profile_icon");
        return this;
    }

    public HomePage clickLoginOption() {
        actions.clicksBy(LOGIN_MENU_OPTION);
        screenshotUtil.capture(LOGIN_MENU_OPTION, "Step_2_click_login_option");
        return this;
    }

    public HomePage clickRegistrationOption() {
        actions.clicksBy(REGISTRATION_MENU_OPTION);
        screenshotUtil.capture(REGISTRATION_MENU_OPTION, "Step_3_click_registration_option");
        return this;
    }
}
