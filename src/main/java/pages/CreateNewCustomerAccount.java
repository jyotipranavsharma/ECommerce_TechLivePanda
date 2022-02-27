package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateNewCustomerAccount extends TestBase {
	public CreateNewCustomerAccount() {
		PageFactory.initElements(driver, this);
	}

	public MyAccount createNewCustomer(String firstName, String middleName, String lastName,String email, String password,
			String confirmationPassword) {
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("middlename")).sendKeys(middleName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(confirmationPassword);
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		
		return new MyAccount();
		
	}
}
