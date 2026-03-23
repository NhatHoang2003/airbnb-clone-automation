package tests.smoke;

import framework.enums.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SmokeConfigTest {

    @Test
    public void config_should_load_and_parse() {
        String baseUrl = ConfigReader.getBaseUrl();
        String browser = ConfigReader.getBrowser();

        Assert.assertNotNull(baseUrl, "base.url should not be null");
        Assert.assertFalse(baseUrl.isBlank(), "base.url should not be blank");
        Assert.assertTrue(baseUrl.startsWith("http"), "base.url should look like a URL");

        Assert.assertNotNull(browser, "browser should not be null");
        Assert.assertFalse(browser.isBlank(), "browser should not be blank");

        // Ensure BrowserType.valueOf(...) doesn't throw (valid config)
        BrowserType.valueOf(browser);
    }
}

