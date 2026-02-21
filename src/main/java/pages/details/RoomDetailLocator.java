package pages.details;

import org.openqa.selenium.By;

public class RoomDetailLocator {
    public static final By CHECK_IN_BOX =
            By.xpath("//div[contains(@class,'cursor-pointer') and .//div[text()='Nhận phòng']]");
    public static final By DECREASE_GUEST_BUTTON = By.xpath("//button[.//div[text()='–']]");
    public static final By INCREASE_GUEST_BUTTON = By.xpath("//button[.//div[text()='+']]");
    public static final By GUEST_COUNT = By.xpath("//div(contains(text(),'khách')]");
    public static final By BOOKING_BUTTON = By.xpath("//button[contains(text(),'Đặt')]");
    public static final By CONFIRM_BUTTON =
            By.xpath("//button[contains(.,'Xác')]");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[contains(text(),'thành công')]");
    public static final By DATE_16 = By.xpath("//span[@class='rdrDayNumber']/span[text()='16']");
    public static final By CLOSE_BUTTON = By.xpath("//button[text()='Close']");
    public static final By NEXT_MONTH_BUTTON = By.xpath("//button[contains(@class,'rdrNextButton')]");
    public static final By LOGIN_WARNING_MESSAGE = By.cssSelector(".ant-notification-notice-description");
    public static final By BOOKING_SUCCESS_MESSAGE = By.xpath("//div[contains(@class,'ant-notification-notice-success')]//div[contains(@class,'ant-notification-notice-message')]");
    public static final By LOGIN_REQUIRED_NOTIFICATION = By.xpath("//div[contains(@class,'ant-notification-notice-description') and normalize-space()='Vui lòng đăng nhập để tiếp tục đặt phòng.']");
    public static final By DASHBOARD_BUTTON = By.xpath("//a[@href='/info-user' and contains(text(), 'Dashboard')]");
    public static final By PROFILE_ICON = By.cssSelector(".rounded-full");
}
