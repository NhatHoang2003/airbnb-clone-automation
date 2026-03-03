package tests.profile;

import com.aventstack.extentreports.ExtentTest;
import framework.actions.LoginAction;
import framework.actions.RoomAction;
import framework.actions.RoomDetailAction;
import framework.driver.DriverManager;
import framework.enums.LoginType;
import framework.listeners.ExtentListener;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.details.RoomDetailLocator;
import pages.details.RoomDetailPage;
import pages.home.HomeLocator;
import pages.home.HomePage;
import pages.profile.ProfilePage;
import tests.base.BaseTest;
import utils.ScreenshotUtil;

import java.time.Duration;

@Listeners({ExtentListener.class})
public class ProfileTest extends BaseTest {
    @Test(description = "TC20 - View booking history after successful booking")
    public void TC20_ViewBookingHistory() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC20_", test);

        // 1. Login
        LoginAction.loginForBooking(LoginType.VALID_CREDENTIALS);
        // 2. Search room
        Assert.assertTrue(RoomAction.searchRoom(screenshot));

        // 3. Open room
        RoomDetailPage detailPage = RoomAction.openFirstRoom(screenshot);
        Assert.assertNotNull(detailPage);

        // 4. Booking + Go Profile
        ProfilePage profilePage = RoomDetailAction.bookRoomAndGoToProfile(detailPage, "19");

        // 5. Verify booking history
        Assert.assertTrue(profilePage.isBookedRoomDisplayed());
    }
}
