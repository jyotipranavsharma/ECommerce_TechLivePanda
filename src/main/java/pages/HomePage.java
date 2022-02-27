package pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {

	// Initialize Page Object

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Menu
	@FindBy(xpath = ".//a[text()='Mobile']")
	WebElement mnuMobile;

	@FindBy(xpath = ".//div[@class='page-title']//child::h2")
	WebElement titleDemoSite;

	@FindBy(xpath = ".//span[@class='label' and text()='Account']")
	WebElement accountField;

	@FindBy(xpath = ".//div[@id='header-account']//child::ul//li[@class='first']//a")
	WebElement myAccountLink;
	
	@FindBy(xpath = ".//li//a[text()='My Wishlist']")
	WebElement myWishlistLink;

	@FindBy(xpath = ".//a[text()='Log In']")
	WebElement loginField;

	public MobileListPage clickOnmnuMobile() {
		mnuMobile.click();
		return new MobileListPage();
	}

	public HomePage verifyTitleDemoSite() {
		Assert.assertEquals("THIS IS DEMO SITE FOR   ", titleDemoSite.getText());

		return new HomePage();
	}

	public HomePage clickAccountField() {
		accountField.click();
		return new HomePage();
	}

	public CustomerLogin clickMyAccountLink() {
		myAccountLink.click();
		return new CustomerLogin();

	}
	
	public MyWishListPage clickMyWishlistLink() {
		myWishlistLink.click();
		return new MyWishListPage();
	}

	public CustomerLogin clickLoginIcon() {
		loginField.click();
		return new CustomerLogin();
	}

}
