package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VeirifyLinkedInTitle {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ruchi\\Downloads\\geckodriver-v0.32.2-win32.zip"); 
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.swiggy.com");
		
	}
	
	@Test
	public void verifyTitle() {
		
		String expectedTitle = "Order food online from restaurants and get it delivered. Serving in Bangalore, Hyderabad, Delhi, Gurgaon, Nagpur, Jaipur, Coimbatore, Chandigarh, Ahemdabad ...";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
