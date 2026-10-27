package alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertsdemo 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
		
		//simple alert 
		 driver.findElement(By.xpath("//button[@class='styled-click-button' and @id='alertexamples']")).click();
		 
	    Alert alert = driver.switchTo().alert();
	    
	    System.out.println("Text From First type of alert : " +alert.getText());
	    
	    alert.accept();
	    
	    driver.findElement(By.xpath("(//button[normalize-space()='Show confirm box'])[1]")).click();
	    
	    Alert alertTwo = driver.switchTo().alert();
	    
	    System.out.println("Text From Second type of alert : " +alertTwo.getText());
	    
	    alertTwo.accept();
	    
	    
	    driver.close();
	    
	    
	    
		 
	}

}
