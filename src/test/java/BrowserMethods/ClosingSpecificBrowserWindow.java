package BrowserMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow 
{

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();  // Chrome Opened
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));  
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("For First window..");
		System.out.println("First Window Title : " + driver.getTitle());
		System.out.println("First window Id : " +driver.getWindowHandle());
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set <String> windowIDs = driver.getWindowHandles(); // to get all window id.
		
		for(String winid : windowIDs)
		{
			String title = driver.switchTo().window(winid).getTitle();
			
			if(title.equals("Human Resources Management Software | HRMS | OrangeHRM"))
			{
				System.out.println("For Second window..");
				System.out.println("Second Window Title : " + driver.getTitle());
				System.out.println("Second Window Id : " + driver.getWindowHandle());
							
		    }
		}
		for(String winid : windowIDs)
		{
			String title = driver.switchTo().window(winid).getTitle();
		
			if(title.equals("OrangeHRM"))
			{
				System.out.println("We Successfully Switched Windows among browser and Closing the first Window..");
				
				driver.close();
			}
		}
		
		System.out.println("Now CLosing the second window with quit method...");
		
		driver.quit();
		
	}

}
