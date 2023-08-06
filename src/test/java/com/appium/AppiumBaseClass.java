package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumBaseClass {

	public AndroidDriver driver;
	
    public AppiumDriverLocalService service;
    	
    @BeforeClass
	public void configurationForAppium() throws MalformedURLException, InterruptedException
	{
        DesiredCapabilities caps = new DesiredCapabilities();	
		caps.setCapability("deviceName", "SibiEmulator");
		caps.setCapability("newCommandTimeout", 100000);
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability("platformVersion", "14");
		//real device unique id
        //caps.setCapability("udid", "lfzhn7rwk7irbqbe");
		caps.setCapability("app", "/Users/vc/Downloads/resources/ApiDemos-debug.apk");
		caps.setCapability("noReset", true);
		caps.setCapability("automationName", "UIAutomator2");
			
		//to start the server automatically useful for Jenkins integration
		service= new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		
		//connecting the server with mobile
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
		//implicit wait for whole class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		//It is only for real device
        //Thread.sleep(10000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
	
}
