package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeDemo {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		
	// 1. Launch Google Maps App
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
	    cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        cap.setCapability("noReset", true);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}

	
	@Test
	public void swipeRight() throws InterruptedException {
		Thread.sleep(3000);
		// 2. Emulate the action of swiping towards right
		TouchAction<?> ta = new TouchAction<>(driver);
		ta.press(PointOption.point(178,333)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(478,336)).release().perform();
		
		
		
		
		
	}
	
	
	
	

}
