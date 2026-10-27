package BrowserMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitch {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String title = driver.getTitle();  // 1 st window.
		System.out.println("First window title : " + title);  // page title.
		String parentwindow =  driver.getWindowHandle();
		System.out.println("First window id : " +parentwindow); // printing first window id.
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set <String> windowids = driver.getWindowHandles();
		
		for(String winid : windowids)
		{
			String titles = driver.switchTo().window(winid).getTitle();
			
			if(titles.equals("OrangeHRM: All in One HR Software for Businesses | OrangeHRM"))
			{
				System.out.println("For Second window..");
				System.out.println("Second Window Title : " + driver.getTitle());
				System.out.println("Second Window Id : " + driver.getWindowHandle());
				
				driver.close();
				
				break;
							
		    }
			
		}
		
		driver.switchTo().window(parentwindow);
			
		System.out.println("we are back to our first window");
		System.out.println("First window title : " + title);  // page title.
		System.out.println("First window id : " + driver.getWindowHandle()); // printing first window id.
		
		driver.quit();
	}

}
