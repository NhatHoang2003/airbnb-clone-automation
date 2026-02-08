package pages.login;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class LoginPopup extends BasePage {

    public LoginPopup(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    public LoginPopup enterEmail(String email) {
        actions.typeBy(
                LoginLocator.EMAIL_FIELD,
                email,
                "Enter email"
        );
        return this;
    }

    public LoginPopup enterPassword(String password) {
        actions.typeBy(
                LoginLocator.PASSWORD_FIELD,
                password,
                "Enter password"
        );
        return this;
    }

    public LoginPopup clickLoginButton() {
        actions.clicksBy(
                LoginLocator.LOGIN_BUTTON,
                "Click login button"
        );
        return this;
    }
}
