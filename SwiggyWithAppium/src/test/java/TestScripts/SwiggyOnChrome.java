package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwiggyOnChrome {
	
AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("app", "C:\\chrome.apk");
		cap.setCapability("noReset", true);
	
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

	}
	
	@Test
	public void openSwiggyWebsite() {
		
		driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("swiggy.com");
		driver.findElementByXPath("//android.widget.TextView[@text= 'swiggy.com']").click();
	}
		
	



@AfterTest
public void closeBrowser() {
	driver.quit();
	
}
}
