package com.redmi;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class RealDeviceCalculator 
{
	public static  AndroidDriver driver;
	
	@Test
	public void calculator() throws MalformedURLException
	{
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "Sibi");
		caps.setCapability("newCommandTimeout", 100000);
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability("platformVersion", "14.0.5");
		caps.setCapability("udid", "lfzhn7rwk7irbqbe");
		caps.setCapability("appPackage", "com.miui.calculator");
		caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		caps.setCapability("noReset", true);
		caps.setCapability("automationName", "UIAutomator2");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.accessibilityId("com.miui.calculator:id/root_view")).click();
		driver.findElement(By.xpath("com.miui.calculator:id/btn_7_s")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		
		driver.findElement(By.xpath("com.miui.calculator:id/btn_3_s"));
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//com.miui.calculator:id/btn_7_s
//		WebElement seven = driver.findElement(By.xpath("com.miui.calculator:id/btn_7_s"));
//		seven.click();
		//plus
//		WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
//		plus.click();
//		//com.miui.calculator:id/btn_3_s
//		WebElement three = driver.findElement(By.xpath("com.miui.calculator:id/btn_3_s"));
//		three.click();
//		//equals
//		WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
//		equals.click();
		
//		 WebElement el2 =  driver.findElement(By.id("com.miui.calculator:id/btn_4_s"));
//		 el2.click();
	}

}
