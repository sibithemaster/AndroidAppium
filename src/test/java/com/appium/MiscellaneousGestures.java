package com.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousGestures extends AppiumBaseClass{


	@SuppressWarnings("deprecation")
	public void test()
	{
		// to start the activity directly  from where you want
		Activity activity = new Activity("com.google.android.youtube", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
		driver.startActivity(activity);
		
	}
	@Test
	public void miscellaneousGestures() throws MalformedURLException, InterruptedException
	{
		configurationForAppium();
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();

		driver.findElement(By.id("android:id/checkbox")).click();
		
        DeviceRotation landscape = new DeviceRotation(0,0,90);
		
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
	
		//validating the title
		String text=driver.findElement(By.id("android:id/alertTitle")).getText();
		//printing
		System.out.println(text);
		//checking the condition
		Assert.assertEquals(text, "WiFi settings");
		
		//key board events in emulator
		
		driver.setClipboardText("Sibi1234");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

//		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
//		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/button1")).click();
	
//		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
//		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
