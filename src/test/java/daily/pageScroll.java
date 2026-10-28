package daily;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class pageScroll 
{
	public static void main (String [] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		//create Java script object
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scroll by pixels
		js.executeScript("window.scrollBy(0,700)");
		System.out.println("Scrolled by pixels");
		Thread.sleep(3000);
		//scroll till footer
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scroll till footer");
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
	

}
