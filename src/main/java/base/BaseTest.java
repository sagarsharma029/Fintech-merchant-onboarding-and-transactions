package base;
import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {

    	driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
    /*public void tearDown(ITestResult result) {

        // Close browser only if test PASSED
        if (result.getStatus() == ITestResult.SUCCESS) {

            if (driver != null) {
                driver.quit();
            }

        } else {

            System.out.println("Test Failed - Browser kept open for debugging");

        }
    }*/
}