package tests.login;

import framework.actions.LoginAction;
import framework.asserts.LoginAssertion;
import framework.data.dataprovider.LoginDataProvider;
import framework.data.model.LoginData;
import framework.data.model.TestCaseData;
import framework.enums.LoginType;
import framework.listeners.ExtentListener;
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
                LoginAction.loginValid(loginType);

        LoginAssertion.assertLogin(testCase);
    }

    @Test(dataProvider = "invalidCredentials",
            dataProviderClass = LoginDataProvider.class)
    public void testLoginWithInvalidCredentials(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.loginInValid(loginType);

        LoginAssertion.assertLogin(testCase);

    }

    @Test(dataProvider = "emptyFields",
            dataProviderClass = LoginDataProvider.class)
    public void testLoginWithEmptyField(LoginType loginType) {

        TestCaseData<LoginData> testCase =
                LoginAction.loginInValid(loginType);

        LoginAssertion.assertLogin(testCase);
    }
}
