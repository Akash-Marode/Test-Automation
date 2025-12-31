package BrowserMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigations 
{
	public static void main(String [] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		System.out.println("On First Page...");
		driver.get("https://www.flipkart.com/");
		
		System.out.println("Flipkart Info");
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println(title);
		
		System.out.println();
		System.out.println();
		
		driver.findElement(By.xpath("//span[text()='Login']")).click();	
		
		System.out.println("On Second Page...");
		//driver.navigate().to("");
		
		System.out.println("Login page");
		String title1 = driver.getTitle();
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		
		System.out.println(title1);
		
		driver.navigate().back();
		System.out.println("after return...");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		
		driver.navigate().forward();
		System.out.println("after return...");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.navigate().refresh();
		
		System.out.println("After refresh...");
		
		System.out.println("Just for git");
		
		
		//Set <String> windowids = driver.getWindowHandles();
		//System.out.println(windowids);
		
		
		driver.quit();
		
		
		
		
	}
	
	
}
