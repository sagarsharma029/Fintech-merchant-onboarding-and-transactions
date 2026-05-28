package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;
import org.openqa.selenium.Alert;

public class MerchantMappingPage {

    private WebDriver driver;
    private WaitUtil wait;

    public MerchantMappingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    private By merchantBillingMenu = By.xpath("//span[@class='menu-title' and text()='Merchant Billing']");
    private By merchantMappingOption = By.xpath("//a[@id='mopSetUpAction']");

    private By selectUserDropdown = By.id("user");
    private By selectUserOption = By.xpath("//option[1]"); 

    private By merchantSearchDropdown = By.xpath("//span[@id='select2-merchants-container']");
    private By merchantSearchInput = By.xpath("//input[contains(@class,'select2-search__field')]");
    private String merchantOption = "//ul[contains(@class,'select2-results__options')]/li[1]";

    private By acquirerDropdown = By.id("acquirer");
    private By acquirerOption =  By.xpath("//select[@id='acquirer']/option[@value='DEMO']");

    private By inrCheckbox = By.id("id+356");
    
    private By merchantIdTextBox = By.id("idmerchantid+356");
    private By txnKeyTextBox = By.id("idtxnkey+356");
    private By passwordTextBox = By.id("idpassword+356");
    private By adf1TextBox = By.id("idadf1+356");
    private By adf2TextBox = By.id("idadf2+356");
    private By adf3TextBox = By.id("idadf3+356");
    

    private By domesticCheckbox = By.id("domestic");
    
    private By ccCheckbox = By.id("Credit Cardbox");
    
    private By ccVisa = By.id("id+Credit Card-VI");
    //private By ccVisaAuth = By.id("Credit Card-VI-AUTH");
    private By ccVisaSale = By.id("Credit Card-VI-SALE");
    //private By ccVisaRefund = By.id("Credit Card-VI-REFU");
    
    
    private By ccMasterCard = By.id("id+Credit Card-MC");
    //private By ccMasterCardAuth = By.id("Credit Card-MC-AUTH");
    private By ccMasterCardSale = By.id("Credit Card-MC-SALE");
    //private By ccMasterCardRefund = By.id("Credit Card-MC-REFU");
    
    
    //private By ccDiners = By.id("id+Credit Card-DN");
    //private By ccDinersAuth = By.id("Credit Card-DN-AUTH");
    //private By ccDinersSale = By.id("Credit Card-DN-SALE");
    //private By ccDinersRefund = By.id("Credit Card-DN-REFU");

    
    //private By ccDiscover = By.id("id+Credit Card-DI");
    //private By ccDiscoverAuth = By.id("Credit Card-DI-AUTH");
    //private By ccDiscoverSale = By.id("Credit Card-DI-SALE");
    //private By ccDiscoverRefund = By.id("Credit Card-DI-REFU");

    
    //private By ccRupay = By.id("id+Credit Card-RU");
    //private By ccRupayAuth = By.id("Credit Card-RU-AUTH");
    //private By ccRupaySale = By.id("Credit Card-RU-SALE");
    //private By ccRupayRefund = By.id("Credit Card-RU-REFU");
    
    private By dcCheckbox = By.id("Debit Cardbox");
    
    private By dcVisa = By.id("id+Debit Card-VI");
    //private By dcVisaAuth = By.id("Debit Card-VI-AUTH");
    private By dcVisaSale = By.id("Debit Card-VI-SALE");
    //private By dcVisaRefund = By.id("Debit Card-VI-REFU");
    
    private By dcMasterCard = By.id("id+Debit Card-MC");
    //private By dcMasterCardAuth = By.id("Debit Card-MC-AUTH");
    private By dcMasterCardSale = By.id("Debit Card-MC-SALE");
    //private By dcMasterCardRefund = By.id("Debit Card-MC-REFU");
    
    //private By dcMaestro = By.id("id+Debit Card-MS");
    //private By dcMaestroAuth = By.id("Debit Card-MS-AUTH");
    //private By dcMaestroSale = By.id("Debit Card-MS-SALE");
    //private By dcMaestroRefund = By.id("Debit Card-MS-REFU");
    //private By dcRupay = By.id("id+Debit Card-RU");
    //private By dcRupayAuth = By.id("Debit Card-RU-AUTH");
    //private By dcRupaySale = By.id("Debit Card-RU-SALE");
    //private By dcRupayRefund = By.id("Debit Card-RU-REFU");
    //private By dcAmex = By.id("id+Debit Card-AX");
    //private By dcAmexAuth = By.id("Debit Card-AX-AUTH");
    //private By dcAmexSale = By.id("Debit Card-AX-SALE");
    //private By dcAmexRefund = By.id("Debit Card-AX-REFU");
    
    
    private By upiCheckbox = By.id("UPIbox");
    private By upiCheckbox2 = By.id("id+UPI-UP");
    private By upiSaleCheckbox = By.id("UPI-UP-SALE");
    //private By upiAuthCheckbox = By.id("UPI-UP-AUTH");
    //private By upiRefundCheckbox = By.id("UPI-UP-REFU");
    
    
    private By netBankingCheckbox = By.id("Net Bankingbox");
    private By netBankingHDFC = By.id("Net Banking-1004");
    
    
    private By walletCheckbox = By.id("Walletbox");
    //private By mobikwikWallet = By.id("id+Wallet-MWL");
    //private By mobikwikAuth = By.id("Wallet-MWL-AUTH");    
    //private By mobikwikSale = By.id("Wallet-MWL-SALE");    
    //private By mobikwikRefund = By.id("Wallet-MWL-REFU");    
    //private By olaMoneyWallet = By.id("id+Wallet-OLAWL");
    //private By jioMoneyWallet = By.id("id+Wallet-JMWL");
    //private By airtelWallet = By.id("id+Wallet-AWL");
    private By paytmWallet = By.id("id+Wallet-PPL");
    //private By paytmAuth = By.id("Wallet-PPL-AUTH");
    private By paytmSale = By.id("Wallet-PPL-SALE");
    //private By paytmRefund = By.id("Wallet-PPL-REFU");
    //private By amazonPayWallet = By.id("id+Wallet-APWL");
    //private By amazonAuth = By.id("Wallet-APWL-AUTH");
    //private By amazonSale = By.id("Wallet-APWL-SALE");
    //private By amazonRefund = By.id("Wallet-APWL-REFU");
    private By phonePeWallet = By.id("id+Wallet-PPWL");
    private By phonePeSale = By.id("Wallet-PPWL-SALE");
    
    
    private By saveBtn = By.id("btnsubmit");

    public void navigateToMerchantMapping() {
        wait.waitForClickable(merchantBillingMenu).click();
        wait.waitForClickable(merchantMappingOption).click();
    }

    public void selectUser() {
        wait.waitForClickable(selectUserDropdown).click();
        driver.findElement(selectUserOption).click();
    }

    public void selectMerchant(String merchantName) {

        wait.waitForClickable(merchantSearchDropdown).click();

        wait.waitForVisibility(merchantSearchInput).sendKeys(merchantName);

        By dynamicOption = By.xpath(String.format(merchantOption, merchantName));
        wait.waitForClickable(dynamicOption).click();
    }

    public void selectAcquirer(){
    	
        	wait.waitForClickable(acquirerDropdown).click();
            wait.waitForVisibility(acquirerOption).click();
    }

    public void selectCurrencyAndTransactionRegion() {

        wait.waitForVisibility(inrCheckbox);
        driver.findElement(inrCheckbox).click();
        
        wait.waitForVisibility(merchantIdTextBox).sendKeys("12345");
        driver.findElement(txnKeyTextBox).sendKeys("12345");
        driver.findElement(passwordTextBox).sendKeys("12345");
        driver.findElement(adf1TextBox).sendKeys("12345");
        driver.findElement(adf2TextBox).sendKeys("12345");
        driver.findElement(adf3TextBox).sendKeys("12345");
        
        driver.findElement(domesticCheckbox).click();
    }
    
    public void selectCreditcardMOP() {
    	driver.findElement(ccCheckbox).click();
    	wait.waitForClickable(ccVisa).click();
    	wait.waitForClickable(ccVisaSale).click();
    	wait.waitForClickable(ccMasterCard).click();
    	wait.waitForClickable(ccMasterCardSale).click();
    }
    
    public void selectDebitCard() {
    	driver.findElement(dcCheckbox).click();
    	wait.waitForClickable(dcVisa).click();
    	wait.waitForClickable(dcVisaSale).click();
    	wait.waitForClickable(dcMasterCard).click();
    	wait.waitForClickable(dcMasterCardSale).click();

    }
    
    public void selectUPIMOP() {
    	driver.findElement(upiCheckbox).click();
    	wait.waitForClickable(upiCheckbox2).click();
    	wait.waitForClickable(upiSaleCheckbox).click();	

    }
    
    public void selectNetBankingMOP() {
    	
    	driver.findElement(netBankingCheckbox).click();
    	wait.waitForClickable(netBankingHDFC).click();
    	
    }
    
    public void selectWalletMOP() {
    	driver.findElement(walletCheckbox).click();
    	wait.waitForClickable(paytmWallet).click();
    	wait.waitForClickable(paytmSale).click();
    	wait.waitForClickable(phonePeWallet).click();
    	wait.waitForClickable(phonePeSale).click();
    	
    }
    
    public void savePage() {
    	
    	driver.findElement(saveBtn).click();
    	
    	Alert alert1 = wait.waitForAlert();
    	alert1.accept();
 
        
        driver.findElement(saveBtn).click();
    	
    	Alert alert2 = wait.waitForAlert();
        alert2.accept();
    }
}