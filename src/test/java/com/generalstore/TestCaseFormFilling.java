package com.generalstore;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCaseFormFilling extends BaseClass{

	@Test
	public void testingFormGeneralStore() throws MalformedURLException, InterruptedException
	{
		configurationForGeneralStore();
		
		//selecting the country
        driver.findElement(By.id("android:id/text1")).click();
		//scroll till text visible
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();	
		
		//sending name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Angel");
		//hiding the keyboard entering the values in text boxes
		driver.hideKeyboard();		
		//Female
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		
		
		
		
			
	}
}
