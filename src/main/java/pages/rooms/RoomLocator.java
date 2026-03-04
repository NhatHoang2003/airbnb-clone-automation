package pages.rooms;

import org.openqa.selenium.By;

public class RoomLocator {
    private RoomLocator() {};

    public static final By ROOM_LINKS =
            By.cssSelector("a[href*='/room-detail/']");
    public static final By ROOM_IMG = By.cssSelector("img.swiper-image");
    public static final By ROOM_NAME = By.cssSelector("span.truncate.capitalize");
    public static final By ROOM_PRICE_PER_NIGHT = By.xpath(".//span[contains(text(),'$')]");

    public static final By ACTIVE_SLIDE_IMAGE =
            By.cssSelector(".swiper-slide-active img");

    public static final By PRICE_LIST =
            By.xpath("//div[contains(@class,'text-right')]//span[contains(@class,'font-bold')]");


    public static final By SWIPER_NEXT_BUTTON =
            By.xpath("(//div[contains(@class,'swiper')]//div[contains(@class,'swiper-button-next')])[1]");

    public static final By SWIPER_PREV_BUTTON =
            By.xpath("(//div[contains(@class,'swiper')]//div[contains(@class,'swiper-button-prev')])[1]");

    public static final By ROOM_GRID_01 = By.cssSelector("div.grid.grid-cols-1.md\\:grid-cols-2.gap-5");
}
