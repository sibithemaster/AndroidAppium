import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class WalmartQuestion {

	public static void main(String [] args) throws InterruptedException {
		
			// Launching browser
		//	WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			// Loading Google
			driver.get("https://www.google.com/");
			Thread.sleep(5000);
			
			// Google Apps is a SVG element. There are multiple svg element so I used multiple attributes.
			driver.findElement(By.xpath("//*[name()='svg' and @class='gb_h']")).click();
			
			// App names are shown in under an IFrame
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='app']")));
			
			
			//ul[@jsname='k77Iif']
			// Locating all app names. XPath is tricky as we can not use their values as they are dynamic
			List<WebElement> allMenus = driver.findElements(By.xpath("//ul[@jsname='k77Iif']/li"));
			
			// Printing all app names Without stream
			for(WebElement menu : allMenus)
			{
				System.out.println(menu.getText());
			}
			
			System.out.println("=============using stream concept================");
			// With stream apis
			allMenus.stream().map(WebElement::getText).forEach(System.out::println);
			
			//quitting driver
			driver.quit();
			
		}

	}
