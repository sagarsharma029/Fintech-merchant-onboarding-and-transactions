package tests;

import base.BaseTest;
import models.MerchantData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataGenerator;
import java.util.Arrays;
import java.util.List;
import utils.JsonUtil;
import org.testng.annotations.Listeners;

@Listeners(utils.TestListener.class)
public class MerchantRegistrationTest extends BaseTest {

    @Test
    public void completeMerchantOnboardingFlow() throws InterruptedException {

        MerchantData merchantData = new MerchantData();

        String businessName = DataGenerator.generateBusinessName();

        merchantData.setBusinessName(businessName);
        merchantData.setEmail(DataGenerator.generateEmail(businessName));
        merchantData.setPhone(DataGenerator.generatePhone());
        merchantData.setPassword("Test@123");

        driver.get("https://preprod.pay10.com/crm/jsp/index");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");

        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driver);

        userRegistrationPage.navigateToRegistration();
        userRegistrationPage.fillRegistrationForm(merchantData);
        userRegistrationPage.submitForm();

        Assert.assertTrue(userRegistrationPage.isRegistrationSuccessful(), 
        		"Merchant registration failed");

        MerchantMappingPage merchantMappingPage = new MerchantMappingPage(driver);

        merchantMappingPage.navigateToMerchantMapping();
        merchantMappingPage.selectUser();
        merchantMappingPage.selectMerchant(merchantData.getBusinessName());
        merchantMappingPage.selectAcquirer();
        merchantMappingPage.selectCurrencyAndTransactionRegion();
        merchantMappingPage.selectCreditcardMOP();
        merchantMappingPage.selectDebitCard();
        merchantMappingPage.selectUPIMOP();
        merchantMappingPage.selectNetBankingMOP();
        merchantMappingPage.selectWalletMOP();
        merchantMappingPage.savePage();

        TDRSettingPage tdrSettingPage = new TDRSettingPage(driver);

        tdrSettingPage.navigateToTDRSettings();
        tdrSettingPage.selectMerchant(merchantData.getBusinessName());
        tdrSettingPage.selectAcquirer();
        tdrSettingPage.selectRegion();
        tdrSettingPage.selectType();
        tdrSettingPage.configureAllRows();

        FRMPage frmPage = new FRMPage(driver);

        List<String> mopList = Arrays.asList(
        		"Credit Card", "Debit Card", "Net Banking", 
        		"Wallet", "QR CODE", "UPI", "MANDATE", "UPIAUTOPAY");
        
        frmPage.navigateToFRM();

        for (String mop : mopList) {
            frmPage.selectMerchant(merchantData.getBusinessName());
            frmPage.selectMOP(mop);
            frmPage.setMerchantProfile("Low Risk");
        }


        SettlementSettingPage settlementSettingPage = new SettlementSettingPage(driver);

        settlementSettingPage.navigateToSettlementSettings();
        settlementSettingPage.selectMerchant(merchantData.getBusinessName());
        settlementSettingPage.fillSettlementSettingPage();
        settlementSettingPage.savePage();

        MerchantAccountPage merchantAccountPage = new MerchantAccountPage(driver);

        merchantAccountPage.navigateToSettlementSettings();
        String payId = merchantAccountPage.searchAndEditMerchant(merchantData.getBusinessName());
        merchantData.setPayId(payId);
        JsonUtil.writeMerchantData(merchantData);
        merchantAccountPage.fillBankDetails();
        merchantAccountPage.savePage();
        
        RuleEnginePage ruleEngine = new RuleEnginePage(driver);

        ruleEngine.navigateToSettlementSettings();
        
        List<String> paymentTypes = Arrays.asList(
                "CREDIT_CARD",
                "DEBIT_CARD",
                "NET_BANKING",
                "UPI",
                "WALLET"
        );

        for (String paymentType : paymentTypes) {
            ruleEngine.createRules(merchantData.getBusinessName(), paymentType);
        }
    }
}