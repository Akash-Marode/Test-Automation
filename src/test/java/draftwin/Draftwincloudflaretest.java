package draftwin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Draftwincloudflaretest {
	
	public static void main (String [] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cloudflare.com/en-gb/plans/enterprise/contact/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// js.executeScript("window.scrollTo(0,document.body.scrollHeight)");   scrolls to bottom of the page.
		
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement iframe = driver.findElement(
			    By.xpath("//iframe[contains(@title,'Cloudflare security challenge')]")
			);
			driver.switchTo().frame(iframe);
		
		System.out.println("Done");
		
		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox']"));
				
				js.executeScript("arguments[0].scrollIntoView(true);",element);
				
		 element.click();
		 
		String title = driver.getTitle();	
		
		System.out.println(title);
	}

}
