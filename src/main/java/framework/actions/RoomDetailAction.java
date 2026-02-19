package framework.actions;

import pages.details.RoomDetailPage;

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
}
