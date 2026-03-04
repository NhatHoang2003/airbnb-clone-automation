package pages.home;

import org.openqa.selenium.By;

public class HomeLocator {

    private HomeLocator() {
    }

    public static final By UPLOADAVT_BUTTON = By.xpath("//button[text()='Cập nhật ảnh']"); //button[text()='Cập nhật ảnh']
    public static final By LOGIN_MENU_OPTION = By.xpath("//button[text()='Đăng nhập']");
    public static final By REGISTRATION_MENU_OPTION = By.xpath("//button[text()='Đăng ký']");
    public static final By SEARCH_BUTTON = By.xpath("//span[@aria-label='search']/ancestor::div[1]");
    public static final By LOADING_OVERLAY = By.cssSelector("div.fixed.inset-0");
    public static final By DROPDOWN_ADD_GUEST = By.xpath("//p[normalize-space()='Thêm khách']");

    public static final By PLUS_GUEST_BUTTON = By.xpath("//div[normalize-space()='+']/parent::button");
    public static final By DATE_INPUT = By.xpath("//p[contains(text(),'/')]/parent::div");
    public static final By NEXT_MONTH_BUTTON = By.xpath("//button[contains(@class,'rdrNextButton')]");

    public static By dayInFirstMonth(String day) {
        return By.xpath(
                "(//div[contains(@class,'rdrMonth')])[1]//button[.//span[text()='" + day + "']]"
        );
    }

    public static final By LOCATION_BOX = By.xpath("(//div[contains(@class,'col-span-3')])[1]");
    public static final By DATE_PICKER_BOX = By.xpath("(//div[contains(@class,'col-span-4')])[1]");
    public static final By ADD_GUEST_BOX = By.xpath("(//div[contains(@class,'col-span-3')])[2]");

    public static By locationItem(String locationName) {
        return By.xpath(
                "//div[contains(@class,'grid')]//div[.//p[text()='"
                        + locationName + "']]"
        );
    }
}
