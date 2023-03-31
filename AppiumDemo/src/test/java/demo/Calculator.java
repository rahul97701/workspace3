package demo;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
		// 1. Launch the calculator app
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5544");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("aapActivity", "com.miui.calculator.cal.CalculatorActivity");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
	}
	
	@Test(priority = 0)
	public void verifyAdditionProcess() {
		// 2. Verify the addition process
		
		//Tap the key '9'
		driver.findElement(By.id("com.miui.calculator;id/digit_9")).click();
		
		//Tap the key '+'
		driver.findElementByAccessibilityId("plus").click();
		
		//Tap the key '1'
		driver.findElement(By.id("com.miui.calculator:id/digit_1")).click();
		
		//Tap the key '='
		driver.findElementByAccessibilityId("equals").click();
		
		String expectedResult = "10";
		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2);
		Assert.assertEquals(actualResult, expectedResult);
		
		
		
		
		
	}
	
	
	// 3. Verify the multiplication process
	
	@Test(priority=1)
	public void verifyMultiplicationProcess() {
		//Press C twice to clear the screen;
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"clear\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"clear\"]")).click();

		//Press 5
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
		
		//Press *
		driver.findElement(By.id("com.miui.calculator:id/op_mul")).click();
		
		//Press 4
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();
		
		//Press =
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		
		String expectedResult = "20";
		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	// 4. Verify the AC button is visible to the user
	
	@Test(priority=2)
	public void verifyAcBtn() {
		boolean ACBtnStatus = driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).isDisplayed();
		Assert.assertTrue(ACBtnStatus);
	}
	
	// 5. Close the app
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
