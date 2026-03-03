package pages.profile;

import framework.base.BasePage;
import framework.enums.WaitType;
import org.openqa.selenium.*;
import pages.home.HomeLocator;
import utils.ScreenshotUtil;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    public String getHeaderAvatarUrl() {
        WebElement avatarRoot =
                waitUtil.waitFor(HomeLocator.UPLOADAVT_BUTTON, WaitType.VISIBLE);
        return extractAvatarUrl(avatarRoot);
    }

    public ProfilePage uploadAvatar(String absoluteFilePath) {
//        WebElement uploadInput =
//                waitUtil.waitFor(ProfileLocator.AVATAR_UPLOAD_INPUT, WaitType.PRESENT);
//
//        highlight(uploadInput);
//        screenshotUtil.capture("Avatar Upload Input");
//
//        uploadInput.sendKeys(absoluteFilePath);
//        slowDown();
//
//        screenshotUtil.capture("Avatar Selected");
//
//        return this;
//    }
        // 1. Click nút cập nhật ảnh
        WebElement updateBtn =
                waitUtil.waitFor(ProfileLocator.UPDATE_AVATAR_BUTTON, WaitType.CLICKABLE);
        updateBtn.click();

        // 2. Wait input xuất hiện
//        WebElement uploadInput =
//                waitUtil.waitFor(ProfileLocator.AVATAR_UPLOAD_INPUT, WaitType.PRESENT);

//        highlight(uploadInput);

//        screenshotUtil.capture("Avatar Upload Input");

        WebElement uploadInput =
                waitUtil.waitFor(ProfileLocator.AVATAR_UPLOAD_INPUT, WaitType.PRESENT);

        highlight(uploadInput);
        screenshotUtil.capture("Avatar Upload Input");

//        uploadInput.click();
//        slowDown();

//        // 3. Upload file
        uploadInput.sendKeys(absoluteFilePath);
        slowDown();

        screenshotUtil.capture("Avatar Selected");

        return this;
    }

    public ProfilePage clickUpdate() {
//        WebElement updateButton =
//                waitUtil.waitFor(ProfileLocator.UPDATE_BUTTON, WaitType.CLICKABLE);
//
//        highlight(updateButton);
//        slowDown();
//        screenshotUtil.capture("Click Update Profile");
//
//        try {
//            updateButton.click();
//        } catch (Exception e) {
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].click();", updateButton);
//        }
//
//        try {
//            waitUtil.waitFor(ProfileLocator.EDIT_PROFILE_MODAL, WaitType.INVISIBLE);
//        } catch (Exception ignored) {
//            // Some builds keep modal open; do not hard-fail here.
//        }
//
//        return this;

        // Wait modal visible trước
        waitUtil.waitFor(
                (ProfileLocator.AVATAR_UPLOAD_INPUT),
                WaitType.VISIBLE
        );

        WebElement updateBtn =
                waitUtil.waitFor(ProfileLocator.UPDATEAVT_BUTTON, WaitType.CLICKABLE);

        highlight(updateBtn);
        screenshotUtil.capture("Update Button");

        updateBtn.click();
        slowDown();

        return this;
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

//        phoneInput.clear();

        //Recommend
        phoneInput.sendKeys(Keys.CONTROL + "A");
        phoneInput.sendKeys(Keys.DELETE);

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

    private String extractAvatarUrl(WebElement avatarRoot) {
        if (avatarRoot == null) return "";

        try {
            if ("img".equalsIgnoreCase(avatarRoot.getTagName())) {
                String src = avatarRoot.getAttribute("src");
                return src == null ? "" : src.trim();
            }

            WebElement img = avatarRoot.findElement(By.cssSelector("img"));
            String src = img.getAttribute("src");
            if (src != null && !src.trim().isEmpty()) return src.trim();
        } catch (Exception ignored) {
            // fall through
        }

        try {
            Object bg = ((JavascriptExecutor) driver)
                    .executeScript("return window.getComputedStyle(arguments[0]).backgroundImage;", avatarRoot);
            return bg == null ? "" : bg.toString();
        } catch (Exception ignored) {
            return "";
        }
    }
}
