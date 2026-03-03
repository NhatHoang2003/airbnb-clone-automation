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
import pages.details.RoomDetailLocator;
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
        actions.clicksBy(RoomDetailLocator.PROFILE_ICON, "Click profile icon");
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

    public void waitForLoginSuccess() {
        try {
            wait.waitFor(HomeLocator.LOADING_OVERLAY, WaitType.INVISIBLE);
        } catch (Exception ignored) {
            // nếu không có overlay thì bỏ qua
        }
    }
}
