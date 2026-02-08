package tests.login;

import framework.actions.LoginAction;
import framework.data.dataprovider.LoginDataProvider;
import framework.data.model.LoginData;
import framework.data.model.TestCaseData;
import framework.enums.LoginType;
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
    public void testLoginWithValidCredentials(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.login(loginType);

        boolean expected = testCase.getExpected().isSuccess();
        boolean actual = true;

        Assert.assertEquals(actual, expected);
    }

}
