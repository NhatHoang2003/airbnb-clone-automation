package pages.login;

import org.openqa.selenium.By;

public class LoginLocator {

    public LoginLocator() {}

    public static final By EMAIL_FIELD = By.cssSelector("input[name='email']");
    public static final By PASSWORD_FIELD = By.cssSelector("input[name='password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
}
