package pages.rooms;

import org.openqa.selenium.By;

public class RoomLocator {
    private RoomLocator() {};

    public static final By ROOM_LINKS =
            By.cssSelector("a[href*='/room-detail/']");
    public static final By ROOM_IMG = By.cssSelector("img.swiper-image");
    public static final By ROOM_NAME = By.cssSelector("span.truncate.capitalize");
    public static final By ROOM_PRICE_PER_NIGHT = By.xpath(".//span[contains(text(),'$')]");
}
