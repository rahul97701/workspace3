package TestScripts;


	import java.net.MalformedURLException;
	import java.net.URL;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
	import org.openqa.selenium.remote.BrowserType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

public class VerifySwiggyTitleFirefox {
	
	

		
		private WebDriver driver;
		
		
		
		
		@BeforeTest
		public void launchApplication() throws MalformedURLException {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			driver.get("https://www.swiggy.com");
			
			}
		
		@Test(priority=0)
		public void verifyTitle() {
			
			String expectedTitle = "Order food online from India's best food delivery service. Order from restaurants near you";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			
		}
		
		@Test(priority=1)
		public void enterLocation() {
			
		driver.findElement(By.id("location"));
		driver.findElement(By.id("location")).sendKeys("Bhopal");
		
		}
		
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}

}
