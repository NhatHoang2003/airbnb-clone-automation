package pages.home;

import org.openqa.selenium.By;

public class HomeLocator {

    private HomeLocator() {}

    public static final By PROFILE_ICON = By.cssSelector(".rounded-full");
    public static final By LOGIN_MENU_OPTION = By.xpath("//button[text()='Đăng nhập']");
    public static final By REGISTRATION_MENU_OPTION = By.xpath("//button[text()='Đăng ký']");
}
