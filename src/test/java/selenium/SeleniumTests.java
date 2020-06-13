package selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTests {
	
	WebDriver driver;
	String appUrl = "https://www.google.com";
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforetest(String browser) throws MalformedURLException
	{
		System.out.println("Browser Name is:"+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setCapability(ChromeOptions.CAPABILITY, options);
			options.setCapability("browserName", "chrome");
			options.setCapability("acceptSslCerts", "true");
			options.setCapability("javascriptEnabled", "true");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			options.merge(cap);
			try {
		        WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (browser.equalsIgnoreCase("firefox")){
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			options.setCapability("browserName", "firefox");
			options.setCapability("acceptSslCerts", "true");
			options.setCapability("javascriptEnabled", "true");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			options.merge(cap);
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver(options); 
		}
		
		driver.get(appUrl);
	
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	
	@Test
	public void dockertest1() {
	System.out.println("Inside First Test");
	Assert.assertFalse(true);

	}
	
	@Test
	public void dockertest2() {
		System.out.println("Inside second Test");

		}
	
	@Test
	public void dockertest3() {
		System.out.println("Inside third Test");

       }
	
	}
