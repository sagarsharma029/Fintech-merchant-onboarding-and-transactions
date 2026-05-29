package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtil;

public class SettlementSettingPage {

    private WebDriver driver;
    private WaitUtil wait;

    public SettlementSettingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }
    
    private By settlementSettingOption = By.id("SettlementSetting");
    
    private By merchantSearchDropdown = By.xpath("//span[@id='select2-autoSettlementMerchant-container']");
    private By merchantSearchInput = By.xpath("//input[contains(@class,'select2-search__field')]");
    private By merchantOption = By.xpath("//ul[contains(@class,'select2-results__options')]/li[1]");
    
    private By settlementCycle = By.xpath("//input[@id='transactionSettlementDay']");
    
    private By settlementModel = By.xpath("//select[@id='settlementModel']");
    
    private By refundAmount = By.xpath("//input[@id='relaxationAmt']");
    
    private By saveBtn1 = By.xpath("//input[@id = 'submit']"); 
    
    public void navigateToSettlementSettings() {
 	   wait.waitForClickable(settlementSettingOption).click();
 	  
    }
    
    public void selectMerchant(String merchantName) {

        wait.waitForClickable(merchantSearchDropdown).click();
        wait.waitForVisibility(merchantSearchInput).sendKeys(merchantName);
        
        driver.findElement(merchantOption).click();
    }
    
    
    public void fillSettlementSettingPage() {
    	driver.findElement(settlementCycle).clear();
    	driver.findElement(settlementCycle).sendKeys("1");
    	
    	Select dropdown = new Select(driver.findElement(settlementModel));
        dropdown.selectByVisibleText("Net");
        
        driver.findElement(refundAmount).clear();
        driver.findElement(refundAmount).sendKeys("0");
    	
    }
    
    public void savePage() {
    	
    	driver.findElement(saveBtn1).click();
		
    	Alert alert = wait.waitForAlert();
	    alert.accept();
    	
    }
    
}