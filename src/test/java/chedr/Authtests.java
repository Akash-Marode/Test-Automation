package chedr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Authtests 
{
	WebDriver driver;
	
	
	// 1. Open application, 2. login, 3.get user name, 4.logout, 5.close application.
	
	@Test(priority=0)
	void testopenapp ()
	{
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1920, 0));  //for opening in second screen.
		driver.manage().window().maximize();
		driver.get("https://chedr.prometteur.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void testlogin()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("anil2@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=2)
	void getUsername()
	{
		driver.findElement(By.xpath("//img[@alt='Placeholder Image']")).click();
		String name =driver.findElement(By.xpath("//div[contains(text(),'Hello, ')]")).getText();
		System.out.println(name + " User has been logged in successfully ...");
	}
	
	
	@Test(priority=3)
	void testlogout()
	{
		//driver.findElement(By.xpath("(//img[@alt='Placeholder Image']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Log Out']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
	}
	
	@Test(priority=4)
	public void testquit()
	
	{
		driver.quit();		
	}
	
}
