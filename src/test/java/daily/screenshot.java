package daily;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	
	public static void main (String [] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		// to take a screenshot you always create TakesScreenshot object like 
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/homepage.png"); //directly taken because we have ss folder in our project
		
		
		src.renameTo(destination);
		System.out.println("Taken ss befor scrolling..");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File destination1 = new File("./screenshots/footer.png");
		
		src1.renameTo(destination1);
		
		System.out.println("Taken ss for footer..");
		
		driver.quit();
		
		
	}

}
