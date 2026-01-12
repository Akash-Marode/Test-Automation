package iframesdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://stg.ftimerbet.com/casino");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("letmein123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='accept_all']"))).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
		
		driver.findElement(By.xpath("(//input[@placeholder='Enter phone number'])[1]")).sendKeys("9876543216");
		driver.findElement(By.xpath("//input[@type='password' and @autocomplete='off']")).sendKeys("Pass@123");
		driver.findElement(By.xpath("//div[@id='pills-home']//button[@type='submit']")).click();
		
		//Open Game
		System.out.println("Before");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='https://thumbs.alea.com/e84b255f_pascal-gaming_777-poker_300x400.webp']"))).click();
		System.out.println("clicked");
		
		// Always return to parent
		driver.switchTo().defaultContent();

		// Wait for page to stabilize
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

		// Switch safely to i frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[name='casino-iframe']")));	
		System.out.println("Switched");
		
		driver.findElement(By.xpath("//div[@class='main-button']")).click();
		
		
		
		driver.quit();
		
		
			
		
		
	}

}
