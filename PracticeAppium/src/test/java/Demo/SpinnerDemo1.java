package Demo;

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

public class SpinnerDemo1 {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException{
		DesiredCapabilities dc1 = new DesiredCapabilities();
		dc1.setCapability("deviceName", "emulator-5554");
		dc1.setCapability("platformName", "Android");
		dc1.setCapability("appPackage", "com.touchboarder.android.api.demos");
		dc1.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		dc1.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc1);
		
		}
	
	@Test
	public void selectValuesFromDropDown() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@text= 'API Demos']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text= 'Views']")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
		
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text= 'green']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text= 'green']")).click();
		
		
		
		
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text= 'Jupiter']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text= 'Jupiter']")).click();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	

}
