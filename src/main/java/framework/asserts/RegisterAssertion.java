package framework.asserts;

import framework.data.model.RegisterData;
import framework.data.model.TestCaseData;
import org.testng.Assert;

public class RegisterAssertion {

    public static void assertRegister(TestCaseData<RegisterData> testCase) {

        Assert.assertEquals(
                testCase.getActualRegister().getMessage().trim(),
                testCase.getExpected().getMessage().trim(),
                "Message mismatch"
        );
    }
}