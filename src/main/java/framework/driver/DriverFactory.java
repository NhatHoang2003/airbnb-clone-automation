package framework.driver;

import framework.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createDriver(BrowserType browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        
        // Disable CDP version mismatch warning
        options.setCapability("goog:loggingPrefs", new java.util.HashMap<String, String>() {{
            put("browser", "INFO");
        }});
        
        // Add options để tránh session disconnect
        options.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--disable-blink-features=AutomationControlled",
                "--disable-background-networking",
                "--disable-breakpad",
                "--disable-client-side-phishing-detection",
                "--disable-hang-monitor",
                "--window-size=1920,1080"
        );
        
        return new ChromeDriver(options);
    }
}

