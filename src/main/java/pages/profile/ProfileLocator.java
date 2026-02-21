package pages.profile;

import org.openqa.selenium.By;

public class ProfileLocator {
    public ProfileLocator() {}

    public static final By EDIT_PROFILE_BUTTON = By.xpath("//h1[contains(text(),'Phòng đã thuê')]/preceding-sibling::button");
    public static final By UPDATE_BUTTON = By.xpath("//div[contains(@class,'ant-modal-content')]//span[text()='Cập nhật']/ancestor::button");
    public static final By EMAIL_INPUT = By.xpath("//input[@id='email']");
    public static final By PHONE_INPUT = By.xpath("//input[@id='phone']");
    public static final By NAME_INPUT = By.xpath("//input[@id='name']");
    public static final By BIRTHDAY_INPUT = By.xpath("//input[@id='birthday']");
    public static final By GENDER_OPTION_NAM = By.xpath("//div[@id='gender_list']//div[@aria-label='Nam']");
    public static final By BOOKED_ROOM_FIRST_CARD = By.xpath("//h1[contains(text(),'Phòng đã thuê')]/following::div[contains(@class,'ant-card-hoverable')][1]");
}
