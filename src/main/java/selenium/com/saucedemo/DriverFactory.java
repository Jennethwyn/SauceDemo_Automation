package selenium.com.saucedemo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(BrowserEnum browser) {

        WebDriver webDriver;

        switch (browser) {

            case CHROME:

                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                // Disable Chrome Password Manager
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);

                // Disable save password prompts
                prefs.put("profile.password_manager_leak_detection", false);

                // Disable notifications
                prefs.put(
                    "profile.default_content_setting_values.notifications",
                    2
                );

                options.setExperimentalOption("prefs", prefs);

                // Disable Google Password Leak Detection popup
                options.addArguments(
                    "--disable-features=PasswordLeakDetection"
                );

                // Disable Chrome notifications
                options.addArguments("--disable-notifications");

                // Start Chrome maximized
                options.addArguments("--start-maximized");

                webDriver = new ChromeDriver(options);

                break;


            case EDGE:

                webDriver = new EdgeDriver();
                break;


            case FIREFOX:

                webDriver = new FirefoxDriver();
                break;


            default:
                throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                );
        }


        webDriver.manage()
                 .window()
                 .maximize();

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