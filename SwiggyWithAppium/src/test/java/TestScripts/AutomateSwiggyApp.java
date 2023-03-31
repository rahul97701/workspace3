package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AutomateSwiggyApp {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appPackage", "in.swiggy.android");
		cap.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

		
		
	}
	
	@Test
	public void test() throws InterruptedException {
		//1. Click on Get Started Button
	     driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Get started,Button\"]/android.widget.TextView").click();
		 
	   //2. Click on your Mobile number or enter your mobile number & click
	     WebDriverWait wait = new WebDriverWait(driver, 60);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@content-desc=\"098276 55054\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")));
	     driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"098276 55054\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").click();
	   
	     driver.findElementByXPath("//android.widget.TextView[@text= 'Get OTP']").click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text= 'Allow location access']")));
	     driver.findElementByXPath("//android.widget.TextView[@text= 'Allow location access']").click();
	     Thread.sleep(200);
	     driver.findElementByXPath("//android.widget.Button[@text= 'ALLOW ONLY WHILE USING THE APP']").click();
	     
	     Thread.sleep(500);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"explore food deliveries\"]")));
	     //driver.findElementByXPath("//android.widget.ImageView[@content-desc= 'explore food deliveries']").click();
	   driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"explore food deliveries\"]").click();
	   
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"restaurants curated for pizza\"]")));
	   driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"restaurants curated for pizza\"]").click();
	   
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text= 'Da Pizzeria']")));
	   driver.findElementByXPath("//android.widget.TextView[@text= 'Da Pizzeria']").click();
	   
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"ADD\").instance(0))").click();

	   
	   
	   
	}
	@AfterTest
	public void closeApp() {
		driver.quit();
	}

}
