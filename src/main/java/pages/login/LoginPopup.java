package pages.login;

import framework.base.BasePage;
import framework.enums.WaitType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.HomeLocator;
import utils.ScreenshotUtil;

import java.time.Duration;


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

    public boolean isProfileDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement profile = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LoginLocator.PROFILE_ICON_AFTER_LOGIN
                    )
            );

            highlight(profile);

            return profile.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LoginLocator.SUCCESS_MESSAGE
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getFailureMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LoginLocator.FAILURE_MESSAGE
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getEmailErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LoginLocator.EMAIL_ERROR_MESSAGE
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getPasswordErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LoginLocator.PASSWORD_ERROR_MESSAGE
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }

    public void waitUntilLoginPopupClosed() {
        waitUtil.waitFor(LoginLocator.LOGIN_MODAL, WaitType.INVISIBLE);
        waitUtil.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);
    }

}
