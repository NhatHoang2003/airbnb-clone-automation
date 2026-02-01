package framework.data.dataprovider;

import framework.enums.UserType;
import org.testng.annotations.DataProvider;

public final class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                { UserType.VALID_USER }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                { UserType.INVALID_PASSWORD }
        };
    }

    @DataProvider(name = "emptyFields")
    public static Object[][] emptyFields() {
        return new Object[][]{
                { UserType.EMPTY_EMAIL }
        };
    }
}
