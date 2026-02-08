package framework.data.model;

public class TestCaseData<Type> {

    private Type data;
    private ExpectedResult expected;

    public Type getData() {
        return data;
    }

    public ExpectedResult getExpected() {
        return expected;
    }
}
