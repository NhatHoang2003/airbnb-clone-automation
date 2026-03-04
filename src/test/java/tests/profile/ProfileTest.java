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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

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
        LoginAction.loginForBooking(LoginType.VALID_CREDENTIALS);

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
        LoginAction.loginForBooking(LoginType.VALID_CREDENTIALS);

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

    @Test(description = "TC23 - Upload avatar in profile")
    public void TC23_UploadAvatar() throws Exception {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshot =
                new ScreenshotUtil(driver, "TC23_", test);

        // 1. Login with valid user
//        LoginAction.loginForBooking(LoginType.VALID_USER);
        LoginAction.loginValid(LoginType.VALID_CREDENTIALS);

        // 2. Open dashboard (profile) from header
        RoomDetailPage header = new RoomDetailPage(driver, screenshot);
        ProfilePage profilePage = header
                .clickProfileIcon()
                .clickDashboard();

        // 5. Creat ImgPath
          String uploadImgPath = System.getProperty("user.home") + "/Desktop/testing-09.png";
        //String uploadImgPath = System.getProperty("user.home") + "/Desktop/download.png";

        // 6. Upload avatar + save
        profilePage.uploadAvatar(uploadImgPath).clickUpdate();

        // 7. Verify avatar url updated (and persists after refresh)
//        String afterAvatarUrl = profilePage.getHeaderAvatarUrl();
//        Assert.assertTrue(
//                afterAvatarUrl != null && !afterAvatarUrl.isBlank(),
//                "Avatar url should not be blank after upload"
//        );
//
//        if (beforeAvatarUrl != null && !beforeAvatarUrl.isBlank()) {
//            Assert.assertNotEquals(afterAvatarUrl, beforeAvatarUrl, "Avatar url should change after upload");
//        }
//
//        driver.navigate().refresh();
//        String afterRefreshAvatarUrl = profilePage.getHeaderAvatarUrl();
//        Assert.assertTrue(
//                afterRefreshAvatarUrl != null && !afterRefreshAvatarUrl.isBlank(),
//                "Avatar url should persist after refresh"
//        );
    }
}
