package framework.actions;

import pages.details.RoomDetailPage;
import pages.profile.ProfilePage;
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
}
