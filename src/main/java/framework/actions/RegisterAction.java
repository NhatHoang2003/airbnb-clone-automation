package framework.actions;

import com.aventstack.extentreports.ExtentTest;
import framework.data.factory.JsonDataFactory;
import framework.data.model.LoginData;
import framework.driver.DriverManager;
import framework.enums.RegisterType;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import utils.ScreenshotUtil;

public class RegisterAction {

    public static void register(RegisterType registerType) {
        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshotUtil =
                new ScreenshotUtil(driver, "LoginFlow", test);

        HomePage home = new HomePage(driver, screenshotUtil);

    }
}
