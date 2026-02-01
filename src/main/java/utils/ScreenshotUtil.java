package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private final WebDriver driver;
    private final ExtentTest test;
    private int stepCount;
    private final String screenshotDir;

    public ScreenshotUtil(WebDriver driver, String flowName, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.stepCount = 0;

        String timeStamp = new SimpleDateFormat("yyyy_MMdd_HH-mm-ss")
                .format(new Date());

        screenshotDir = System.getProperty("user.dir")
                + "/test-output/screenshots/"
                + flowName + "/"
                + timeStamp;

        new File(screenshotDir).mkdirs();
    }

    public void capture(By locator, String stepName) {
        try {
            driver.findElement(locator);

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            stepCount++;

            String safeStepName =
                    stepName.replaceAll("[\\\\/:*?\"<>|]", "_");

            String fileName =
                    "Step_" + stepCount + "_" + safeStepName + ".png";

            String absolutePath = screenshotDir + "/" + fileName;

            Files.copy(
                    src.toPath(),
                    new File(absolutePath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            if (test != null) {
                test.info(stepName)
                        .addScreenCaptureFromPath(absolutePath);
            }

        } catch (Exception e) {
            if (test != null) {
                test.fail("Cannot capture screenshot: " + stepName);
            }
            e.printStackTrace();
        }
    }
}
