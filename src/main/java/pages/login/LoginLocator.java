package pages.login;

import org.openqa.selenium.By;

public class LoginLocator {

    public LoginLocator() {}

    public static final By EMAIL_FIELD = By.cssSelector("input[name='email']");
    public static final By PASSWORD_FIELD = By.cssSelector("input[name='password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    public static final By SUCCESS_MESSAGE = By.xpath("//span[text()='Đăng nhập thành công']");
    public static final By FAILURE_MESSAGE = By.xpath("//span[text()='Email hoặc mật khẩu không đúng !']");
    public static final By PROFILE_ICON_AFTER_LOGIN = By.cssSelector(".flex.items-center.md\\:order-2.space-x-3");
    public static final By EMAIL_ERROR_MESSAGE = By.cssSelector(".text-red-500");
    public static final By PASSWORD_ERROR_MESSAGE = By.cssSelector(".text-red-500");
    public static final By LOGIN_MODAL = By.xpath("//div[contains(@class,'ant-modal-wrap')]");
}