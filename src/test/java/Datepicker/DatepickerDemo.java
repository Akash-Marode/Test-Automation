package Datepicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatepickerDemo {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://stg.admin.ftimerbet.com/login");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("akashadmin@yopmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("AkashAdmin@123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Casino Transactions')]")).click();
		driver.findElement(By.xpath("(//button[@aria-label='Choose date'])[1]")).click();
		
		
		
		while(true)
		{
			String monthandYear1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader-label css-8633fn')]"))).getText();
			
			if(monthandYear1.equals("December 2025"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//button[@title='Previous month']")).click();
			}
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'23')]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-15ni0jc')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'24')]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium form-btn-icon')])[1]")).click();
		
		
		
		driver.quit();
		System.out.println("Bye");
	}

}
