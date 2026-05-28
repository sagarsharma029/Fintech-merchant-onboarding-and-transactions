package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class FRMPage{
	
	private WebDriver driver;
    private WaitUtil wait;

    public FRMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }
    
    private By merchantBillingMenu = By.xpath("//span[@class='menu-title' and text()='Merchant Billing']");
    private By FRMOption = By.id("frmAction");
    
    private By merchantSearchDropdown = By.id("select2-merchantPayId-container");
    private By merchantSearchInput = By.xpath("//input[contains(@class,'select2-search__field')]");
    private By merchantOption = By.xpath("//ul[contains(@class,'select2-results__options')]/li[1]");
    
    //private By minTicketSize = By.id("minTicketSize");
    //private By maxTicketSize = By.id("maxTicketSize");
    
    private By MOPDropdown = By.id("select2-paymentMethod-container");
    
    //private By dailyMOPLimit = By.id("mopDaily");
    //private By weeklyMOPLimit = By.id("id="mopWeekly"");
    //private By monthlyMOPLimit = By.id("mopMonthly");
    //private By dailyVolume = By.id("daily");
    //private By weeklyVolume = By.id("weekly");
    //private By monthlyVolume = By.id("monthly");
    
	private By merchantProfileRiskDropdown = By.xpath("//span[@id='select2-merchantProfile-container']");
	
	private By saveBtn = By.id("saveBtn");
	
	public void navigateToFRM() {
		
        wait.waitForClickable(merchantBillingMenu).click();
        wait.waitForClickable(FRMOption).click();
		  
	}
	   
	public void selectMerchant(String merchantName) throws InterruptedException {

		wait.waitForClickable(merchantSearchDropdown).click();
		wait.waitForVisibility(merchantSearchInput).sendKeys(merchantName);
		driver.findElement(merchantOption).click();
		Thread.sleep(500);
		}
	
	public void selectMOP(String mop) throws InterruptedException {
		
		By MOPOption = By.xpath("//li[contains(@class,'select2-results__option') and text()='" + mop + "']");
		wait.waitForClickable(MOPDropdown).click();
		wait.waitForClickable(MOPOption).click();
		Thread.sleep(500);
		
	}
	
	public void setMerchantProfile(String risk) {
		
		By merchantProfileRisk = By.xpath("//li[contains(text(),'" + risk + "')]");
		wait.waitForClickable(merchantProfileRiskDropdown).click();
		driver.findElement(merchantProfileRisk).click();
		
		wait.waitForClickable(saveBtn).click();
		
		Alert alert = wait.waitForAlert();
	    alert.accept();
		
	}
	
}