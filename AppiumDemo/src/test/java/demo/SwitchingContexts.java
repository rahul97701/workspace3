package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwitchingContexts {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchBrowser() throws MalformedURLException {
		
		// 1.Launch Chrome browser in the mobile device
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "emulator-5544");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http:0.0.0.0:4723/wd/hub"), dc)
	;
		
		// 2. Navigate to https://ebay.com
		driver.get("https://ebay.com");	
		
	}
	
	@Test
	public void switchContexts() {
		
		// 3. Switch to Native App View
	/*Set<String> contexts = driver.getContextHandles();
		for(String t: contexts) {
			System.out.println(t);
		}
		
		System.out.println("Default Context = " + driver.getContext());
		*/
		
		driver.context("NATIVE_APP");
		
		// 4. Click on th 3 dots at top right corner
		driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
		
		// 5. Click on 'Add to Home Screen'
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to Home screen']")).click();
		
		//6. Wait for the pop-up to appear
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("com.android.chrome:id/positive_button")));
		
		//7. Click on 'Add' button
		driver.findElement(By.xpath("com.android.chrome:id/positive_button")).click();
		
		//8. Click on 'Add to Home Screen' button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Add to Home screen']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Home screen']")).click();
	}
	

}
