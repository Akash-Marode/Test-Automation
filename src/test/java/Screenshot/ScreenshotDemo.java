package Screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) 
		{
		
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().window().setPosition(new Point(1920, 0));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://logan.kodedice.com/");
			
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("letmein123");
			driver.findElement(By.xpath("//button[text()='Unlock']")).click();
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File sourcefile = ts.getScreenshotAs(OutputType.FILE);  // return file type of object , cause we have stored this file somewhere in the memory but we don't know where it is.
			
			File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\beforeloginform.png"); // by this way we can take screen shot in any system, dosen't matter if the system or location of folder or project changes.
			
			sourcefile.renameTo(targetfile);  // copy source file to target file
			
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			
			File sourcefile2 = ts.getScreenshotAs(OutputType.FILE);
			File targetfile2 = new File(System.getProperty("user.dir")+"\\screenshots\\loginform.png");
			sourcefile2.renameTo(targetfile2);
			
			driver.quit();
			
			
			
		}
	
}
