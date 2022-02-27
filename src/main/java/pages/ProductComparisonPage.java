package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class ProductComparisonPage extends TestBase {
	public ProductComparisonPage() {
		PageFactory.initElements(driver, this);
	}

	public static String actualHeading;
	public String expectedHeading = "COMPARE PRODUCTS";

	@FindBy(xpath = ".//h1[text()='Compare Products']")
	WebElement headingCompareProduct;

	@FindBy(xpath = ".//tr[@class='product-shop-row top first odd']//td")
	List<WebElement> products;

	@FindBy(xpath = ".//button[@title='Close Window']")
	WebElement closeWindowButton;

	public ProductComparisonPage checkheading() {
		actualHeading = headingCompareProduct.getText();
		System.out.println(actualHeading);

		return new ProductComparisonPage();
	}

	public ProductComparisonPage selectedProductItem(List<String> productsToCompare) {
		List<String> productNames = new ArrayList();

		// check if the page contains product or not.
		if (products != null && products.size() > 0) {
			System.out.println("The size of product is: " + products.size());
		}

		// get the name of the products
		for (int i = 0; i < products.size(); i++) {
			String text = products.get(i).findElement(By.xpath(".//child::h2")).getText();
			System.out.println("The product is: " + text);
			productNames.add(text);

		}

		Assert.assertTrue(productNames.containsAll(productsToCompare));

		return new ProductComparisonPage();
	}

	public MobileListPage closeWindow() {
		closeWindowButton.click();
		windowHandles("Mobile");

		return new MobileListPage();

	}

}
