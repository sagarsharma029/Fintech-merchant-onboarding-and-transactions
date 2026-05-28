package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;


public class testTDRRowsOnly extends BaseTest{

    @Test
    public void verifyMerchantMappingFlow() throws InterruptedException {
    	
    	driver.get("https://preprod.pay10.com/crm/jsp/index");
    	
    	LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");
        
        TDRSettingPage tdrPage =
                new TDRSettingPage(driver);

        tdrPage.navigateToTDRSettings();

        tdrPage.selectMerchant("sagar_test_xyz");

        tdrPage.selectAcquirer();

        tdrPage.selectRegion();

        tdrPage.selectType();

        tdrPage.configureAllRows();
    }

}