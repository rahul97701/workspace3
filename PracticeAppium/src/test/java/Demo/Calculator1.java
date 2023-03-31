package Demo;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calculator1 {
	
	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
	    dc.setCapability("deviceName", "emulator-5554");
	    dc.setCapability("platformName", "ANDROID");
	    dc.setCapability("appPackage", "com.miui.calculator");
	    dc.setCapability("appActivity", "com.miui.calculator.cal.DefaultCalculatorActivity");
	    dc.setCapability("noReset", true);
	    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
	    		
	    		
	}
	
	@Test(priority=0)
	public void verifyAddition() {
		
		driver.findElement(By.id("com.miui.calculator:id/btn_9_s")).click()		;
		
		driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
		
		driver.findElement(By.id("com.miui.calculator:id/btn_4_s")).click();
		
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		
		String expectedResult = "13";
		String actualResult = driver.findElementById("com.miui.calculator:id/result").getText().substring(2);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@Test(priority=1)
	public void verifyMultiplicationProcess() {
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"clear\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"clear\"]")).click();
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"77\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"delete\"]")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"85\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();
		
		String expectedResult = "6545";
		String actualResult = driver.findElementById("com.miui.calculator:id/result").getText().substring(0);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	

				
}
