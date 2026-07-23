package selenium.com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.DashboardPage;

public class AddToCartTest extends BaseTest{

	
	
	

	@Test
	public void addToCartTest() {
		DashboardPage dp = loginAsStandardUser();
		dp.addToCart();
		
	}
}
