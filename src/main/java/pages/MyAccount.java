package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MyAccount extends TestBase {
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public static String actualMssg;
	public String expectedMssg = "Welcome, Bhuwan Kumar Chotia!";
	
	@FindBy(xpath = ".//p[@class='welcome-msg']")
	WebElement welcomeMssgField;
	
	@FindBy(xpath = ".//span[@class='label' and text()='Account']")
	WebElement accountField;
	
	@FindBy(xpath = ".//li//a[text()='My Wishlist']")
	WebElement myWishlistLink;
	
	@FindBy(xpath = ".//a[text()='TV']")
	WebElement mnuTv;
	
	public MyAccount verifyWelcomeMssg() {
		actualMssg = welcomeMssgField.getText();
		return new MyAccount();
	}
	
	public MyAccount clickMyAccountPageAccountField() {
		accountField.click();
		return new MyAccount();
	}
	
	public MyWishListPage clickMyWishListLinkInMyAccountPage() {
		myWishlistLink.click();
		return new MyWishListPage();
	}
	
	public TVListPage clickOnmnuTv() {
		mnuTv.click();
		return new TVListPage();
	}

}
