package framework.actions;

import com.aventstack.extentreports.ExtentTest;
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

    public static TestCaseData<LoginData> login(LoginType loginType) {

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

        return testCase;
    }
}
