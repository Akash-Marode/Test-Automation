package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathSelector {

	public static void main(String[] args)
	
	{

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.xpath("//input[@placeholder='Search store' or @name='q']")).sendKeys("Tshirts");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();   // we can use "and" "or" Operator in xpath  if we want to use  Single or multiple Attributes  e.g. //button[@type='submit' and  @Placeholder='Search']
		
		System.out.println("Test 1 passed");
		
		driver.findElement(By.xpath("//*[text()='Desktop']")).click(); // Xpath Without Attribute
		driver.findElement(By.xpath("//*[contains(@placeholder='Sea')")).click(); // Xpath Without Attribute With contains Method
		
	}

}
