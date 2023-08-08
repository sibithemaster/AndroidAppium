package com.generalstore;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCaseProductList extends BaseClass{

	@Test
	public void summingProduct() throws InterruptedException
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

		//adding two products and summing the values 
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		//add to cart button	
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//sometimes system may slow it will lead to stale element exception
		//for that put Thread.sleep();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		//getting all the product price in list
		List<WebElement> productPrice	=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		double sum=0;

		for(int i=0;i<count;i++)
		{
			String productAmount=productPrice.get(i).getText();
			//reusable method for removing dollar symbol
			Double price=getRemovalOfCurrency(productAmount);
			sum =sum+price;

		}

		String displaySumAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		//reusable method for removing dollar symbol
		Double displayFormattedSum = getRemovalOfCurrency(displaySumAmount);

		Assert.assertEquals(sum,displayFormattedSum);


		WebElement element=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longpress(element);

		driver.findElement(AppiumBy.className("android.widget.Button")).click();

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(10000);
		
		Set<String> context=driver.getContextHandles();
		
		for(String contextName:context)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q"));
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
		
		
	}

}
