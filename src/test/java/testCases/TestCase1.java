package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.CreateNewCustomerAccount;
import pages.CustomerLogin;
import pages.HomePage;
import pages.MobileDetailPage;
import pages.MobileListPage;
import pages.MobileShoppingCartPage;
import pages.MyAccount;
import pages.MyWishListPage;
import pages.ProductComparisonPage;
import pages.TVListPage;
import pages.WishlistSharinPage;
import utility.ExcelConfig;

public class TestCase1 extends TestBase {
	HomePage homePage;
	MobileListPage mobileItems;
	MobileDetailPage mobileDetailPage;
	MobileShoppingCartPage shoppingCart;
	ProductComparisonPage compareProducts;
	CreateNewCustomerAccount newCustomer;
	CustomerLogin login;
	MyAccount newAccount;
	TVListPage tvItems;
	MyWishListPage wishList;
	WishlistSharinPage wishlistSharing;

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		mobileItems = new MobileListPage();
		mobileDetailPage = new MobileDetailPage();
		shoppingCart = new MobileShoppingCartPage();
		compareProducts = new ProductComparisonPage();
		newCustomer = new CreateNewCustomerAccount();
		login = new CustomerLogin();
		newAccount = new MyAccount();
		tvItems = new TVListPage();
		wishList = new MyWishListPage();
		wishlistSharing = new WishlistSharinPage();
	}

	@Test(priority = 1, description = "Verify item in Mobile List page can be sorted by 'Name'")
	@Ignore
	public void scenario_01() {
		homePage.verifyTitleDemoSite().clickOnmnuMobile().selectNameOption().checkNameSorted();
	}

	@Test(priority = 2, description = "Veryfi product price in List page and Detail page are equal")
	@Ignore
	public void scenario_02() {
		homePage.clickOnmnuMobile().clickMobile(ExcelConfig.readData("TestCase-2", 1, 3)).getPrice();
		Assert.assertEquals(mobileItems.price, mobileDetailPage.price);
	}

	@Test(priority = 3, description = "Verify more products than available in the store cannot be added in the cart")
	@Ignore
	public void scenario_03() {
		homePage.clickOnmnuMobile().clickMobile(ExcelConfig.readData("TestCase-3", 1, 3)).clickAddToCart()
				.updateQTY(ExcelConfig.readData("TestCase-3", 2, 3)).checkErrorMessage().clickEmptyCart();

		// SoftAssert is used for verifying
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(MobileShoppingCartPage.actualMssg, shoppingCart.expectedMssg);
		softAssert.assertAll();

		// HardAssert is used for verifying
		Assert.assertEquals(MobileShoppingCartPage.actualMssg1, shoppingCart.expectedMssg1);
	}

	@Test(priority = 4, description = "Verify that u are able to compare two product")
	@Ignore

	public void scenario_04() {
		List<String> productsToCompare = new ArrayList();
		productsToCompare.add("IPHONE");

		productsToCompare.add("SONY XPERIA");

		homePage.clickOnmnuMobile().clickAddToCompareProduct("IPhone").clickAddToCompareProduct("Sony Xperia")
				.clickCompareButton().checkheading().selectedProductItem(productsToCompare).closeWindow();
		Assert.assertEquals(ProductComparisonPage.actualHeading, compareProducts.expectedHeading);
	}

	@Test(priority = 5)
	
	public void scenario_05() {

		/*homePage.clickAccountField().clickMyAccountLink().clickCreateNewAccount()
				.createNewCustomer("Bhuwan", "Kumar", "Chotia", "Rupa1O@gmail.com", "123456", "123456")
				.verifyWelcomeMssg();
		Assert.assertEquals(MyAccount.actualMssg.toLowerCase(), newAccount.expectedMssg.toLowerCase());*/

		homePage.clickAccountField().clickLoginIcon().login("Rupa1O@gmail.com", "123456").clickOnmnuTv()
				.clickAddtoWishList("LG LCD").clickShareWishlist()
				.passEmail("Oliver01@gmail.com", "This is my wishlist").verifySuccessMssg();
		Assert.assertEquals(MyWishListPage.actualMssg, wishList.expectedMssg);

	}

	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */

}
