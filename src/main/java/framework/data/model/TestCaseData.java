package framework.data.model;


public class TestCaseData<T> {

    private T data;
    private ExpectedResult expected;
    private LoginResult actualLogin;
    private RegisterResult actualRegister;

    public TestCaseData(T data, ExpectedResult expected) {
        this.data = data;
        this.expected = expected;
    }

    public T getData() {
        return data;
    }

    public ExpectedResult getExpected() {
        return expected;
    }

    public LoginResult getActualLogin() {
        return actualLogin;
    }

    public RegisterResult getActualRegister() { return  actualRegister; }

    public void setActualLogin(LoginResult actualLogin) {
        this.actualLogin = actualLogin;
    }

    public void setActualRegister(RegisterResult actualRegister) { this.actualRegister = actualRegister; }
}