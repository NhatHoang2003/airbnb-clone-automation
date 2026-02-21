package pages.rooms;

import framework.base.BasePage;
import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.details.RoomDetailPage;
import utils.ScreenshotUtil;

import java.time.Duration;
import java.util.List;

public class RoomPage extends BasePage {

    private final WaitUtil wait;

    public RoomPage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
        this.wait = new WaitUtil(driver);
    }

    public boolean isRoomListDisplayed() {

        wait.waitFor(RoomLocator.ROOM_LINKS, WaitType.VISIBLE);

        return driver.findElements(RoomLocator.ROOM_LINKS).size() > 0;
    }

    public RoomDetailPage clickFirstRoom() {

        wait.waitFor(RoomLocator.ROOM_LINKS, WaitType.PRESENT);

        List<WebElement> rooms =
                driver.findElements(RoomLocator.ROOM_LINKS);

        if (rooms.isEmpty()) {
            throw new RuntimeException("No rooms found!");
        }

        WebElement firstRoom = rooms.get(0);

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,300);");

        try {
            firstRoom.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", firstRoom);
        }

        return new RoomDetailPage(driver, screenshotUtil);
    }
}