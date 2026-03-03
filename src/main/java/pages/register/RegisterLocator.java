package pages.register;

import org.openqa.selenium.By;

public class RegisterLocator {

    public RegisterLocator() {}

    public static final By NAME_FIELD = By.id("name");
    public static final By EMAIL_FIELD = By.id("email");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By PHONE_FIELD = By.id("phone");
    public static final By BIRTHDAY_FIELD = By.id("birthday");
//    public static final By genderField = By.xpath("//span[@class='ant-select-selection-search']");
//    public static final By genderOption =
//    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Nam']");
    public static final By REGISTER_BUTTON = By.xpath("//button[@type='submit']");

    public static final By SUCCESS_MESSAGE = By.xpath("//span[text()='Đăng ký thành công']");
    public static final By EMAIL_EXIST = By.xpath("//span[text()='Email đã tồn tại !']");

    public static final By NAME_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");
    public static final By EMAIL_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");
    public static final By PASSWORD_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");
    public static final By PHONE_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");
    public static final By BIRTHDAY_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");

    public static final By ALL_ERROR_MESSAGE = By.cssSelector(".ant-form-item-explain-error");
}