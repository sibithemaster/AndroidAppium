package com.framework.pageobjectmodel.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidGesturesOrActions{

	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement closeButton;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	
	public List<WebElement> getProductList()
	{
		return productList;
		
	}
	public double getSumOfTheProducts()
	{
		int count = productList.size();
		double totalSum=0;
		for(int i=0;i<count;i++)
		{
			String productAmount=productList.get(i).getText();
			//reusable method for removing dollar symbol
			Double price=getRemovalOfCurrency(productAmount);
			//adding total values of productList
			totalSum =totalSum+price;
		}
		return totalSum;
	}
	
	public double getTotalAmountDisplayed()
	{
		return getRemovalOfCurrency(totalAmount.getText());
	}
	
	public void acceptTermsAndConditions()
	{
		longpress(terms);
		closeButton.click();
	}
	
	public void clickingCheckBoxAndProceed()
	{
		checkbox.click();
		proceed.click();
	}
}
