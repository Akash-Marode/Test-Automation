package sweep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Logan {
	public static void main(String[] args) {
		// Set path to your ChromeDriver

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("http://103.175.163.92:8025/view-all-games?category=3"); // <-- replace with your site
			Thread.sleep(30000); // wait for page to load

			// Keep clicking "Load More" until it's gone
			while (true) {
				try {
					WebElement loadMoreBtn = driver.findElement(By.xpath("//button[contains(text(), 'Load More')]"));
					loadMoreBtn.click();
					Thread.sleep(2000); // wait for new games to load
				} catch (Exception e) {
					// No button found = reached the end
					break;
				}
			}

			// Now collect all <img alt="...">
			List<WebElement> images = driver.findElements(By.xpath("//img[@alt]"));

			List<String> gameNames = new ArrayList<>();
			for (WebElement img : images) {
				String altText = img.getAttribute("alt").trim();
				if (!altText.isEmpty()) {
					gameNames.add(altText);
				}
			}

			// Print results (with duplicates preserved)
			System.out.println("Found " + gameNames.size() + " games:");
			for (String name : gameNames) {
				System.out.println("- " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
