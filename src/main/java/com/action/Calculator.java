package com.action;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {

	public static AndroidDriver driver;
	
	@Test
	public void testingCalculator() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("newCommandTimeout", 100000);
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("app", "/Users/vc/Downloads/Calculator_8.4.1 (520193683)_Apkpure.apk");
		caps.setCapability("noReset", true);
		caps.setCapability("automationName", "UIAutomator2");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(AppiumBy.accessibilityId("2")).click();
		driver.findElement(AppiumBy.accessibilityId("5")).click();
		
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("2")).click();
		driver.findElement(AppiumBy.accessibilityId("5")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		driver.close();
		
		driver.findElement(AppiumBy.accessibilityId("Phone")).click();
		
		driver.findElement(AppiumBy.accessibilityId("key pad")).click();
		
		driver.findElement(By.id("com.google.android.dialer:id/digits")).sendKeys("9003690138");
		
		
		
		
		 
		
	}
}
