package draftwin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Draftwincloudflaretest {
	
	public static void main (String [] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cloudflare.com/en-gb/plans/enterprise/contact/");
		
		driver.switchTo().frame("cf-chl-widget-toz6k");	
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		String title = driver.getTitle();	
		
		System.out.println(title);
	}

}
