package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import utils.WaitUtil;

public class LoginPage {

    WebDriver driver;
    private WaitUtil wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    private By usernameField = By.id("emailId");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit' and .//span[text()='LOGIN']]");
    private By otpFields = By.cssSelector("#otpInputGroup input.otp-digit");
    private By otpLoginButton = By.id("btnLogin");

    public void login(String username, String password, String otp) {
        wait.waitForVisibility(usernameField).sendKeys(username);
        wait.waitForVisibility(passwordField).sendKeys(password);
        wait.waitForClickable(loginButton).click();
        wait.waitForVisibility(otpFields);
        
        List<WebElement> otpInput = driver.findElements(otpFields);
        otpInput.get(0).click();
        otpInput.get(0).sendKeys(otp);;
        
        wait.waitForClickable(otpLoginButton).click();
    }
}