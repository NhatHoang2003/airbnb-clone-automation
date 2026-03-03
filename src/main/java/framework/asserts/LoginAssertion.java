package framework.asserts;

import framework.data.model.LoginData;
import framework.data.model.TestCaseData;
import org.testng.Assert;

public class LoginAssertion {

    public static void assertLogin(TestCaseData<LoginData> testCase) {

        Assert.assertEquals(
                testCase.getActualLogin().isSuccess(),
                testCase.getExpected().isSuccess(),
                "Success status mismatch"
        );

        Assert.assertEquals(
                testCase.getActualLogin().getMessage().trim(),
                testCase.getExpected().getMessage().trim(),
                "Message mismatch"
        );
    }
}