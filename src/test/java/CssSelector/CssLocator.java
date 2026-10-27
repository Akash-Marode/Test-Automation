package CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocator {

	public static void main(String[] args) 
	{	
		// 1.CSS Selector By Using id = tag#id 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
	//	driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("t shirts");
		
	//	driver.findElement(By.linkText("Search")).click();
		
		System.out.println("Test 1 Passed");
		
		
		
		// 2.Now CssSelector By classname use dot here
		
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mobile");
		driver.findElement(By.linkText("Search")).click();
		System.out.println("Test 2 Passed");
		
		driver.quit(); 
	}

}
