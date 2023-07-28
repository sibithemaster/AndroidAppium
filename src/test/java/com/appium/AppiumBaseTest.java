package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumBaseTest {

	public AndroidDriver driver;
	
    public AppiumDriverLocalService service;
	
	public static String NodeExe_Path ="//usr//local//bin//node";
	
	public static String NodeJSPath="//usr//local//lib//node_modules//appium//build//lib//main.js";
	
	public static String Server_Address="http://192.168.1.3:4723/";
	
	@BeforeClass
	public void configurationForAppium() throws MalformedURLException, InterruptedException
	{
//		DesiredCapabilities ds = new DesiredCapabilities();	
//		ds.setCapability("app", "/Users/vc/Downloads/resources/ApiDemos-debug.apk");
//		ds.setCapability("deviceName", "Sibi");
//		ds.setCapability("udid", "lfzhn7rwk7irbqbe");
//		ds.setCapability("platformName", "ANDROID");
//		ds.setCapability("platformVersion", "14.0.5");
		
			
//		service= new AppiumServiceBuilder()
//				.usingDriverExecutable(new File(NodeExe_Path))
//				.withAppiumJS(new File(NodeJSPath))
//				.withIPAddress(Server_Address)
//				.usingPort(4723)
//				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//				.build();
//
//		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Sibi");
		options.setUdid("lfzhn7rwk7irbqbe");
		options.setApp("/Users/vc/Downloads/resources/ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		Thread.sleep(10000);
	}
}
