package pages.register;

import org.openqa.selenium.By;

public class RegisterLocator {

    public RegisterLocator() {}

    public static final By nameField = By.id("name");
    public static final By emailField = By.id("email");
    public static final By passwordField = By.id("password");
    public static final By phoneField = By.id("phone");
    public static final By birthdayField = By.id("birthday");
    public static final By genderField = By.id("gender");
    public static final By registerButton = By.xpath("//button[@type='submit']");
}