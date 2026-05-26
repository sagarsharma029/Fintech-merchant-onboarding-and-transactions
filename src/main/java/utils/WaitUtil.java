package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import org.openqa.selenium.StaleElementReferenceException;

public class WaitUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void waitForNumberOfElementsToBeMoreThan(By locator, int count) {
        wait.until(driver -> driver.findElements(locator).size() > count);
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public void waitForElementToBeEnabled(WebElement element) {
	    wait.until(driver ->element.isEnabled());
	}
    
    public void waitForElementToRefresh(By locator) {
        wait.until(driver -> {
            try {
                return driver.findElement(locator)
                        .isDisplayed();
            } catch (
                    StaleElementReferenceException e
            ) {
                return false;
            }
        });
    }
    
    public void clickWithRetry(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;

            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Retrying click due to stale element: "+ locator);
            }
        }

        throw new RuntimeException("Unable to click element after retries: "+ locator);
    }
    
    public void waitForAttributeContains(By locator, String attribute, String value) {
        wait.until(driver -> driver.findElement(locator).getAttribute(attribute).contains(value));
    }
    
    public void waitForTextToNotBePresent(By locator, String text) {
        wait.until(driver -> !driver.findElement(locator).getText().contains(text));
    }
    
}