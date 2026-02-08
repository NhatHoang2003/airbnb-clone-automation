package framework.data.dataprovider;

import framework.enums.RegisterType;
import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                { RegisterType.VALID_USER }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][] {
                { RegisterType.INVALID_EMAIL },
                { RegisterType.INVALID_PASSWORD },
                { RegisterType.INVALID_PHONE },
                { RegisterType.INVALID_BIRTHDAY },
                { RegisterType.INVALID_GENDER }
        };
    }

    @DataProvider(name = "emptyField")
    public static Object[][] emptyField() {
        return new Object[][]{
                { RegisterType.EMPTY_USER }
        };
    }
}
