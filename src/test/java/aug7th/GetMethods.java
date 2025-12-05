package aug7th;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.orangehrm.com//"); 
		
		Thread.sleep(8000);
		
		System.out.println(driver.getTitle());  // this will return the current page title.
		
		System.out.println(driver.getCurrentUrl());  // this returns the current page url
		
		//String windowId = driver.getWindowHandle();
		
		// System.out.println("Window Id : " + windowId );  // always Returns the dynamic window  id 
		
		driver.findElement(By.xpath("//button[contains(text(),'Contact Sales')]")).click();
		
		     Set<String> WindowID = driver.getWindowHandles();
		     
		     System.out.println(WindowID);
		
	}

}
