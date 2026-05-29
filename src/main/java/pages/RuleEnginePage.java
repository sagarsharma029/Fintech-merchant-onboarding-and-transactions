package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

public class RuleEnginePage {

    private WebDriver driver;
    private WaitUtil wait;

    public RuleEnginePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    private By merchantSetupMenu =
            By.xpath("//span[contains(text(),'Merchant Setup')]");

    private By ruleEngineOption =
            By.xpath("//a[@id='ruleEngine']");

    private By merchantSearchDropdown =
            By.xpath("//span[@id='select2-offus_merchant-container']");

    private By merchantSearchInput =
            By.xpath("//input[contains(@class,'select2-search__field')]");

    private By merchantOption =
            By.xpath("//ul[contains(@class,'select2-results__options')]/li[1]");

    private By currencyCheckBox =
            By.xpath("(//input[@name='currency' and @value='INR'])[2]");

    private By acquirer =
            By.xpath("(//input[@name='Acquirer1' and @value='DEMO'])");

    private By allMOPCheckboxes =
            By.xpath("//input[@name='mopType' and @type='checkbox']");

    private By txnType =
            By.xpath("(//input[@name='txnType' and @value='SALE'])[2]");

    private By region =
            By.xpath("(//input[@name='region' and @value='DOMESTIC'])");

    private By cardConsumerType =
            By.xpath("(//input[@id='typeCardCONSUMER' and @value='CONSUMER'])");

    private By saveBtn =
            By.xpath("//button[@id='offus_submit' and not(contains(@class,'disabled'))]");

    private By okButton =
            By.xpath("//div[contains(@class,'sweet-alert')]//button[contains(@class,'confirm')]");


    public void navigateToSettlementSettings() {

        wait.waitForClickable(merchantSetupMenu).click();
        wait.waitForClickable(ruleEngineOption).click();
    }


    public void createRules(String merchantName, String paymentTypeValue) throws InterruptedException {

        wait.waitForClickable(merchantSearchDropdown).click();
        wait.waitForVisibility(merchantSearchInput).sendKeys(merchantName);
        driver.findElement(merchantOption).click();
        wait.clickWithRetry(currencyCheckBox);
        wait.clickWithRetry(acquirer);

        By paymentType = By.xpath("//input[@name='paymentType' and @value='"+ paymentTypeValue + "']");
        wait.clickWithRetry(paymentType);

        wait.waitForNumberOfElementsToBeMoreThan(allMOPCheckboxes,0);

        List<WebElement> mops =
                driver.findElements(allMOPCheckboxes);

        for (WebElement mop : mops) {

            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",mop);

            } catch (Exception e) {
                System.out.println( "Skipping stale MOP");
            }
        }

        wait.clickWithRetry(txnType);
        wait.clickWithRetry(region);
        wait.clickWithRetry(cardConsumerType);
        wait.clickWithRetry(saveBtn);
        wait.clickWithRetry(okButton);

        driver.navigate().refresh();
        Thread.sleep(3000);
    }
}