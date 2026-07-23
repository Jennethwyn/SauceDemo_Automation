package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.com.saucedemo.BasePage;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String user) {
        type(username, user);
    }

    public void enterPassword(String pass) {
        type(password, pass);
    }

    public void clickLoginBtn() {
        click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return wait.waitForTitle("Swag Labs");
    }

    // Optional: combine all login steps into one business method
    public DashboardPage login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginBtn();
        
        return new DashboardPage(driver);
        
    }
}