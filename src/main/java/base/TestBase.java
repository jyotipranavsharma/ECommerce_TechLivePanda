package base;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import utility.Util;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

	public static void initialization() {
		String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"C://Users//Pranav Jyoti Vihaan//Selenium tutorial//Installer//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//Pranav Jyoti Vihaan//Selenium tutorial//Installer//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//System.out.println("URL is " + prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
	}
	// 
	public static void windowHandles(String pageTitle) {
		Set<String> window = driver.getWindowHandles();
		System.out.println("The size of window is: " + window.size());
		Iterator<String> iterator = window.iterator();
		
		while(iterator.hasNext()){
			String parentWindow = iterator.next();
			String windowTitle = driver.switchTo().window(parentWindow).getTitle();
			if(windowTitle.contains( pageTitle)) {
				break;
			}
			
		}
		
	}
	
	
	
	
	 /* public static void main(String[] args) { 
      TestBase base = new TestBase();
	  System.out.println("I am here"); Assert.assertNotNull(base.driver);
	  System.out.println("base driver : " + base.driver); }*/
	 
}
