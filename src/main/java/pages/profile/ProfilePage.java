package pages.profile;

import framework.base.BasePage;
import framework.enums.WaitType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtil;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    public boolean isBookedRoomDisplayed() {

        WebElement firstCard =
                waitUtil.waitFor(ProfileLocator.BOOKED_ROOM_FIRST_CARD, WaitType.VISIBLE);

        highlight(firstCard);
        slowDown();

        screenshotUtil.capture("Booked Room Highlighted");

        return firstCard.isDisplayed();
    }

    public ProfilePage openEditProfile() {

        WebElement editButton =
                waitUtil.waitFor(ProfileLocator.EDIT_PROFILE_BUTTON, WaitType.CLICKABLE);

        highlight(editButton);
        slowDown();

        screenshotUtil.capture("Edit Profile Button");

        editButton.click();

        return this;
    }

    public boolean isProfileInformationDisplayed() {

        WebElement emailInput =
                waitUtil.waitFor(ProfileLocator.EMAIL_INPUT, WaitType.VISIBLE);
        WebElement phoneInput =
                waitUtil.waitFor(ProfileLocator.PHONE_INPUT, WaitType.VISIBLE);
        WebElement nameInput =
                waitUtil.waitFor(ProfileLocator.NAME_INPUT, WaitType.VISIBLE);
        WebElement birthdayInput =
                waitUtil.waitFor(ProfileLocator.BIRTHDAY_INPUT, WaitType.VISIBLE);
        WebElement genderOptionNam =
                waitUtil.waitFor(ProfileLocator.GENDER_OPTION_NAM, WaitType.VISIBLE);

        highlight(emailInput);
        screenshotUtil.capture("Email Input Visible");

        highlight(phoneInput);
        screenshotUtil.capture("Phone Input Visible");

        highlight(nameInput);
        screenshotUtil.capture("Name Input Visible");

        highlight(birthdayInput);
        screenshotUtil.capture("Birthday Input Visible");

        highlight(genderOptionNam);
        screenshotUtil.capture("Gender Option 'Nam' Visible");

        slowDown();

        return emailInput.isDisplayed()
                && phoneInput.isDisplayed()
                && nameInput.isDisplayed()
                && birthdayInput.isDisplayed()
                && genderOptionNam.isDisplayed();
    }

    public ProfilePage updatePhoneNumber(String newPhoneNumber) {

        WebElement phoneInput =
                waitUtil.waitFor(ProfileLocator.PHONE_INPUT, WaitType.VISIBLE);

        highlight(phoneInput);
        screenshotUtil.capture("Phone Input Before Update");

        phoneInput.clear();

        waitUtil.waitFor(phoneInput, WaitType.CLICKABLE);

        slowDown();

        phoneInput.sendKeys(newPhoneNumber);

        screenshotUtil.capture("Phone Input After Update");

        WebElement updateButton =
                waitUtil.waitFor(ProfileLocator.UPDATE_BUTTON, WaitType.CLICKABLE);

        highlight(updateButton);
        slowDown();

        updateButton.click();

        return this;
    }

    public boolean isPhoneNumberUpdated(String expectedPhoneNumber) {

        WebElement phoneInput =
                waitUtil.waitFor(ProfileLocator.PHONE_INPUT, WaitType.VISIBLE);

        highlight(phoneInput);
        screenshotUtil.capture("Phone Input After Save");

        String actualPhoneNumber = phoneInput.getAttribute("value");

        return expectedPhoneNumber.equals(actualPhoneNumber);
    }
}
