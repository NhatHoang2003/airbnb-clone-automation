package tests.login;

import com.aventstack.extentreports.ExtentTest;
import framework.actions.LoginAction;
import framework.asserts.LoginAssertion;
import framework.data.dataprovider.LoginDataProvider;
import framework.data.model.LoginData;
import framework.data.model.TestCaseData;
import framework.enums.LoginType;
import framework.driver.DriverManager;
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
public class LoginTest extends BaseTest {

    @Test(
            description = "TC01: Đăng ký thành công với thông tin hợp lệ",
            dataProvider = "validCredentials",
            dataProviderClass = LoginDataProvider.class
    )
    public void testLoginWithValidCredentials(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.loginValid(loginType);

        LoginAssertion.assertLogin(testCase);
    }

    @Test(
            dataProvider = "invalidCredentials",
            dataProviderClass = LoginDataProvider.class)
    public void testLoginWithInvalidCredentials(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.loginInValid(loginType);

        LoginAssertion.assertLogin(testCase);

    }

    @Test(dataProvider = "emptyFields",
            dataProviderClass = LoginDataProvider.class)
    public void testLoginWithEmptyField(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.loginInValid(loginType);

        LoginAssertion.assertLogin(testCase);
    }

//    @Test(description = "TC22 - Open dashboard after successful login")
//    public void testOpenDashboardAfterLoginSuccess() {
//
//        WebDriver driver = DriverManager.getDriver();
//        ExtentTest test = ExtentManager.getTest();
//
//        ScreenshotUtil screenshot =
//                new ScreenshotUtil(driver, "TC22_", test);
//
//        // 1. Login with valid user
//        LoginAction.loginForBooking(LoginType.VALID_CREDENTIALS);
//
//        // 2. Open dashboard (profile) from header
//        RoomDetailPage header = new RoomDetailPage(driver, screenshot);
//        ProfilePage profilePage = header
//                .clickProfileIcon()
//                .clickDashboard();
//
//        // 3. Verify profile information on dashboard
//        profilePage.openEditProfile();
//        Assert.assertTrue(profilePage.isProfileInformationDisplayed());
//    }
}
