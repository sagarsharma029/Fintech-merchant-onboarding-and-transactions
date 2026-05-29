package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.RuleEnginePage;

public class RuleEngineTest extends BaseTest {

    @Test
    public void verifyRuleEngineCreation() throws InterruptedException {
    	
    	driver.get("https://preprod.pay10.com/crm/jsp/index");
    	
    	LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");

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

            ruleEngine.createRules("sagar_test_xyz", paymentType);
        }
    }
}