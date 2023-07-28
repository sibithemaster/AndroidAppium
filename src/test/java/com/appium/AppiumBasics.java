package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.beust.ah.A;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumBasics extends AppiumBaseTest{ 
			
	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException
	{	
		//acting as a bridge between mobile avd and server
			
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.findElement(By.id("android:id/edit")).sendKeys("iphone");
		
		driver.findElement(By.id("android:id/button1")).click();
		
        driver.quit();
//		driver.findElement(AppiumBy.accessibilityId("Phone")).click();
//		driver.findElement(AppiumBy.accessibilityId("key pad")).click();
//		driver.findElement(By.xpath("com.google.android.dialer:id/digits")).sendKeys("9009009009");
//		driver.findElement(By.id("")).click();
		
	
	    
	}
	
}
