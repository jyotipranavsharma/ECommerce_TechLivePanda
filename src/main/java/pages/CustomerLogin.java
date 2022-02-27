package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CustomerLogin extends TestBase {

	public CustomerLogin() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//span[text()='Create an Account']")
	WebElement createNewAccount;

	public CreateNewCustomerAccount clickCreateNewAccount() {
		createNewAccount.click();
		return new CreateNewCustomerAccount();
	}

	public MyAccount login(String email, String password) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		return new MyAccount();
	}
}
