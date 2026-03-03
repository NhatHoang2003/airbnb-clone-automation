package framework.data.dataprovider;

import framework.enums.LoginType;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                { LoginType.VALID_CREDENTIALS }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                { LoginType.INVALID_CREDENTIALS },
                { LoginType.INVALID_EMAIL_FORMAT }
        };
    }

    @DataProvider(name = "emptyFields")
    public static Object[][] emptyFields() {
        return new Object[][]{
                { LoginType.EMPTY_FIELD },
                { LoginType.EMPTY_PASSWORD }
        };
    }
}