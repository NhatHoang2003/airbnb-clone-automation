package tests.details;

import framework.actions.LoginAction;
import framework.actions.RoomAction;
import framework.actions.RoomDetailAction;
import framework.data.dataprovider.LoginDataProvider;
import framework.enums.LoginType;
import framework.listeners.ExtentListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.details.RoomDetailPage;
import pages.home.HomePage;
import tests.base.BaseTest;

@Listeners({ExtentListener.class})
public class RoomDetailTest extends BaseTest {

    @Test
//    TC16: Đặt phòng thành công (end-to-end flow)
    public void verifyBookingSuccess() {

        // 1. Login cho booking
        LoginAction.loginForBooking(LoginType.VALID_USER);

        // 2. Search
        Assert.assertTrue(RoomAction.searchRoom());

        // 3. Open room
        RoomDetailPage detailPage =
                RoomAction.openFirstRoom();

        Assert.assertNotNull(detailPage);

        // 4. Booking
        boolean result =
                RoomDetailAction.bookRoomSuccess(detailPage, "19");

        Assert.assertTrue(result);
    }

    @Test
//    TC-18: Đặt phòng thất bại - Chưa đăng nhập
    public void verifyBookingWithoutLogin() {

        // 1. Search room
        Assert.assertTrue(RoomAction.searchRoom());

        // 2. Open first room
        RoomDetailPage detailPage = RoomAction.openFirstRoom();
        Assert.assertNotNull(detailPage);

        // 3. Booking
        boolean result =
                RoomDetailAction.bookRoomWithoutLogin(detailPage, "19");

        Assert.assertTrue(result);
    }
}
