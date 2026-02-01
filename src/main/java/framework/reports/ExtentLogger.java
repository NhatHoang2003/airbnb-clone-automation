package framework.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentLogger {

    private ExtentLogger() {}

    private static ExtentTest getTest() {
        return ExtentManager.getTest();
    }

    public static void pass(String message) {
        if (getTest() != null)
            getTest().pass(message);
    }

    public static void fail(String message) {
        if (getTest() != null)
            getTest().fail(message);
    }

    public static void fail(Throwable throwable) {
        if (getTest() != null)
            getTest().fail(throwable);
    }

    public static void skip(String message) {
        if (getTest() != null)
            getTest().skip(message);
    }

    public static void info(String message) {
        if (getTest() != null)
            getTest().info(message);
    }
}
