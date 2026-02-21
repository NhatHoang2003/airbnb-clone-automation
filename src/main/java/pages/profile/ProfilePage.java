package pages.profile;

import framework.base.BasePage;
import framework.enums.WaitType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtil;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    public boolean isBookedRoomDisplayed() {

        WebElement firstCard = waitUtil.waitFor(ProfileLocator.BOOKED_ROOM_FIRST_CARD, WaitType.VISIBLE);

        highlight(firstCard);
        slowDown();

        screenshotUtil.capture("Booked Room Highlighted");

        return firstCard.isDisplayed();
    }
}
