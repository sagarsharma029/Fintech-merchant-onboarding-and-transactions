package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtil;

public class MerchantAccountPage {

    private WebDriver driver;
    private WaitUtil wait;

    public MerchantAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    private By merchantSetupMenu = By.xpath("//span[contains(text(),'Merchant Setup')]");
    private By merchantAccountOption = By.id("merchantList");
    
    private By searchBox = By.xpath("//input[@type='search' and contains(@class,'form-control')]");
    
    private By payIdText = By.xpath("//table//tbody//tr[1]/td[1]");

    private By editBtn = By.xpath("//button[@id='merchantEdit']");
    
    private By merchantStatus = By.id("status");
    private By merchantProcessingMode = By.id("processingmode");
    //private By actionBtn = By.xpath("//div[@id='HeadActionDiv' and contains(@class,'acordion-open')]//h4");
    
    private By contactDetailsBtn = By.xpath("//div[@id='HeadContactDetailsDiv']//h4");
    private By contactState = By.id("state");
    
    private By bankDetailsBtn = By.xpath("//div[@id='HeadBankDetailsDiv']//h4");
    private By bankName = By.id("bankName");
    private By accHolderName = By.id("accHolderName");
    private By branchName = By.id("branchName");
    private By accNumber = By.id("accountNo");
    private By ifscCode = By.id("ifscCode");
    private By panCard = By.id("panCard");
    private By validateBtn = By.id("btnValidate");
    
    private By saveBtn = By.xpath("//input[@type = 'submit' and @id = 'btnSave']");
    private By successMsg = By.xpath("//li/span[text()='User details updated successfully']");
    
    public void navigateToSettlementSettings() {
    	
    	driver.findElement(merchantSetupMenu).click();
  	    wait.waitForClickable(merchantAccountOption).click();
  	  
    }
    
    public String searchAndEditMerchant(String merchantName) throws InterruptedException {
    	
    	wait.waitForClickable(searchBox).sendKeys(merchantName);
    	
    	wait.waitForTextToNotBePresent(payIdText, "No data available in table");
    	String payId = driver.findElement(payIdText).getText();

    	System.out.println("PAY ID : " + payId);
    	
    	wait.waitForVisibility(editBtn).click();
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	
    	Select statusDropdown = new Select(driver.findElement(merchantStatus));
    	statusDropdown.selectByVisibleText("ACTIVE");
    	
    	Select processingModeDropdown = new Select(driver.findElement(merchantProcessingMode));
    	processingModeDropdown.selectByVisibleText("SALE");
    	
    	//wait.waitForClickable(actionBtn).click();
    	
    	Thread.sleep(500);
        
    	wait.waitForVisibility(contactDetailsBtn).click();
        
        Select stateDropdown = new Select(wait.waitForVisibility((contactState)));
        stateDropdown.selectByVisibleText("DELHI");
        
        wait.waitForClickable(contactDetailsBtn).click();
        
        return payId;
    	
    }
    
	public void fillBankDetails() throws InterruptedException {
    	
    	wait.waitForVisibility(bankDetailsBtn).click();
    	
    	wait.waitForClickable(bankName).sendKeys("HDFC BANK");
    	driver.findElement(accHolderName).sendKeys("JAY NANDKISHORE DAR");
    	driver.findElement(branchName).sendKeys("Noida");
    	driver.findElement(accNumber).sendKeys("50100693426390");
    	driver.findElement(ifscCode).sendKeys("HDFC0000546");
    	driver.findElement(panCard).sendKeys("DCSPV1324R");
    	
    	driver.findElement(validateBtn).click();
    	
    	Thread.sleep(2000);
    	
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

    }
	
	public void savePage() throws InterruptedException {


	    WebElement saveBtnElement = wait.waitForVisibility(saveBtn);
	    
	    Thread.sleep(3000);

	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtnElement);

	    wait.waitForVisibility(successMsg);
	}
    
}