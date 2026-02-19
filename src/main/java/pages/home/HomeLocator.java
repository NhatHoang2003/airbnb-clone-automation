package pages.home;

import org.openqa.selenium.By;

public class HomeLocator {

    private HomeLocator() {}

    public static final By PROFILE_ICON = By.cssSelector(".rounded-full");
    public static final By LOGIN_MENU_OPTION = By.xpath("//button[text()='Đăng nhập']");
    public static final By REGISTRATION_MENU_OPTION = By.xpath("//button[text()='Đăng ký']");
    public static final By SEARCH_BUTTON = By.xpath("//span[@aria-label='search']/ancestor::div[1]");
    public static final By LOADING_OVERLAY = By.cssSelector("div.fixed.inset-0");

}
