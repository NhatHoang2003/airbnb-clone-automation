package tests.details;

import com.aventstack.extentreports.ExtentTest;
import framework.actions.LoginAction;
import framework.actions.RoomAction;
import framework.actions.RoomDetailAction;
import framework.data.dataprovider.LoginDataProvider;
import framework.driver.DriverManager;
import framework.enums.LoginType;
import framework.listeners.ExtentListener;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.details.RoomDetailPage;
import pages.home.HomePage;
import tests.base.BaseTest;
import utils.ScreenshotUtil;

@Listeners({ExtentListener.class})
public class RoomDetailTest extends BaseTest {

    @Test(description = "TC16 - Booking success")
//    TC16: Đặt phòng thành công (end-to-end flow)
    public void verifyBookingSuccess() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC16_", test);

        // 1. Login cho booking
        LoginAction.loginForBooking(LoginType.VALID_CREDENTIALS);

        // 2. Search
        Assert.assertTrue(RoomAction.searchRoom(screenshot), "Room list not displayed");

        // 3. Open room
        RoomDetailPage detailPage = RoomAction.openFirstRoom(screenshot);

        Assert.assertNotNull(detailPage,"Room detail page not opened");

        // 4. Booking
        boolean result = RoomDetailAction.bookRoomSuccess(detailPage, "19");

        screenshot.capture("Final_Result");

        Assert.assertTrue(result,"Booking was not successful");
    }

    @Test(description = "TC17 - Validate total price calculation including cleaning fee")
    public void verifyPriceCalculation() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC17_", test);

        LoginAction.loginForBooking(LoginType.VALID_USER);

        Assert.assertTrue(RoomAction.searchRoom(screenshot),
                "Search room failed");

        RoomDetailPage detailPage =
                RoomAction.openFirstRoom(screenshot);

        Assert.assertNotNull(detailPage,
                "Room detail page not opened");

        String checkInDay = "19";
        String checkOutDay = "22";

        detailPage
                .selectCheckInDate()
                .clickNextMonthButton()
                .selectDate(checkInDay)
                .selectDate(checkOutDay)
                .closePopup();

        int pricePerDay = detailPage.getPricePerDay();
        int totalDisplayed = detailPage.getDisplayedTotalPrice();

        int expectedTotal =
                detailPage.calculateExpectedTotal(
                        pricePerDay,
                        checkInDay,
                        checkOutDay
                );

        screenshot.capture("TC17_Final_Result");

        Assert.assertEquals(totalDisplayed, expectedTotal,
                "Total price calculation incorrect!");
    }

    @Test(description = "TC18 - Booking fails when not logged in")
//     TC-18: Đặt phòng thất bại - Chưa đăng nhập
    public void verifyBookingWithoutLogin() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC18_", test);

        // 1. Search room
        Assert.assertTrue(RoomAction.searchRoom(screenshot));

        // 2. Open first room
        RoomDetailPage detailPage = RoomAction.openFirstRoom(screenshot);
        Assert.assertNotNull(detailPage);

        // 3. Booking
        boolean result =
                RoomDetailAction.bookRoomWithoutLogin(detailPage, "19");

        screenshot.capture("Final_Result");

        Assert.assertTrue(result,"Login required message not displayed");
    }
}
