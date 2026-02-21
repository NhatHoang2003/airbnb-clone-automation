package pages.details;

import framework.actions.ElementActions;
import framework.base.BasePage;
import framework.enums.WaitType;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.profile.ProfilePage;
import pages.rooms.RoomLocator;
import utils.ScreenshotUtil;

public class RoomDetailPage extends BasePage {

    // Overlay loading
    private final By IMAGE_MASK = By.className("ant-image-mask");

    public RoomDetailPage(WebDriver driver, ScreenshotUtil screenshotUtil) {
        super(driver, screenshotUtil);
    }

    // ===== OPEN CHECK-IN CALENDAR =====
    public RoomDetailPage selectCheckInDate() {

        waitUtil.waitForLoadingDisappear(IMAGE_MASK);

        WebElement checkIn =
                waitUtil.waitFor(RoomDetailLocator.CHECK_IN_BOX, WaitType.VISIBLE);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", checkIn);

        waitUtil.waitFor(checkIn, WaitType.CLICKABLE);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkIn);

        return this;
    }

    // ===== CLICK NEXT MONTH =====
    public RoomDetailPage clickNextMonthButton() {

        waitUtil.waitFor(RoomDetailLocator.NEXT_MONTH_BUTTON, WaitType.CLICKABLE);

        actions.clicksBy(RoomDetailLocator.NEXT_MONTH_BUTTON, "Click Next Month");

        return this;
    }

    // ===== SELECT DATE =====
    public RoomDetailPage selectDate(String day) {

        By dateLocator = By.xpath(
                "//span[@class='rdrDayNumber']/span[text()='" + day + "']"
        );

        WebElement date = waitUtil.waitFor(dateLocator, WaitType.CLICKABLE);

        highlight(date);
        slowDown();

        actions.clicksBy(dateLocator, "Select Date " + day);

        return this;
    }

    // ===== CLOSE POPUP =====
    public RoomDetailPage closePopup() {

        WebElement closeBtn =
                waitUtil.waitFor(RoomDetailLocator.CLOSE_BUTTON, WaitType.VISIBLE);

        // Scroll vào giữa màn hình
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", closeBtn);

        // Click bằng JS để tránh bị intercept
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", closeBtn);

        // Đợi popup biến mất
        waitUtil.waitFor(RoomDetailLocator.CLOSE_BUTTON, WaitType.INVISIBLE);

        return this;
    }

    // ===== CLICK BOOKING =====
    public RoomDetailPage clickBooking() {

        // 1️. Đợi button xuất hiện
        WebElement bookingBtn =
                waitUtil.waitFor(RoomDetailLocator.BOOKING_BUTTON, WaitType.VISIBLE);

        // 2. Scroll trang xuống gần cuối
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // 3️. Scroll chính xác vào button (quan trọng)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", bookingBtn);

        // 4️. Đợi clickable
        waitUtil.waitFor(bookingBtn, WaitType.CLICKABLE);

        highlight(bookingBtn);
        slowDown();

        // 5. Click an toàn
        try {
            bookingBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", bookingBtn);
        }

        return this;
    }

    // ===== CONFIRM BOOKING =====
    public RoomDetailPage confirmBooking() {

        waitUtil.waitForLoadingDisappear(IMAGE_MASK);

        WebElement confirmBtn =
                waitUtil.waitFor(RoomDetailLocator.CONFIRM_BUTTON, WaitType.VISIBLE);

        highlight(confirmBtn);
        slowDown();

        try {
            confirmBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", confirmBtn);
        }

        WebElement successMsg =
                waitUtil.waitFor(RoomDetailLocator.BOOKING_SUCCESS_MESSAGE,
                        WaitType.VISIBLE);

        highlight(successMsg);
        screenshotUtil.capture("Booking Success Message");

        return this;
    }

    // ===== VERIFY SUCCESS =====
    public boolean isBookingSuccess() {
        try {
            WebElement successMsg = waitUtil.waitFor(
                    RoomDetailLocator.BOOKING_SUCCESS_MESSAGE,
                    WaitType.PRESENT
            );

            return successMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== VERIFY LOGIN REQUIRED =====
    public boolean isLoginRequiredMessageDisplayed() {
        try {
            WebElement loginMsg = waitUtil.waitFor(
                    RoomDetailLocator.LOGIN_REQUIRED_NOTIFICATION,
                    WaitType.VISIBLE
            );

            highlight(loginMsg);
            slowDown();

            screenshotUtil.capture("Login Required Notification");

            return loginMsg.isDisplayed();
        } catch (Exception e) {
            screenshotUtil.capture("Login Required Not Found");
            return false;
        }
    }

    public RoomDetailPage clickProfileIcon() {

        waitUtil.waitForLoadingDisappear(IMAGE_MASK);

        WebElement profile =
                waitUtil.waitFor(RoomDetailLocator.PROFILE_ICON, WaitType.VISIBLE);

        waitUtil.waitFor(profile, WaitType.CLICKABLE);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", profile);

        try {
            profile.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", profile);
        }

        return this;
    }

    public ProfilePage clickDashboard() {

        actions.clicksBy(
                RoomDetailLocator.DASHBOARD_BUTTON,
                "Click Dashboard"
        );

        return new ProfilePage(driver, screenshotUtil);
    }

    // ===== FULL FLOW =====
    public boolean booking(String checkInDay) {

        selectCheckInDate()
                .clickNextMonthButton()   // Bấm next month
                .selectDate(checkInDay)   // Chọn ngày
                .closePopup()             // Đóng popup
                .clickBooking()
                .confirmBooking();

        return isBookingSuccess();
    }
}