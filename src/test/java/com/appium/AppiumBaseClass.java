package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBaseClass {

	public AndroidDriver driver;

	public AppiumDriverLocalService service;

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
		caps.setCapability("app", "/Users/vc/Downloads/resources/ApiDemos-debug.apk");
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
	}


	//appium github gestures for many more
	//appium gestures methods starts
	public void longpress(WebElement element)
	{

		//JavascriptExecutor 
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),"duration",2000));

	}

	//scrolling using UIAutomator
	public void scrollUsingUIAutomator(String text)
	{
		//  	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}
	
	//Scroll using gestures we need direction
	public void scrollTillEnd()
	{
		boolean scrollMore;

		do 
		{
			scrollMore=(boolean) ((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", 
					ImmutableMap.of("left",100, "top",100 ,"height",200,"width",200,
							"direction","down",
							"percent",3));
		}while(scrollMore);
	}

	
	//swiping in mobile device we need direction
	public void swipe(WebElement swipeElement)
	{
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)swipeElement).getId(),
				"direction","left",
				"percent",0.75
				));
	}
	
	
	//drag and drop gesture
	public void dragAndDrop(WebElement drag,int xCoordinate,int yCoordinate)
	{	
		((JavascriptExecutor)driver).executeScript("mobile:dragGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)drag).getId(),
				"endX",xCoordinate,
				"endY",yCoordinate
				));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
