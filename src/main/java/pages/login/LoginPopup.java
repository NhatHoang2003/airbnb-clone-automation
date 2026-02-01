package pages.login;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class LoginPopup extends BasePage {

    private ScreenshotUtil screenshotUtil;

    public LoginPopup(WebDriver driver,  ScreenshotUtil screenshotUtil) {
        super(driver);
        this.screenshotUtil = screenshotUtil;
    }

    public LoginPopup enterEmail(String email) {
        actions.typeBy(LoginLocator.EMAIL_FIELD, email);
        screenshotUtil.capture(LoginLocator.EMAIL_FIELD, "enter_email");
        return this;
    }


    public LoginPopup enterPassword(String password) {
        actions.typeBy(LoginLocator.PASSWORD_FIELD, password);
        screenshotUtil.capture(LoginLocator.PASSWORD_FIELD, "enter_  hoang password");
        return this;
    }

    public LoginPopup clickLoginButton() {
        actions.clicksBy(LoginLocator.LOGIN_BUTTON);
        screenshotUtil.capture(LoginLocator.LOGIN_BUTTON, "clickLoginButton");
        return this;
    }
}
