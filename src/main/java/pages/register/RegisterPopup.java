package pages.register;

import framework.base.BasePage;
import framework.enums.WaitType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.HomeLocator;
import pages.login.LoginLocator;
import utils.ScreenshotUtil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RegisterPopup extends BasePage {

    public RegisterPopup(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }


    public RegisterPopup enterNameField (String name){
        actions.typeBy(
                RegisterLocator.NAME_FIELD,
                name,
                "Enter name"
        );

        return this;
    }

    public RegisterPopup enterEmailField (String email){
        actions.typeBy(
                RegisterLocator.EMAIL_FIELD,
                email,
                "Enter email"
        );

        return this;
    }

    public RegisterPopup enterPasswordField (String password){
        actions.typeBy(
                RegisterLocator.PASSWORD_FIELD,
                password,
                "Enter password"
        );

        return this;
    }

    public RegisterPopup enterPhoneNumberField (String phoneNumber){
        actions.typeBy(
                RegisterLocator.PHONE_FIELD,
                phoneNumber,
                "Enter phone number"
        );

        return this;
    }

    public RegisterPopup enterBirthdayField(String birthday){

        actions.clicksBy(
                RegisterLocator.BIRTHDAY_FIELD,
                "Open birthday"
        );

        actions.typeBy(
                RegisterLocator.BIRTHDAY_FIELD,
                birthday,
                "Enter birthday"
        );

        driver.findElement(RegisterLocator.BIRTHDAY_FIELD)
                .sendKeys(Keys.ENTER);

        return this;
    }

//    public RegisterPopup enterGenderField(){
//
//        actions.clicksBy(
//                RegisterLocator.genderField,
//                "Click gender dropdown"
//        );
//
//        actions.clicksBy(
//                RegisterLocator.genderOption,
//                "Select Option"
//        );
//
//        return this;
//    }

    public String getSuccessMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            RegisterLocator.SUCCESS_MESSAGE
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getFailureMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            RegisterLocator.EMAIL_EXIST
                    )
            );

            highlight(message);

            return message.getText().trim();

        } catch (TimeoutException e) {
            return "";
        }
    }


    public List<String> getAllErrorMessages() {
        List<WebElement> errors = driver.findElements(RegisterLocator.ALL_ERROR_MESSAGE);

        List<String> errorMessages = new ArrayList<>();

        for (WebElement error : errors) {
            errorMessages.add(error.getText().trim());
        }

        return errorMessages;
    }



    public RegisterPopup clickRegisterButton (){
        actions.clicksBy(
                RegisterLocator.REGISTER_BUTTON,
                "Click Register Button"
        );

        return this;
    }

    public void waitUntilLoginPopupClosed() {
        waitUtil.waitFor(LoginLocator.LOGIN_MODAL, WaitType.INVISIBLE);
        waitUtil.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);
    }
}