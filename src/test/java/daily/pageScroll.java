package daily;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageScroll 
{
	public static void main (String [] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		driver.get("https://tutorialsninja.com/demo/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// for scrolling by pixels 
		js.executeScript("window.scrollBy(0,500)"); 
		System.out.println("Scrolled throught Pixels...");
		
		// if you want to scroll till bottom of the page then use below
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scrolled till footer..");
		
		
		
		driver.quit();
		
	}
	

}
