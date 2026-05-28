package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;


public class MerchantMappingTest extends BaseTest{

    @Test
    public void verifyMerchantMappingFlow() {
    	
    	driver.get("https://preprod.pay10.com/crm/jsp/index");
    	
    	LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");
        
        MerchantMappingPage merchantMappingPage = new MerchantMappingPage(driver);

        merchantMappingPage.navigateToMerchantMapping();

        merchantMappingPage.selectUser();

        merchantMappingPage.selectMerchant("sagar_test004");

        merchantMappingPage.selectAcquirer();

        merchantMappingPage.selectCurrencyAndTransactionRegion();

        merchantMappingPage.selectCreditcardMOP();

        merchantMappingPage.selectDebitCard();

        merchantMappingPage.selectUPIMOP();

        merchantMappingPage.selectNetBankingMOP();

        merchantMappingPage.selectWalletMOP();

        merchantMappingPage.savePage();
    }

}