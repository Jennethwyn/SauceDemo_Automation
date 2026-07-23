package selenium.com.saucedemo;

import org.testng.Assert;

import org.testng.annotations.Test;



import pages.LoginPage;
import utils.ConfigReader;
import utils.ScreenShot;



public class LoginTest extends BaseTest{
	
	@Test
	public void Login() {
		LoginPage lp = new LoginPage (DriverFactory.getDriver());
		
		lp.enterUsername(ConfigReader.getProperty("username"));
		lp.enterPassword(ConfigReader.getProperty("password"));
		ScreenShot.takeScreenShot(DriverFactory.getDriver(), "Login");
		lp.clickLoginBtn();
		Assert.assertTrue(lp.isLoginSuccessful(), "Login was not successful");
		ScreenShot.takeScreenShot(DriverFactory.getDriver(), "Successful");
	}
	
}
