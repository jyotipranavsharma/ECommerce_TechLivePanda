package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class TVListPage extends TestBase {
	public TVListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public  MyWishListPage clickAddtoWishList(String productName) {
		WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']"));
		WebElement wishListButton = product.findElement(By.xpath(".//following::a[text()='Add to Wishlist']"));

		wishListButton.click();
		return new MyWishListPage();

	}
}