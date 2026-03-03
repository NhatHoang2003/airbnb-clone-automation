package framework.data.dataprovider;

import framework.enums.RegisterType;
import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                { RegisterType.VALID_CREDENTIALS}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][] {
                { RegisterType.INVALID_CREDENTIALS },
                { RegisterType.INVALID_EMAIL_FORMAT },
                { RegisterType.INVALID_PHONE }
        };
    }

    @DataProvider(name = "emptyFields")
    public static Object[][] emptyFields() {
        return new Object[][]{
                { RegisterType.EMPTY_FIELD }
        };
    }
}
