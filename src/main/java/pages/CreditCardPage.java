package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPage {
	public CreditCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Credit Card']")
	private WebElement creditCart;

	@FindBy(name = "cardNumber")
	private WebElement cardNumField;

	@FindBy(name = "cvvNumber")
	private WebElement cvvField;

	@FindBy(id = "expirymonth")
	private WebElement expMonth;

	@FindBy(id = "expiryyear")
	private WebElement expYear;

	@FindBy(id = "cardName")
	private WebElement cardName;

	@FindBy(id = "confirm-purchase")
	private WebElement confirmpay;

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCardName() {
		return cardName;
	}

	public WebElement getConfirmpay() {
		return confirmpay;
	}

	public WebElement getCreditCart() {
		return creditCart;
	}

	public WebElement getCardNumField() {
		return cardNumField;
	}

	public WebElement getCvvField() {
		return cvvField;
	}

}
