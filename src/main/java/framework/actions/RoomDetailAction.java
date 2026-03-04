package framework.actions;

import framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.details.RoomDetailPage;
import pages.home.HomePage;
import pages.profile.ProfilePage;
import pages.rooms.RoomPage;
import utils.ScreenshotUtil;

public class RoomDetailAction {

    private RoomDetailAction() {}

    public static boolean bookRoomSuccess(RoomDetailPage detailPage, String day) {

        return detailPage
                .selectCheckInDate()
                .clickNextMonthButton()
                .selectDate(day)
                .closePopup()
                .clickBooking()
                .confirmBooking()
                .isBookingSuccess();
    }

    public static boolean bookRoomWithoutLogin(RoomDetailPage detailPage, String day) {

        detailPage
                .selectCheckInDate()
                .clickNextMonthButton()
                .selectDate(day)
                .closePopup()
                .clickBooking()
                .isLoginRequiredMessageDisplayed();

        return detailPage.isLoginRequiredMessageDisplayed();
    }

    public static ProfilePage bookRoomAndGoToProfile(RoomDetailPage detailPage, String day) {

        // Booking flow
        detailPage
                .selectCheckInDate()
                .clickNextMonthButton()
                .selectDate(day)
                .closePopup()
                .clickBooking()
                .confirmBooking()
                .clickProfileIcon();

        return detailPage.clickDashboard();
    }

    public static boolean openFirstRoomFromSearch(
            ScreenshotUtil screenshot,
            String locationName,
            String startDay,
            String endDay,
            int guestCount) throws InterruptedException {

        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver, screenshot);

        RoomPage roomPage = homePage
                .open()
                .clickLocationBox()
                .selectLocation(locationName)
                .openDatePicker()
                .goToNextMonth()
                .selectDay(startDay)
                .selectDay(endDay)
                .clickAddGuest()
                .increaseGuest(guestCount)
                .clickSearchButton();

        roomPage.scrollToRoomList();

        RoomDetailPage detailPage = new RoomDetailPage(driver, screenshot);
        detailPage.clickFirstRoomInGrid();
        Thread.sleep(2000);

        return detailPage.isRoomInformationDisplayed();
    }
}
