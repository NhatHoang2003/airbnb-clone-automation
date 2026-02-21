package tests.rooms;

import com.aventstack.extentreports.ExtentTest;
import framework.actions.RoomAction;
import framework.data.model.TestCaseData;
import framework.driver.DriverManager;
import framework.listeners.ExtentListener;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.ScreenshotUtil;

@Listeners({ExtentListener.class})
public class RoomTest extends BaseTest {
    @Test(description = "Verify user can search room successfully")
    public void verifySearchRoom() {
        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot = new ScreenshotUtil(driver, "TC_SearchRoom_", test);

        boolean actual = RoomAction.searchRoom(screenshot);

        Assert.assertTrue(actual, "Search room failed!");
    }
}
