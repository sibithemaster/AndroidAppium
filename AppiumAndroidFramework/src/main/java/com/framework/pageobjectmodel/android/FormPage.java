package com.framework.pageobjectmodel.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Page Object Model class!
 *
 */
public class FormPage extends AndroidGesturesOrActions
{
	AndroidDriver driver;
	
	
	//scope of the driver is here
	public FormPage(AndroidDriver driver)
	{
		//calling super class driver if does not exist it will throw error
		super(driver);
		//we are giving scope to the driver
		this.driver=driver;
		//intializing driver for all
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/* setting the page object model for WebElement */
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement maleOption;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement shopButton;

	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	//selecting the country
	public void setCountrySelection(String countryName)
	{
		countrySelection.click();
		scrollUsingUIAutomator(countryName);
		/* Dynamic xpath so we are not putting into page object model */
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}

	//setting the name for name field for name text box
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	//selecting the gender
	public void setGender(String gender)
	{
		if(gender.contains("female"))
		{
			femaleOption.click();
		}else {
			maleOption.click();
		}
	}
	
	
	public ProductCataloguePage submitingForm()
	{
		shopButton.click();		
		return new ProductCataloguePage(driver);
	}
	
	
}
