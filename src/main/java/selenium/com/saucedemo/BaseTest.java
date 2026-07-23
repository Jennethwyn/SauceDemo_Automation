package selenium.com.saucedemo;

import java.time.Duration;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import utils.ScreenShot;

public class BaseTest {
	static String url = ConfigReader.getProperty("url");

	@BeforeMethod
	public void setUp() {
		String browser = ConfigReader.getProperty("browser");
		BrowserEnum browserType =  BrowserEnum.valueOf(browser.toUpperCase());
		DriverFactory.initializeDriver(browserType);

		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	protected DashboardPage loginAsStandardUser() {
		LoginPage lp = new LoginPage(DriverFactory.getDriver());
		return lp.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShot.takeScreenShot(DriverFactory.getDriver(), testName+" Failed", "Fail");
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {

			ScreenShot.takeScreenShot(DriverFactory.getDriver(), testName+" PASSED", "Pass");
		}
		else if(result.getStatus() == ITestResult.SKIP) {

			ScreenShot.takeScreenShot(DriverFactory.getDriver(), testName+" PASSED", "Skip");
		}
		DriverFactory.tearDown();
	}

}
