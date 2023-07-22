package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBaseTest {

	public AndroidDriver driver;
	
    public AppiumDriverLocalService service;
	
	public static String NodeExe_Path ="//usr//local//bin//node";
	
	public static String NodeJSPath="//usr//local//lib//node_modules//appium//build//lib//main.js";
	
	public static String Server_Address="127.0.0.1";
	
//	@BeforeClass
	public void configurationForAppium() throws MalformedURLException
	{
//		DesiredCapabilities ds = new DesiredCapabilities();
//		ds.setCapability("deviceName", "emulator-5554");
//		ds.setCapability("platformName", "android");
//		ds.setCapability("automationName", "UIAutomator2");
//		ds.setCapability("app", "//Users//vc//eclipse-workspace//Appium//src//test//java//resource//ApiDemos-debug.apk");
//	
		
//		service= new AppiumServiceBuilder()
//				.usingDriverExecutable(new File("NodeExe_Path"))
//				.withAppiumJS(new File("NodeJSPath"))
//				.withIPAddress("Server_Address")
//				.usingPort(4723)
//				.build();
//
//		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("pixel");
		options.setApp("//Users//vc//eclipse-workspace//Appium//src//test//java//resource//ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		
	}
}
