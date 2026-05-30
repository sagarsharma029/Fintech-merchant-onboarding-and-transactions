package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpiPage {
	public UpiPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "upiLi")
	private WebElement upi;

	@FindBy(id = "vpaCheck")
	private WebElement vpa;

	@FindBy(id = "m1")
	private WebElement verify;

	@FindBy(id = "upi-sbmt")
	private WebElement paysubmit;

	public WebElement getUpibutton() {
		return upi;
	}

	public WebElement getverifytext() {
		return vpa;
	}

	public WebElement getVerifybutton() {
		return verify;
	}

	public WebElement getConfirmpay() {
		return paysubmit;
	}

}
