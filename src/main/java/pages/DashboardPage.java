package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.com.saucedemo.BasePage;
import utils.ScreenShot;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		
	}
	By addBtn = By.id("add-to-cart-sauce-labs-backpack");
	
	public void addToCart() {
		click(addBtn);
	}
	
	public void removeFromCart() {
		click(addBtn);
	}


}
