package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	public static String actualMssg;
	public String expectedMssg = "Your Wishlist has been shared.";

	@FindBy(xpath = ".//span[text()='Share Wishlist']")
	WebElement shareWishlistField;

	@FindBy(xpath = ".//li//child::span")
	WebElement successSharingWishlistMssgField;

	public WishlistSharinPage clickShareWishlist() {
		shareWishlistField.click();
		return new WishlistSharinPage();
	}

	public MyWishListPage verifySuccessMssg() {
		actualMssg = successSharingWishlistMssgField.getText();
		System.out.println(actualMssg);
		return new MyWishListPage();
	}

}
