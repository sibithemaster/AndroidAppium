package com.mobilebrowser;

import org.testng.annotations.Test;

public class MobileBrowserTestClass extends MobileBrowserBaseClass{

	
	@Test
	public void browserTest()
	{
		driver.get("https://www.google.com");
	}
}
