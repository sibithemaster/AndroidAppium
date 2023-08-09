package com.framework.AppiumAndroidFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pageobjectmodel.android.CartPage;
import com.framework.pageobjectmodel.android.FormPage;
import com.framework.pageobjectmodel.android.ProductCataloguePage;

import io.appium.java_client.AppiumBy;

public class ProductAddToCart extends AppBaseTest{

	@BeforeMethod
	public void beforeTestStarts()
	{
		form.setActivity();
	}
	
	@Test(dataProvider ="getData")
	public void addToCart(HashMap<String, String> input) throws InterruptedException, MalformedURLException
	{
		
		
		form.setCountrySelection(input.get("country"));
		
		form.setNameField(input.get("name"));
		
		form.setGender(input.get("gender"));
		
		ProductCataloguePage productCataloguePage = form.submitingForm();
		
		productCataloguePage.addingItemTocart(0);
		
		productCataloguePage.addingItemTocart(0);	
		
		CartPage cartPage = productCataloguePage.addedToCart();
		
		double totalSum=cartPage.getSumOfTheProducts();
		
		double displayFormattedSum=cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		cartPage.acceptTermsAndConditions();
		
		cartPage.clickingCheckBoxAndProceed();
		

	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
	    List<HashMap<String,String>>data=gettingJsonData(System.getProperty("user.dir")+"//src//test//java//com//jsonfiles//cart.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
