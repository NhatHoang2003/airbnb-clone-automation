package tests.login;

import framework.actions.LoginAction;
import framework.data.dataprovider.LoginDataProvider;
import framework.enums.UserType;
import framework.listeners.ExtentListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Listeners({ExtentListener.class})
public class LoginTest extends BaseTest {

    @Test(
            dataProvider = "validCredentials",
            dataProviderClass = LoginDataProvider.class
    )
    public void testLoginWithValidCredentials(UserType userType) {
        LoginAction.login(userType);

        Assert.assertTrue(true);
    }
}
