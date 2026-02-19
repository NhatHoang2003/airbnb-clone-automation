package tests.rooms;

import framework.actions.RoomAction;
import framework.data.model.TestCaseData;
import framework.listeners.ExtentListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Listeners({ExtentListener.class})
public class RoomTest extends BaseTest {
    @Test
    public void verifySearchRoom() {

        boolean actual = RoomAction.searchRoom();

        Assert.assertTrue(actual);
    }
}
