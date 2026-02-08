package framework.data.factory;

import com.google.gson.Gson;
import framework.data.model.*;
import framework.enums.LoginType;
import framework.enums.RegisterType;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonDataFactory {

    private static final UserDataRoot DATA;

    static {
        try {
            InputStream is = JsonDataFactory.class
                    .getClassLoader()
                    .getResourceAsStream("data/userdata.json");

            if (is == null) {
                throw new RuntimeException("Not found data/userdata.json");
            }

            DATA = new Gson().fromJson(new InputStreamReader(is), UserDataRoot.class);

        } catch (Exception e) {
            throw new RuntimeException("Load json failure", e);
        }
    }

    public static TestCaseData<LoginData> getLoginCase(LoginType type) {
        return DATA.getLogin().get(type.name());
    }

    public static TestCaseData<RegisterData> getRegisterCase(RegisterType type) {
        return DATA.getRegister().get(type.name());
    }
}
