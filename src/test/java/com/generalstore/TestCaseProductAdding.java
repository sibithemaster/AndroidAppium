package com.generalstore;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class TestCaseProductAdding extends BaseClass{

	@Test
	public void addToCart() throws InterruptedException, MalformedURLException
	{
		//selecting the country
        driver.findElement(By.id("android:id/text1")).click();
		//scroll till text visible
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		//clicking the country
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();		
		//sending name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Angel");
		//hiding the keyboard entering the values in text boxes
		driver.hideKeyboard();		
		//Female
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		//clicking login button
		driver.findElement(AppiumBy.className("android.widget.Button")).click();

	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 4 Retro\"));"));
		//getting the counts of products
	//	int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++)
		{
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("Air Jordan 4 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String lastPageProduct= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Air Jordan 4 Retro");
	//	Thread.sleep(5000);
	}
}
