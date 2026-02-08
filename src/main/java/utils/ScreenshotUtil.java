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

        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss")
                .format(new Date());

        screenshotDir = System.getProperty("user.dir")
                + "/test-output/screenshots/"
                + flowName + "/"
                + timeStamp;

        new File(screenshotDir).mkdirs();
    }

    public void capture(String stepName) {
        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            stepCount++;

            String fileName =
                    "Step_" + stepCount + "_" +
                            stepName.replaceAll("[\\\\/:*?\"<>|]", "_") +
                            ".jpg";

            Files.copy(
                    src.toPath(),
                    new File(screenshotDir, fileName).toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            if (test != null) {
                test.info(stepName)
                        .addScreenCaptureFromPath(
                                screenshotDir + "/" + fileName
                        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
