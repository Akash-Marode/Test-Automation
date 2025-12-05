package sweep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class URLS {
	public static void main(String[] args) 
	{

		WebDriver driver = new ChromeDriver();
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		try {
			
			driver.get("http://103.175.163.92:8025");
			
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("letmein123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			 WebElement loginBtn = driver.findElement(By.linkText("Login"));
			    loginBtn.click();
			
			    
			    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement element = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@Placeholder,'youremail@domain.com')]")));
			    element.sendKeys("admin@yopmail.com ");

			    
			

		    // --- 2. Locate and fill the password field ---
		    WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		    passwordField.sendKeys("Admin@123"); // <-- replace with your password

		    // --- 3. Click the login button ---
		    WebElement loginBtn1 = driver.findElement(By.xpath("//button[@type='submit']"));
		    loginBtn.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			Actions actions = new Actions(driver);
			List<String> gameUrls = new ArrayList<>();

			
		
									
			// Get all game cards
			List<WebElement> gameCards = driver.findElements(By.xpath("//div[contains(@class,'game-card')]"));
			

			for (int i = 0; i < gameCards.size(); i++) {
				try {
					// Refetch game cards to avoid stale element
					WebElement gameCard = driver.findElements(By.xpath("//div[contains(@class,'game-card')]")).get(i);

					// Get game name
					WebElement img = gameCard.findElement(By.xpath(".//img[@alt]"));
					String gameName = img.getAttribute("alt").trim();

					// Hover to reveal Play button
					actions.moveToElement(gameCard).perform();

					// Wait until Play button is clickable
					WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(gameCard
							.findElement(By.xpath(".//button[contains(text(),'Play') or contains(text(),'PLAY')]"))));

					// Click Play button
					playBtn.click();

					// Wait until URL changes
					Thread.sleep(3000); // or use wait for URL change if needed
					String gameUrl = driver.getCurrentUrl();
					gameUrls.add(gameName + " --> " + gameUrl);

					// Navigate back and wait for page to reload
					driver.navigate().back();
					wait.until(ExpectedConditions
							.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'game')]")));
					
					
					// Click "Load More" until it disappears
					
					while (true) {
						try {
							WebElement loadMoreBtn = wait.until(ExpectedConditions
									.elementToBeClickable(By.xpath("//button[contains(text(), 'Load More')]")));
							loadMoreBtn.click();
							Thread.sleep(1000);
						} catch (Exception e) {
							break; // no more Load More
						}
					}

				} catch (Exception e) {
					System.out.println("❌ Could not get URL for game at index " + i);
				}
			}

			// Print all game URLs
			System.out.println("\nFound " + gameUrls.size() + " game URLs:");
			for (String url : gameUrls) {
				System.out.println(url);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
