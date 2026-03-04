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

    @Test(description = "Verify user can search room with date successfully")
    public void verifySearchRoomWithDate() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC_SearchRoomDate_", test);

        boolean actual =
                RoomAction.searchRoomWithDate(screenshot, "10", "15");

        Assert.assertTrue(actual, "Search room with date failed!");
    }

    @Test(description = "Verify user can search room with guest successfully")
    public void verifySearchRoomWithGuest() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC_SearchRoomGuest_", test);

        boolean actual =
                RoomAction.searchRoomByGuest(screenshot, 2);

        Assert.assertTrue(actual, "Search room with guest failed!");
    }

    @Test(description = "Verify that the system correctly filters products by price range only.")
    public void verifyFilterByPriceRange() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC_FilterPrice_", test);

        RoomAction.filterByPriceRange(
                screenshot,
                "Hồ Chí Minh",
                "10",
                "15",
                0
        );

    }

    @Test(description = "Verify that the system correctly filters products by price range only.")
    public void verifySwiperNextWorking() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC_FilterPrice_", test);

        RoomAction.swiperNextWorking(
                screenshot,
                "Hồ Chí Minh",
                "10",
                "15",
                0
        );
    }
}
