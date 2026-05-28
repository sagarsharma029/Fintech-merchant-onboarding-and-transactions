package pages;

import models.MerchantData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class UserRegistrationPage {

    private WebDriver driver;
    private WaitUtil wait;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }


    private By merchantSetupMenu = By.xpath("//span[contains(text(),'Merchant Setup')]");
    private By userRegistrationOption = By.id("merchantCrmSignup");

    private By merchantTypeDropdown = By.xpath("//span[@class='select2-selection__rendered' and text()='Create a Merchant']");
    private By merchantTypeOption = By.xpath("//li[contains(@class,'select2-results__option') and text()='Create a Merchant']");

    private By industryTypeDropdown = By.xpath("//span[@id='select2-industryCategory-container']");
    private By industryTypeOption = By.xpath("//li[contains(@class,'select2-results__option') and text()='Food and Beverage']");

    private By industrySubCategory = By.xpath("//input[@name='subcategory' and @value='Bar and Pubs']");
    private By industrySubCategoryDoneBtn = By.xpath("//input[@type='submit' and @value='Done']");

    private By userGroupDropdown = By.xpath("//span[contains(@class,'select2-selection__rendered') and text()='Select User Group']");
    private By userGroupOption = By.xpath("//li[contains(@class,'select2-results__option') and text()='Merchant']");

    //private By roleDropdown = By.id("roleId");
    //private By segmentDropdown = By.id("segmentName");


    private By businessName = By.id("businessName");
    private By aliasName = By.id("aliasName");
    private By email = By.id("emailId");
    private By phone = By.id("mobile");

    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");

    private By signupButton = By.id("addMerchantBtn");

    private By successMessage = By.xpath("//div[@id='saveMessage']//span");


    public void navigateToRegistration() {
    	
        wait.waitForClickable(merchantSetupMenu).click();
        wait.waitForClickable(userRegistrationOption).click();
    }

    public void fillRegistrationForm(MerchantData data) {

        wait.waitForClickable(merchantTypeDropdown).click();
        wait.waitForClickable(merchantTypeOption).click(); 

        wait.waitForClickable(industryTypeDropdown).click();
        wait.waitForClickable(industryTypeOption).click();

        wait.waitForClickable(industrySubCategory).click();
        wait.waitForClickable(industrySubCategoryDoneBtn).click();

        wait.waitForClickable(userGroupDropdown).click();
        wait.waitForClickable(userGroupOption).click();

        //Select roleSelect = new Select(driver.findElement(roleDropdown));
        //roleSelect.selectByVisibleText(data.getRole());

        //Select segmentSelect = new Select(driver.findElement(segmentDropdown));
        //segmentSelect.selectByVisibleText(data.getSegment());

        wait.waitForVisibility(businessName).sendKeys(data.getBusinessName());

        driver.findElement(aliasName).sendKeys(data.getBusinessName()); // same as business name
        driver.findElement(email).sendKeys(data.getEmail());
        driver.findElement(phone).sendKeys(data.getPhone());

        driver.findElement(password).sendKeys(data.getPassword());
        driver.findElement(confirmPassword).sendKeys(data.getPassword());
    }

    public void submitForm() {
        wait.waitForClickable(signupButton).click();
    }

    public boolean isRegistrationSuccessful() {
        wait.waitForVisibility(successMessage);
        return driver.findElement(successMessage).isDisplayed();
    }
}