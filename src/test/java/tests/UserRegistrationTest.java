package tests;

import base.BaseTest;

import models.MerchantData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utils.DataGenerator;


public class UserRegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() {
    	
    	driver.get("https://preprod.pay10.com/crm/jsp/index");
    	
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@pay10.com", "Pay10@052026", "738256");

        MerchantData data = new MerchantData();

        data.setMerchantType("Create a Merchant");
        data.setIndustryType("Food and Beverage");
        data.setIndustrySubCategory("Bar and Pubs");
        data.setUserGroup("Merchant");
        //data.setRole("Merchant");
        //data.setSegment("Default");
        
        String businessName = DataGenerator.generateBusinessName();

        data.setBusinessName(businessName);
        data.setEmail(DataGenerator.generateEmail(businessName));
        data.setPhone(DataGenerator.generatePhone());
        data.setPassword("Test@123");

        UserRegistrationPage regPage = new UserRegistrationPage(driver);
        regPage.navigateToRegistration();

        regPage.fillRegistrationForm(data);

        regPage.submitForm();

        boolean isSuccess = regPage.isRegistrationSuccessful();

        Assert.assertTrue(isSuccess, "Registration failed");

        System.out.println("Registration successful for: " + data.getBusinessName());
    }
}