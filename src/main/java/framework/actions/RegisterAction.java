package framework.actions;

import com.aventstack.extentreports.ExtentTest;
import framework.data.model.LoginResult;
import framework.data.model.RegisterData;
import framework.data.model.RegisterResult;
import framework.data.model.TestCaseData;
import framework.driver.DriverManager;
import framework.enums.RegisterType;
import framework.readers.TestDataManager;
import framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import pages.register.RegisterPopup;
import utils.ScreenshotUtil;

public class RegisterAction {

    public static TestCaseData<RegisterData> registerValid(RegisterType registerType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshotUtil =
                new ScreenshotUtil(driver, "Register_", test);

        TestCaseData<RegisterData> testCase =
                TestDataManager.register(registerType);

        RegisterData registerData = testCase.getData();

        HomePage home = new HomePage(driver, screenshotUtil);
        RegisterPopup register = new RegisterPopup(driver, screenshotUtil);

        home.open()
                .clickProfileIcon()
                .clickRegistrationOption();

        register.enterNameField(registerData.getName())
                .enterEmailField(registerData.getEmail())
                .enterPasswordField(registerData.getPassword())
                .enterPhoneNumberField(registerData.getPhoneNumber())
                .enterBirthdayField(registerData.getBirthday())
//                .enterGenderField(registerData.getGender())
                .clickRegisterButton();

        String message = register.getSuccessMessage();
        RegisterResult actual = new RegisterResult(message);

        testCase.setActualRegister(actual);

        System.out.println(message);

        return testCase;
    }


    public static TestCaseData<RegisterData> registerInvalid(RegisterType registerType) {

        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = ExtentManager.getTest();

        ScreenshotUtil screenshotUtil =
                new ScreenshotUtil(driver, "Register_", test);

        TestCaseData<RegisterData> testCase =
                TestDataManager.register(registerType);

        RegisterData registerData = testCase.getData();

        HomePage home = new HomePage(driver, screenshotUtil);
        RegisterPopup register = new RegisterPopup(driver, screenshotUtil);

        home.open()
                .clickProfileIcon()
                .clickRegistrationOption();

        register.enterNameField(registerData.getName())
                .enterEmailField(registerData.getEmail())
                .enterPasswordField(registerData.getPassword())
                .enterPhoneNumberField(registerData.getPhoneNumber())
                .enterBirthdayField(registerData.getBirthday())
//                .enterGenderField()
                .clickRegisterButton();

        return testCase;
    }
}
