package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpPage {
	public OtpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[value=\"SUCCESS\"]")
	private WebElement success;

	public WebElement getSuccess() {
		return success;
	}

}
