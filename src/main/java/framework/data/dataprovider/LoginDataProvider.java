package framework.data.dataprovider;

import framework.enums.LoginType;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                { LoginType.VALID_USER }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                { LoginType.INVALID_EMAIL },
                { LoginType.INVALID_PASSWORD }
        };
    }

    @DataProvider(name = "emptyFields")
    public static Object[][] emptyFields() {
        return new Object[][]{
                { LoginType.EMPTY_USER }
        };
    }
}


