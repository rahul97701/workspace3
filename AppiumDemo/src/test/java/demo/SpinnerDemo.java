package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SpinnerDemo { 
	AndroidDriver<AndroidElement> driver;
	
	// 1.Launch the app
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5544");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	@Test
	public void selectValuesFromDropDown() {
		// 2. Click on 'API Demos'
		driver.findElement(By.xpath("//android.widget.TextView[@text= 'API Demos']")).click();
		
		// 3. Click on 'Views'
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		// 4. Click on 'Spinner'
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
		// 5. Select 'yellow from the 1st drop-down
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='yellow']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();
		
		//6. Select 'Earth' from the 2nd drop-down
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();

		
		
	}

}
