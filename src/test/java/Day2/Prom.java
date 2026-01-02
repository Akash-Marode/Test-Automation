package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prom {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();  // Opens Chrome 
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");   // Opens Url
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Water Bottle");
		
		driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();
		
		//driver.findElement(By.xpath("//div[@xpath='1']/parent::label")).click();   NO Such element.
		
		
		     String foo =  driver.getWindowHandle();
		
		driver.quit();
	}

}
