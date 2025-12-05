

package loginAndLogout;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class LoganSweep {
 
	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 
		
		driver.manage().window().maximize();
		
		driver.get("http://103.175.163.92:8025");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("letmein123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
 
		
		driver.findElement(By.xpath("//*[ starts-with(@class,'login-link')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='youremail@domain.com']")).sendKeys("akashtest@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='*****']")).sendKeys("Pass@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//div[@class='user-profile-container']")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		
		
		driver.quit();
	}
 
}
 
