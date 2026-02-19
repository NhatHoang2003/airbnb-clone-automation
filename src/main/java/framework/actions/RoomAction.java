package framework.actions;

import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverManager;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import pages.rooms.RoomPage;
import pages.details.RoomDetailPage;
import utils.ScreenshotUtil;

public class RoomAction {

    private RoomAction() {}

    public static boolean searchRoom() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "Room_", test);

        HomePage homePage = new HomePage(driver, screenshot);

        homePage.open();

        RoomPage roomPage = homePage.clickSearchButton();

        return roomPage.isRoomListDisplayed();
    }

    public static RoomDetailPage openFirstRoom() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC16_", test);

        RoomPage roomPage = new RoomPage(driver, screenshot);

        if (!roomPage.isRoomListDisplayed()) {
            return null;
        }

        return roomPage.clickFirstRoom();
    }
}
