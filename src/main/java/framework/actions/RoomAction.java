package framework.actions;

import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverManager;
import framework.reports.ExtentManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.home.HomePage;
import pages.rooms.RoomPage;
import pages.details.RoomDetailPage;
import utils.ScreenshotUtil;

public class RoomAction {

    private RoomAction() {}

    public static boolean searchRoom(ScreenshotUtil screenshot) {

        WebDriver driver = DriverManager.getDriver();

        HomePage homePage = new HomePage(driver, screenshot);

        homePage.open();

        RoomPage roomPage = homePage.clickSearchButton();

        return roomPage.isRoomListDisplayed();
    }

    public static RoomDetailPage openFirstRoom(ScreenshotUtil screenshot) {

        WebDriver driver = DriverManager.getDriver();

        RoomPage roomPage = new RoomPage(driver, screenshot);

        if (!roomPage.isRoomListDisplayed()) {
            return null;
        }

        return roomPage.clickFirstRoom();
    }

    public static boolean searchRoomByGuest(
            ScreenshotUtil screenshot,
            int guestCount) {

        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver, screenshot);

        homePage.open()
                .clickAddGuest()
                .increaseGuest(guestCount);

        RoomPage roomPage = homePage.clickSearchButton();

        return roomPage.isRoomListDisplayed();
    }

    public static boolean searchRoomWithDate(
            ScreenshotUtil screenshot,
            String startDay,
            String endDay) {

        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver, screenshot);

        homePage
                .open()
                .openDatePicker()
                .goToNextMonth()
                .selectDay(startDay)
                .selectDay(endDay);

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0);");

        homePage.slowDown();

        RoomPage roomPage = homePage.clickSearchButton();

        roomPage
                .scrollToRoomList()
                .highlightRoomList();

        return roomPage.isRoomListDisplayed();
    }
}
