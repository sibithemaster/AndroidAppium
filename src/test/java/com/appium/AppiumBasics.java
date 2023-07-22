package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumBasics extends AppiumBaseTest{ 

	public AppiumDriverLocalService service;
	
	public static String NodeExe_Path ="//usr//local//bin//node";
	
	public static String NodeJSPath="//usr//local//lib//node_modules//appium//build//lib//main.js";
	
	public static String Server_Address="127.0.0.1";
	
//	@Test(priority = 1)
//	public void serverStarting()
//	{
//		service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//				.usingDriverExecutable(new File("NodeExe_Path"))
//				.withAppiumJS(new File("NodeJSPath"))
//				.withIPAddress("Server_Address")
//				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
//				.usingPort(4723).withLogFile(new File("//Users//vc//Documents")));
//		
//		System.out.println("System starting with server ....");
//		
//		service.start();
//	}
		
	@Test
	public void appiumTest() throws MalformedURLException
	{	
		//acting as a bridge between mobile avd and server
			
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.findElement(By.id("android:id/edit")).sendKeys("iphone");
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
//		driver.findElement(By.id("")).click();
		
	
	    
	}
	
}
