package action_class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo 
{
	public static void main (String [] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/?utm_source=chatgpt.com");
		
		Actions act = new Actions(driver);
		
		WebElement practicebutton = driver.findElement(By.xpath("//button[contains(text(),'Practice')]"));
		
		act.doubleClick(practicebutton).build().perform();   //<<<<<<------------Double click method
		System.out.println("Double click test Passed !.");
		
		WebElement mousehoverbutton = driver.findElement(By.xpath("//button[@id='mousehover']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", mousehoverbutton);
		
		act.moveToElement(mousehoverbutton).build().perform();  //<<<<<------ hover action completed.
		System.out.println("Hover action Performed");
		
		driver.navigate().to("https://jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement leftSlider = driver.findElement(By.xpath("//span[@tabindex='0'][1]"));
		WebElement rightSlider = driver.findElement(By.xpath("//span[@tabindex='0'][2]"));
		
		System.out.println("Default location of Left Slider: "+ leftSlider.getLocation());
		
		act.dragAndDropBy(leftSlider, 160, 249).build().perform();
		System.out.println("After Moving location of Left Slider: "+ leftSlider.getLocation());
		
		System.out.println("Default location of Right Slider: "+ rightSlider.getLocation());
		act.dragAndDropBy(rightSlider, -150, 249).build().perform();
		
		System.out.println("After location of Right Slider: "+ rightSlider.getLocation());
		
	
		
		driver.quit();
		
		
	}
}
