package BrowserMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main (String [] args)
	{
		WebDriver driver = new ChromeDriver();   // Open Chrome
		driver.manage().window().maximize();    // Maximize chrome
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");        // First Window 
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//a[normalize-space()='OrangeHRM, Inc'])[1]")).click();   // Second Window   
		
		Set<String> WindowIds = driver.getWindowHandles();
		
		
		// First method 
		
		List<String> windowlist = new ArrayList(WindowIds);   // we can not get only one item from set and set dose not have get method also. also set do not follow index 
		
		String parentid = windowlist.get(0);
		String childid =  windowlist.get(1);   // now we can easily switch between windows.
		
		System.out.println(parentid);
		
		// now we will switch to child window
		 
		driver.switchTo().window(childid);
		
		System.out.println(driver.getTitle());
		System.out.println(childid);
		
		
		
	}
}
