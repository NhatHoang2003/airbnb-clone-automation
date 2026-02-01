package framework.actions;
import com.aventstack.extentreports.ExtentTest;
import framework.data.factory.JsonDataFactory;
import framework.data.model.LoginData;
import framework.driver.DriverManager;
import framework.enums.UserType;
import framework.reports.ExtentManager;
import framework.wait.WaitUtil;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import pages.login.LoginPopup;
import utils.ScreenshotUtil;

public class LoginAction {

    public static void login(UserType userType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "LoginFlow", test);

        LoginData data = JsonDataFactory.getLoginData(userType);

        HomePage home = new HomePage(driver, screenshot);
        LoginPopup login = new LoginPopup(driver, screenshot);

        home.open()
                .clickProfileIcon()
                .clickLoginOption();

        login.enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .clickLoginButton();
    }
}




