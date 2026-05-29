package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.MerchantAccountPage;

public class MerchantAccountTest extends BaseTest {

    @Test
    public void verifyMerchantAccountUpdate() throws InterruptedException {
    	
    	driver.get("https://preprod.pay10.com/crm/jsp/index");
    	
    	LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");

        MerchantAccountPage merchantAccountPage = new MerchantAccountPage(driver);

        merchantAccountPage.navigateToSettlementSettings();

        merchantAccountPage.searchAndEditMerchant("sagar_test_xyz");

        merchantAccountPage.fillBankDetails();

        merchantAccountPage.savePage();
    }
}