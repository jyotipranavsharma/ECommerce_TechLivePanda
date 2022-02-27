package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MobileDetailPage extends TestBase {
	public MobileDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static String price;
	
	@FindBy(xpath = ".//span[@class='regular-price']")
	WebElement mobilePrice;
	
	@FindBy(xpath = ".//span[text()='Add to Cart']")
	WebElement addToCart;
	
	public MobileDetailPage getPrice() {
		price = mobilePrice.getText();
		System.out.println("The mobile price in detail page is: " +mobilePrice.getText());		
		return new MobileDetailPage();
	}
	
	public MobileShoppingCartPage clickAddToCart() {
		addToCart.click();
		return new MobileShoppingCartPage();
	}
	

}
