package pages;

import models.TDRRowData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TDRSettingPage {

    private WebDriver driver;
    private WaitUtil wait;

    public TDRSettingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    private By tdrSettingOption = By.id("tdrSetting");
    private By merchantSearchDropdown = By.xpath("//span[@id='select2-merchants-container']");
    private By merchantSearchInput = By.xpath("//input[contains(@class,'select2-search__field')]");
    private By merchantOption = By.xpath("//ul[contains(@class,'select2-results__options')]/li[1]");
    private By acquirerDropdown = By.xpath("//span[@role='combobox' and @aria-labelledby='select2-acquirer-container']");
    private By acquirerOption = By.xpath("//li[text()='DEMO']");
    private By regionDropdown = By.xpath("//span[@id='select2-paymentRegion-container']");
    private By regionOption = By.xpath("//ul[contains(@class,'select2-results')]//li[text()='DOMESTIC']");
    private By typeDropdown = By.xpath("//span[@id='select2-cardHolderType-container']");
    private By typeOption = By.xpath("//ul[contains(@class,'select2-results')]//li[text()='CONSUMER']");
    private By tableRows = By.xpath("//tbody/tr");

    // td[4] = Payment Type
    private static final int PAYMENT_TYPE_COLUMN = 4;

    // td[5] = MOP Type
    private static final int MOP_TYPE_COLUMN = 5;

    // td[6] = Min Transaction Amount
    private static final int MIN_TXN_COLUMN = 6;

    // td[7] = Max Transaction Amount
    private static final int MAX_TXN_COLUMN = 7;

    // td[8] = From Date
    private static final int FROM_DATE_COLUMN = 8;

    // td[9] = To Date
    private static final int TO_DATE_COLUMN = 9;

    // td[11] = Bank TDR
    private static final int BANK_TDR_COLUMN = 11;

    // td[12] = Bank Min Amount
    private static final int BANK_MIN_COLUMN = 12;

    // td[13] = Bank Max Amount
    private static final int BANK_MAX_COLUMN = 13;

    // td[15] = Merchant TDR
    private static final int MERCHANT_TDR_COLUMN = 15;

    // td[16] = Merchant Min Amount
    private static final int MERCHANT_MIN_COLUMN = 16;

    // td[17] = Merchant Max Amount
    private static final int MERCHANT_MAX_COLUMN = 17;


    public void navigateToTDRSettings() {
        wait.waitForClickable(tdrSettingOption).click();
    }

    public void selectMerchant(String merchantName) {
        wait.waitForClickable(merchantSearchDropdown).click();
        wait.waitForVisibility(merchantSearchInput).sendKeys(merchantName);
        driver.findElement(merchantOption).click();
    }

    public void selectAcquirer() throws InterruptedException {

        Thread.sleep(1000);

        wait.waitForClickable(acquirerDropdown).click();
        wait.waitForClickable(acquirerOption).click();
    }

    public void selectRegion() {
        wait.waitForClickable(regionDropdown).click();
        wait.waitForClickable(regionOption).click();
    }

    public void selectType() {
        wait.waitForClickable(typeDropdown).click();
        wait.waitForClickable(typeOption).click();
    }

    public List<TDRRowData> getAllTDRRows() {

        List<TDRRowData> rowDataList = new ArrayList<>();

        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {

            String paymentType = row.findElement(
                            By.xpath("./td[" + PAYMENT_TYPE_COLUMN + "]//input")).getAttribute("value");

            String mopType = row.findElement(
                            By.xpath("./td[" + MOP_TYPE_COLUMN + "]//input")).getAttribute("value");

            TDRRowData rowData = new TDRRowData(paymentType, mopType);

            rowDataList.add(rowData);
        }

        return rowDataList;
    }

    private WebElement findRow(String paymentType, String mopType) {

        String xpath = "//tbody/tr[" +
                        "td[" + PAYMENT_TYPE_COLUMN + "]//input[@value='" + paymentType + "'] " +
                        "and " +
                        "td[" + MOP_TYPE_COLUMN + "]//input[@value='" + mopType + "']" + "]";

        return driver.findElement(By.xpath(xpath));
    }

    public void configureAllRows() {

        List<TDRRowData> rows = getAllTDRRows();

        for (TDRRowData rowData : rows) {

            System.out.println(rowData);
            configureSingleRow(rowData.getPaymentType(), rowData.getMopType());
        }
    }

    public void configureSingleRow(String paymentType,String mopType) {

        WebElement row = findRow(paymentType, mopType);
        clickEdit(row);
        fillTDRValues(row);
        saveRow(row);
    }

    private void clickEdit(WebElement row) {

        WebElement editButton = row.findElement(By.xpath(".//button[normalize-space()='Edit']"));

        editButton.click();

        waitForRowToBecomeEditable(row);
    }

    private void waitForRowToBecomeEditable(WebElement row) {

        WebElement minTxnField = row.findElement(By.xpath("./td[" + MIN_TXN_COLUMN + "]//input"));

        wait.waitForElementToBeEnabled(minTxnField);
    }

    private void fillTDRValues(WebElement row) {

        WebElement minTxn = row.findElement(By.xpath("./td[" + MIN_TXN_COLUMN + "]//input") );

        minTxn.clear();
        minTxn.sendKeys("1");

        WebElement maxTxn = row.findElement(By.xpath("./td[" + MAX_TXN_COLUMN + "]//input"));

        maxTxn.clear();
        maxTxn.sendKeys("5000");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futureDate = now.plusYears(2);

        String fromDatePart = now.format(dateFormatter);
        String fromTimePart = now.format(timeFormatter);

        String toDatePart = futureDate.format(dateFormatter);
        String toTimePart = futureDate.format(timeFormatter);

        WebElement fromDate = row.findElement(By.xpath("./td[" + FROM_DATE_COLUMN + "]//input"));

        fromDate.clear();
        fromDate.sendKeys(fromDatePart);
        fromDate.sendKeys(Keys.ARROW_RIGHT);
        fromDate.sendKeys(fromTimePart);

        WebElement toDate = row.findElement(By.xpath("./td[" + TO_DATE_COLUMN + "]//input"));

        toDate.clear();
        toDate.sendKeys(toDatePart);
        toDate.sendKeys(Keys.ARROW_RIGHT);
        toDate.sendKeys(toTimePart);

        WebElement bankPrefDropdown = row.findElement(By.xpath(".//select[@name='bankPreference']"));

        Select bankPref =new Select(bankPrefDropdown);

        bankPref.selectByVisibleText("PERCENTAGE");

        WebElement bankTdr = row.findElement(By.xpath("./td[" + BANK_TDR_COLUMN + "]//input"));

        bankTdr.clear();
        bankTdr.sendKeys("2");

        WebElement bankMinAmount = row.findElement(By.xpath("./td[" + BANK_MIN_COLUMN + "]//input"));

        bankMinAmount.clear();
        bankMinAmount.sendKeys("1");

        WebElement bankMaxAmount = row.findElement( By.xpath("./td[" + BANK_MAX_COLUMN + "]//input"));

        bankMaxAmount.clear();
        bankMaxAmount.sendKeys("10000");

        WebElement merchantPrefDropdown = row.findElement( By.xpath(".//select[@name='merchantPreference']"));

        Select merchantPref =new Select(merchantPrefDropdown);

        merchantPref.selectByVisibleText("PERCENTAGE");

        WebElement merchantTdr = row.findElement(By.xpath("./td[" + MERCHANT_TDR_COLUMN + "]//input"));

        merchantTdr.clear();
        merchantTdr.sendKeys("2");

        WebElement merchantMinAmount = row.findElement(By.xpath("./td[" + MERCHANT_MIN_COLUMN + "]//input"));

        merchantMinAmount.clear();
        merchantMinAmount.sendKeys("1");

        WebElement merchantMaxAmount = row.findElement(By.xpath("./td[" + MERCHANT_MAX_COLUMN + "]//input"));

        merchantMaxAmount.clear();
        merchantMaxAmount.sendKeys("10000");

        WebElement surchargeCheckbox = row.findElement(By.xpath(".//input[@name='enableSurcharge']"));

        if (!surchargeCheckbox.isSelected()) {
            surchargeCheckbox.click();
        }
    }

    private void saveRow(WebElement row) {

        WebElement saveButton = row.findElement(By.xpath(".//button[normalize-space()='Save']"));

        saveButton.click();

        Alert alert = wait.waitForAlert();
        System.out.println(alert.getText());
        alert.accept();

    }
}