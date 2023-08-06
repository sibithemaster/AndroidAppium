package com.appium;

//import for URL
import java.net.MalformedURLException;
//import for Selenium
import org.openqa.selenium.By;
import org.testng.Assert;
//import for testng
import org.testng.annotations.Test;
//import for Appium
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends AppiumBaseClass{ 

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException
	{	
		//acting as a bridge between mobile avd and server

		configurationForAppium();

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();

		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox")).click();

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		//validating the title
		String text=driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		//printing
		System.out.println(text);
		//checking the condition
		Assert.assertEquals(text, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("iphone");

		driver.findElement(By.id("android:id/button1")).click();
		
	}	
}
