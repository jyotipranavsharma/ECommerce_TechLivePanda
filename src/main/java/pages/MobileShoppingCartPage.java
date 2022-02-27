package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MobileShoppingCartPage extends TestBase {
	
	public static String actualMssg;
	public String expectedMssg = "The requested quantity for Sony Xperia is not available.";
	public String expectedMssg1 = "SHOPPING CART IS EMPTY";
	public static String actualMssg1;
	
	public MobileShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//input[@type='text' and @class='input-text qty']")
	WebElement qty;

	@FindBy(xpath = ".//span[text()='Update']")
	WebElement update;

	@FindBy(xpath = ".//p[@class='item-msg error']")
	WebElement errorMessage;
	
	@FindBy(xpath = ".//span[text()='Empty Cart']")
	WebElement emptyCart;
	
	@FindBy(xpath = ".//div[@class='page-title']")
	WebElement emptyCartMssg;

	public MobileShoppingCartPage updateQTY(String Quantity) {
		qty.sendKeys(Quantity);
		update.click();
		return new MobileShoppingCartPage();
	}

	public MobileShoppingCartPage checkErrorMessage() {
		actualMssg = errorMessage.getText();
	    System.out.println(actualMssg);

		return new MobileShoppingCartPage();
	}
	
	public MobileShoppingCartPage clickEmptyCart() {
		
		emptyCart.click();
		actualMssg1 = emptyCartMssg.getText();
		System.out.println(actualMssg1);
		return new MobileShoppingCartPage();
		
	}
	
	

}
