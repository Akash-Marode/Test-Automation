package BrowserMethods;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScrollDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90)); // wait for synchronization
		
		driver.get("https://www.flipkart.com/");
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// js.executeScript("window.scrollBy(0,900)"); // this is what i have written
		 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
		 System.out.println("Scrolled to bottom of the page.");
		 
		 Thread.sleep(5000); // this is because i wanted to see that the page is scrolled.
		 
		 driver.quit();
		
	}

}
