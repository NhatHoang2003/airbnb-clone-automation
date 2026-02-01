package framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import framework.reports.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.init();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getExtent()
                .createTest(result.getMethod().getMethodName());

        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
        ExtentManager.unload();
    }
}
