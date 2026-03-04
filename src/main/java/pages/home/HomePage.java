package pages.home;

import framework.base.BasePage;
import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.rooms.RoomLocator;
import pages.rooms.RoomPage;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import java.time.Duration;

import static pages.home.HomeLocator.*;

public class HomePage extends BasePage {

    private final WaitUtil wait;

    public HomePage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
        this.wait = new WaitUtil(driver);
    }

    public HomePage open() {
        driver.get(ConfigReader.getBaseUrl());
        return this;
    }

    public HomePage clickProfileIcon() {
        wait.waitForLoadingDisappear(HomeLocator.LOADING_OVERLAY);
        actions.clicksBy(PROFILE_ICON, "Click profile icon");
        return this;
    }

    public HomePage clickLoginOption() {
        actions.clicksBy(LOGIN_MENU_OPTION, "Click login option");
        return this;
    }

    public HomePage clickRegistrationOption() {
        actions.clicksBy(REGISTRATION_MENU_OPTION, "Click registration option");
        return this;
    }

    public HomePage clickLocationBox() {
        wait.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);
        actions.clicksBy(HomeLocator.LOCATION_BOX, "Click location box");
        return this;
    }

    public HomePage selectLocation(String locationName) {
        actions.clicksBy(
                HomeLocator.locationItem(locationName),
                "Select location: " + locationName
        );
        return this;
    }

    public RoomPage clickSearchButton() {
        waitUtil.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);

        WebElement searchBtn =
                waitUtil.waitFor(HomeLocator.SEARCH_BUTTON, WaitType.CLICKABLE);

        searchBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getCurrentUrl().contains("room"));

        waitUtil.waitFor(RoomLocator.ROOM_LINKS, WaitType.PRESENT);

        return new RoomPage(driver, screenshotUtil);
    }

    public HomePage clickAddGuest() {

        wait.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);

        WebElement element = waitUtil.waitFor(
                HomeLocator.DROPDOWN_ADD_GUEST,
                WaitType.VISIBLE
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        slowDown();

        element.click();

        return this;
    }

    public HomePage increaseGuest(int times) {

        for (int i = 0; i < times; i++) {
            actions.clicksBy(HomeLocator.PLUS_GUEST_BUTTON,
                    "Click '+' increase guest - time: " + (i + 1));
        }

        return this;
    }

    public HomePage openDatePicker() {
        wait.waitFor(LOADING_OVERLAY, WaitType.INVISIBLE);
        actions.clicksBy(DATE_INPUT, "Open date picker");
        wait.waitFor(NEXT_MONTH_BUTTON, WaitType.VISIBLE);
        return this;
    }

    public HomePage goToNextMonth() {
        actions.clicksBy(NEXT_MONTH_BUTTON, "Click next month");
        return this;
    }

    public HomePage selectDay(String day) {

        String xpath =
                "//span[@class='rdrDayNumber']/span[text()='" + day + "']";

        WebElement date = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", date);
        slowDown();
        date.click();
        slowDown();
        return this;
    }

    public void waitForLoginSuccess() {
        try {
            wait.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);
        } catch (Exception ignored) {
        }
    }
}
