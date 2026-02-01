package framework.data.factory;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import framework.data.model.LoginData;
import framework.enums.UserType;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonDataFactory {

    private static final Map<String, LoginData> LOGIN_DATA;

    static {
        try {
            InputStream is = JsonDataFactory.class
                    .getClassLoader()
                    .getResourceAsStream("data/login.json");

            if (is == null) {
                throw new RuntimeException("Not found login.json");
            }

            Reader reader = new InputStreamReader(is);
            Type type = new TypeToken<Map<String, LoginData>>() {}.getType();
            LOGIN_DATA = new Gson().fromJson(reader, type);

        } catch (Exception e) {
            throw new RuntimeException("Load json failure", e);
        }
    }

    public static LoginData getLoginData(UserType userType) {
        return LOGIN_DATA.get(userType.name());
    }
}

