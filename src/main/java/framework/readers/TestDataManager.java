package framework.readers;

import framework.data.factory.JsonDataFactory;
import framework.data.model.LoginData;
import framework.data.model.RegisterData;
import framework.data.model.TestCaseData;
import framework.enums.LoginType;
import framework.enums.RegisterType;

public class TestDataManager {

    public static TestCaseData<RegisterData> register(RegisterType type) {
        return JsonDataFactory.getRegisterCase(type);
    }

    public static TestCaseData<LoginData> login(LoginType loginType) {
        return JsonDataFactory.getLoginCase(loginType);
    }
}
