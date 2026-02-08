package framework.data.model;

import java.util.Map;

public class UserDataRoot {

    private Map<String, TestCaseData<LoginData>> login;
    private Map<String, TestCaseData<RegisterData>> register;

    public Map<String, TestCaseData<LoginData>> getLogin() {
        return login;
    }

    public Map<String, TestCaseData<RegisterData>> getRegister() {
        return register;
    }
}
