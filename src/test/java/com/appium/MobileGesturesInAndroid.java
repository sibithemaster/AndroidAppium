package com.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class MobileGesturesInAndroid extends AppiumBaseClass{

	
	@Test(priority = 2)
	public void longpressGesture() throws MalformedURLException, InterruptedException
	{	
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
			
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	
		longpress(element);
		
		String menu=driver.findElement(By.id("android:id/title")).getText();
		
		Assert.assertEquals(menu, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=1)
	public void scrolling() throws MalformedURLException, InterruptedException
	{

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		    
		scrollTillEnd();
	}
	
	@Test(priority = 3)
	public void swipping() throws MalformedURLException, InterruptedException
	{
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement image = driver.findElement(By.xpath("(//android.widget.ImageView)[3]"));
		
		swipe(image);
	}	
	
	@Test(priority = 4)
	public void draggingAndDropping() throws MalformedURLException, InterruptedException
	{
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		dragAndDrop(source,619,560);
		
		Thread.sleep(3000);	
		
	}
	
}
