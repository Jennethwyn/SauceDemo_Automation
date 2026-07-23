package selenium.com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(BrowserEnum browser) {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser driver is not found: " + browser);
        }
        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}