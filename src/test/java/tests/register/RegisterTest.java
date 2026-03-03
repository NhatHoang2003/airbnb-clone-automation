package tests.register;

import framework.actions.RegisterAction;
import framework.asserts.RegisterAssertion;
import framework.data.dataprovider.RegisterDataProvider;
import framework.data.model.RegisterData;
import framework.data.model.TestCaseData;
import framework.enums.RegisterType;
import framework.listeners.ExtentListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Listeners(ExtentListener.class)
public class RegisterTest extends BaseTest {

    @Test(
            dataProvider = "validCredentials",
            dataProviderClass = RegisterDataProvider.class
    )
    public void testRigisterWithValidCredentials (RegisterType registerType){

        TestCaseData<RegisterData> testCaseData =
                RegisterAction.registerValid(registerType);

        RegisterAssertion.assertRegister(testCaseData);
    }


    @Test(
            dataProvider = "invalidCredentials",
            dataProviderClass = RegisterDataProvider.class
    )
    public void testRegisterWithInvalidCredentials (RegisterType registerType){

        TestCaseData<RegisterData> testCaseData =
                RegisterAction.registerInvalid(registerType);

        RegisterAssertion.assertRegister(testCaseData);
    }

    @Test(
            dataProvider = "emptyFields",
            dataProviderClass = RegisterDataProvider.class
    )
    public void testRegisterWithEmptyFields(RegisterType registerType){

        TestCaseData<RegisterData> testCaseData =
                RegisterAction.registerInvalid(registerType);

        RegisterAssertion.assertRegister(testCaseData);
    }




}
