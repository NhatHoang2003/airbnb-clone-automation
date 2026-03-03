package framework.actions;

import com.aventstack.extentreports.ExtentTest;
import framework.data.model.LoginResult;
import framework.readers.TestDataManager;
import framework.data.model.LoginData;
import framework.data.model.TestCaseData;
import framework.driver.DriverManager;
import framework.enums.LoginType;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import pages.login.LoginPopup;
import utils.ScreenshotUtil;

public class LoginAction {

    public static TestCaseData<LoginData> loginValid(LoginType loginType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "Login_", test);

        TestCaseData<LoginData> testCase =
                TestDataManager.login(loginType);

        LoginData data = testCase.getData();

        HomePage home = new HomePage(driver, screenshot);
        LoginPopup login = new LoginPopup(driver, screenshot);

        home.open()
                .clickProfileIcon()
                .clickLoginOption();

        login.enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickLoginButton();

        login.waitUntilLoginPopupClosed();

        boolean isSuccess = login.isProfileDisplayed();
        String message = login.getSuccessMessage();
        LoginResult actual = new LoginResult(isSuccess, message);

        testCase.setActualLogin(actual);

        System.out.println(message);

        return testCase;
    }

    public static TestCaseData<LoginData> loginInValid(LoginType loginType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "Login_", test);

        TestCaseData<LoginData> testCase =
                TestDataManager.login(loginType);

        LoginData data = testCase.getData();

        HomePage home = new HomePage(driver, screenshot);
        LoginPopup login = new LoginPopup(driver, screenshot);

        home.open()
                .clickProfileIcon()
                .clickLoginOption();

        login.enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickLoginButton();

        String message = "";

        switch (loginType) {

            case INVALID_CREDENTIALS:
                message = login.getFailureMessage();
                break;

            case INVALID_EMAIL_FORMAT:
            case EMPTY_FIELD:
                message = login.getEmailErrorMessage();
                break;

            case EMPTY_PASSWORD:
                message = login.getPasswordErrorMessage();
                break;
        }

        LoginResult actual = new LoginResult(false, message);
        testCase.setActualLogin(actual);

        return testCase;
    }

    public static void loginForBooking(LoginType loginType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "LoginBooking_", test);

        TestCaseData<LoginData> testCase =
                TestDataManager.login(loginType);

        LoginData data = testCase.getData();

        HomePage home = new HomePage(driver, screenshot);
        LoginPopup login = new LoginPopup(driver, screenshot);

        home.open();

        home.clickProfileIcon()
                .clickLoginOption();

        login.enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickLoginButton();

        login.waitUntilLoginPopupClosed();
    }
}
