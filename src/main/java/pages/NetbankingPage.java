package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetbankingPage {

	public NetbankingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "netBankingLi")
	private WebElement NetBanking;
	
	@FindBy(xpath="//*[@alt='Hdfc Bank']")
	private WebElement selectHDFCbank;
	
	@FindBy(id= "netBankingBtn")
	private WebElement Netbankingpay;

	public WebElement getNetBanking() {
		return NetBanking;
	}

	public WebElement getSelectHDFCbank() {
		return selectHDFCbank;
	}

	public WebElement getNetbankingpay() {
		return Netbankingpay;
	}

	
	
}
