package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZoomInOut {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
	    dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        dc.setCapability("noReset", true);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        
		
	}
	
	@Test
	public void zoomOut() throws InterruptedException {
		Thread.sleep(3000);
		
		//Swipe from left to right
		TouchAction<?> ta1 = new TouchAction<>(driver);
				ta1.press(PointOption.point(78,435)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		       .moveTo(PointOption.point(285,504)).release();
				
				
				
				
				
				
		
		//Swipe from right to left
				TouchAction<?> ta2 = new TouchAction<>(driver);
				ta2.press(PointOption.point(398,654)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			    .moveTo(PointOption.point(256,489)).release();
				
		
		//Move towards each other
				MultiTouchAction mta = new MultiTouchAction(driver);
				mta.add(ta1).add(ta2).perform();
				
				Thread.sleep(3000);
	}
	
	@Test(priority=0)
	public void zoomIn() throws InterruptedException {
		Thread.sleep(3000);
		
		//Swipe from left to right
		TouchAction<?> ta1 = new TouchAction<>(driver);
				ta1.press(PointOption.point(209,598)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		       .moveTo(PointOption.point( 28,616)).release();
				
				
				
				
				
				
		
		//Swipe from right to left
				TouchAction<?> ta2 = new TouchAction<>(driver);
				ta2.press(PointOption.point(372,400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			    .moveTo(PointOption.point(635,496)).release();
				
		
		//Move towards each other
				MultiTouchAction mta = new MultiTouchAction(driver);
				mta.add(ta1).add(ta2).perform();
				
				//Thread.sleep(3000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
