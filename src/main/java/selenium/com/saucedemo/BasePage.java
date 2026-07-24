package selenium.com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    protected WebElement findElement(By locator) {
        return wait.waitForElementVisibility(locator);
    }

    protected void click(By locator) {
        wait.waitForElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.waitForElementVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
    
    protected String getTextFromElement(By locator) {
    	WebElement element = wait.waitForElementVisibility(locator);
    	String text = element.getText();
		return text;
    	
    }
}