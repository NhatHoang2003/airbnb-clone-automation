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

import static utils.HighlightUtil.highlightElement;

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



    public RoomPage scrollToRoomList() {

        WebElement roomList =
                wait.waitFor(RoomLocator.ROOM_LINKS, WaitType.VISIBLE);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", roomList);

        return this;
    }

    public boolean isPriceListDisplayed() {

        wait.waitFor(RoomLocator.PRICE_LIST, WaitType.VISIBLE);

        List<WebElement> priceList =
                driver.findElements(RoomLocator.PRICE_LIST);

        if (priceList.isEmpty()) {
            return false;
        }

        for (WebElement priceElement : priceList) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", priceElement);

            slowDown();

            highlight(priceElement);
        }

        return true;
    }

    public RoomPage clickNextImage() {

        WebElement nextBtn =
                wait.waitFor(RoomLocator.SWIPER_NEXT_BUTTON, WaitType.CLICKABLE);

        highlight(nextBtn);
        nextBtn.click();


        return this;
    }

    public RoomPage clickPrevImage() {

        WebElement prevBtn =
                wait.waitFor(RoomLocator.SWIPER_PREV_BUTTON, WaitType.CLICKABLE);

        highlight(prevBtn);
        prevBtn.click();

        return this;
    }

    public boolean isSwiperNextWorking() {

        WebElement activeBefore =
                wait.waitFor(RoomLocator.ACTIVE_SLIDE_IMAGE, WaitType.VISIBLE);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", activeBefore);

        highlight(activeBefore);

        String beforeSrc = activeBefore.getAttribute("src");

        WebElement nextBtn =
                wait.waitFor(RoomLocator.SWIPER_NEXT_BUTTON, WaitType.CLICKABLE);

        highlight(nextBtn);
        nextBtn.click();

        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean changed = customWait.until(driver -> {

            WebElement activeAfter =
                    driver.findElement(RoomLocator.ACTIVE_SLIDE_IMAGE);

            String afterSrc = activeAfter.getAttribute("src");

            return !afterSrc.equals(beforeSrc);
        });

        WebElement activeAfter =
                driver.findElement(RoomLocator.ACTIVE_SLIDE_IMAGE);

        highlight(activeAfter);

        return changed;
    }
}