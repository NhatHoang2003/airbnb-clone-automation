//package framework.asserts;
//
//import framework.driver.DriverManager;
//import org.testng.Assert;
//import pages.home.HomePage;
//import pages.login.LoginPopup;
//
//public final class LoginAssert {
//
//    private LoginAssert() {}
//
//    public static void verifyLoginSuccess() {
//        HomePage homePage = new HomePage(DriverManager.getDriver());
//
//        Assert.assertTrue(
//                homePage.isAvatarDisplayed(),
//                "Login successful, but avatar not displayed."
//        );
//    }
//
//    public static void verifyLoginFailed() {
//        LoginPopup loginPopup = new LoginPopup(DriverManager.getDriver());
//
//        Assert.assertTrue(
//                loginPopup.isErrorMessageDisplayed(),
//                "Login successful, but message not displayed"
//        );
//    }
//}
