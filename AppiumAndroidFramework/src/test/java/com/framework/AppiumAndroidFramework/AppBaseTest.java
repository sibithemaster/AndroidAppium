package com.framework.AppiumAndroidFramework;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.framework.appium.utils.AppiumUtils;
import com.framework.pageobjectmodel.android.FormPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Framework implementation for general store App.
 */
public class AppBaseTest extends AppiumUtils
{
   
	public AndroidDriver driver;

	public AppiumDriverLocalService service;
	
	public FormPage form;

	@BeforeClass
	public void configurationForAppium() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();	
		//android device name
		caps.setCapability("deviceName", "SibiEmulator");
		caps.setCapability("newCommandTimeout", 100000);
		//which platform 
		caps.setCapability("platformName", "ANDROID");
		//platform version of current device or emulator
		caps.setCapability("platformVersion", "14");
		//real device unique id
		//caps.setCapability("udid", "lfzhn7rwk7irbqbe");
		caps.setCapability("app", "/Users/vc/Downloads/resources/General-Store.apk");
		//if app is already installed no need to reinstall
		caps.setCapability("noReset", true);
		//automation driver name for android 
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//It is only for real device
		//Thread.sleep(10000);
		
		 form = new FormPage(driver);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
