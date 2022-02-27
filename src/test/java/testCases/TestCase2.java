package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;

public class TestCase2 extends TestBase {
	;
	HomePage homePage;

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}

	@Test
	public void scenario_6() {
		homePage.clickAccountField().clickLoginIcon().login("roh12@gmail.com", "123456")
				.clickMyAccountPageAccountField().clickMyWishListLinkInMyAccountPage();
		

	}

}
