package com.mobilebrowser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseClass {

	public WebDriver driver;

	public AppiumDriverLocalService service;

	@BeforeClass
	public void configurationForGeneralStore() throws MalformedURLException, InterruptedException
	{ 
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		    
		    desiredCapabilities.setCapability("appium:deviceName", "SibiEmulator");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("browserName", "Chrome");
		    desiredCapabilities.setCapability("appium:app", "/Users/vc/Downloads/chromedriver_mac64/chromedriver");
		    desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
		    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
			
		//to start the server automatically useful for Jenkins integration
		service= new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("SibiEmulator");
        options.setChromedriverExecutable("/Users/vc/Downloads/chromedriver_mac64/chromedriver");
        options.setCapability("browserName", "Chrome");
		
		//connecting the server with mobile
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),desiredCapabilities);
		//implicit wait for whole class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//It is only for real device
		//Thread.sleep(10000);
	}
}
