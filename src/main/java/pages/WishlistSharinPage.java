package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class WishlistSharinPage extends TestBase {
	public WishlistSharinPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_address")
	WebElement emailAddressField;

	@FindBy(id = "message")
	WebElement messageField;

	@FindBy(xpath = ".//span[text()='Share Wishlist']")
	WebElement clickShareWishlistField;

	public MyWishListPage passEmail(String email, String message) {
		emailAddressField.sendKeys(email);
		messageField.sendKeys(message);
		clickShareWishlistField.click();
		return new MyWishListPage();
	}

}
