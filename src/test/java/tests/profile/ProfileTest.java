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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.details.RoomDetailPage;
import pages.profile.ProfilePage;
import tests.base.BaseTest;
import utils.ScreenshotUtil;

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

    @Test(description = "TC21 - View profile information fields")
    public void TC21_ViewProfileInformation() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC21_", test);

        // 1. Login
        LoginAction.loginForBooking(LoginType.VALID_USER);

        // 2. Search room
        Assert.assertTrue(RoomAction.searchRoom(screenshot));

        // 3. Open room
        RoomDetailPage detailPage = RoomAction.openFirstRoom(screenshot);
        Assert.assertNotNull(detailPage);

        // 4. Go to profile page
        ProfilePage profilePage = RoomDetailAction.bookRoomAndGoToProfile(detailPage, "19");

        // 5. Open edit profile and verify profile information fields
        profilePage.openEditProfile();
        Assert.assertTrue(profilePage.isProfileInformationDisplayed());
    }

    @Test(description = "TC22 - Update phone number in profile")
    public void TC22_UpdatePhoneNumber() {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC22_", test);

        // 1. Login with valid user
        LoginAction.loginForBooking(LoginType.VALID_USER);

        // 2. Open dashboard (profile) from header
        RoomDetailPage header = new RoomDetailPage(driver, screenshot);
        ProfilePage profilePage = header
                .clickProfileIcon()
                .clickDashboard();

        // 3. Open edit profile
        profilePage.openEditProfile();

        // 4. Update phone number
        String newPhoneNumber = "0987654321";
        profilePage.updatePhoneNumber(newPhoneNumber);

        // 5. Verify phone number is updated
        Assert.assertTrue(profilePage.isPhoneNumberUpdated(newPhoneNumber));
    }
}
