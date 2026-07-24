package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.com.saucedemo.BasePage;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
	
	}
	By addBtn = By.id("add-to-cart-sauce-labs-backpack");
	By removeBtn = By.id("remove-sauce-labs-backpack");
	
	public String isAddToCartSuccessful() {
		System.out.println(getTextFromElement(removeBtn));
		return getTextFromElement(removeBtn);
	}
	public void addToCart() {
		click(addBtn);
	}
	
	public void removeFromCart() {
		click(removeBtn);
	}


}
