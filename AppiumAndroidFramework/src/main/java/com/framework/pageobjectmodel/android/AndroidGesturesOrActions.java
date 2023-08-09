package com.framework.pageobjectmodel.android;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGesturesOrActions {

	AndroidDriver driver;
	
	public AndroidGesturesOrActions(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	//Appium gestures methods starts
	public void longpress(WebElement element)
	{

		//JavascriptExecutor 
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),"duration",2000));

	}

	//scrolling using UIAutomator till that text
	public void scrollUsingUIAutomator(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
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
	
	
	public double getRemovalOfCurrency(String amount) {
		
		Double price=Double.parseDouble(amount.substring(1));
		return price;
		
	}

}
