package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import base.TestBase;

public class MobileListPage extends TestBase {
	public MobileListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//select[@title='Sort By']")
	WebElement dropDown1;
	Select select1;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/child::li/div/h2/a")
	List<WebElement> products;

	@FindBy(xpath = ".//span[text()='Compare']")
	WebElement compare;

	public static String price;

	/*
	 * @FindBy(xpath = ".//a[text()='Sony Xperia']") WebElement mobileSonyXperia;
	 * ".//a[text()='Sony Xperia']" --> ".//a[text()='" + mobileName + "']";
	 * 
	 * 
	 * String a = "-"; Stirng b = "xyz";
	 * 
	 * abc-xyz "abc"+a+b
	 */

	public MobileListPage selectNameOption() {
		select1 = new Select(dropDown1);
		select1.selectByVisibleText("Name");
		return new MobileListPage();
	}

	/*
	 * public MobileListPage verifyNameSorted() { select1 = new Select(dropDown1);
	 * List<WebElement> allList = select1.getOptions(); List<String> names = new
	 * ArrayList(); for (int i = 0; i < allList.size(); i++) {
	 * System.out.println("The Mobile name is: " + allList.get(i).getText());
	 * names.add(allList.get(i).getText()); } boolean sorted =
	 * Ordering.natural().isOrdered(names);
	 * System.out.println("The list is sorted? " + sorted); return new
	 * MobileListPage(); }
	 */

	public MobileListPage checkNameSorted() {
		List<String> names = new ArrayList();
		for (int i = 0; i < products.size(); i++) {
			System.out.println("The mobile name is: " + products.get(i).getText());
			names.add(products.get(i).getText());
		}
		boolean sorted = Ordering.natural().isOrdered(names);
		Assert.assertEquals(sorted, true);
		System.out.println("Names are sorted " + sorted);
		return new MobileListPage();

	}

	public MobileDetailPage clickMobile(String mobileName) {
		WebElement mobileSonyXperia = driver.findElement(By.xpath(".//a[text()='" + mobileName + "']"));
		WebElement priceTag = mobileSonyXperia.findElement(By.xpath("./following::div//child::span"));
		System.out.println("Price Tag Value : " + priceTag.getText());
		price = priceTag.getText();
		mobileSonyXperia.click();
		// WebElement sony = driver.findElement(By.xpath("//a[text()='Sony Xperia']"));
		// System.out.println("Sony is here : " + sony);
		return new MobileDetailPage();
	}

	public MobileListPage clickAddToCompareProduct(String productName) {

		WebElement product = driver.findElement(By.xpath(".//a[text()='" + productName + "']"));
		WebElement compareButton = product.findElement(By.xpath("./following::a[text()='Add to Compare']"));
		compareButton.click();
		System.out.println("compareButton : " + compareButton);

		return new MobileListPage();
	}

	public ProductComparisonPage clickCompareButton() {
		compare.click();
		windowHandles("Products Comparision List");
		return new ProductComparisonPage();
	}

}
