package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletPage {
	public WalletPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "iMudraLi")
	private WebElement Wallet;

	@FindBy(xpath = "//img[@alt='Phone Pe Wallet']")
	private WebElement phonepay;

	@FindBy(id = "iMudraBtn")
	private WebElement paywallet;

	

	public WebElement getWalletbutton() {
		return Wallet;
	}

	public WebElement getphonepaybutton() {
		return phonepay;
	}

	public WebElement getConfirmpaywallet() {
		return paywallet;
	}

}
