package tests.base;

import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverFactory;
import framework.driver.DriverManager;
import framework.enums.BrowserType;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utils.ConfigReader;

import java.lang.reflect.Method;

import static framework.constants.FrameWorkConstants.ConfigKeys.BASE_URL;
import static framework.constants.FrameWorkConstants.ConfigKeys.BROWSER;

public class BaseTest {

    protected WebDriver driver;

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    // ================= SUITE =================
    @BeforeSuite
    public void setupSuite() {
        System.out.println("====== LOAD CONFIG ======");
        System.out.println("BASE_URL = " + ConfigReader.getConfig(BASE_URL));
        System.out.println("BROWSER  = " + ConfigReader.getConfig(BROWSER));

        ExtentManager.init();
    }

    @BeforeMethod
    public void setUp(Method method) {

        String browserName = ConfigReader.getConfig(BROWSER);
        String baseUrl = ConfigReader.getConfig(BASE_URL);

        if (browserName == null || baseUrl == null) {
            throw new RuntimeException(
                    "Config missing! browser=" + browserName + ", baseUrl=" + baseUrl
            );
        }

        BrowserType browser = BrowserType.valueOf(browserName);
        driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

    // ================= END SUITE =================
    @AfterSuite
    public void afterSuite() {
        ExtentManager.flush();
    }
}
