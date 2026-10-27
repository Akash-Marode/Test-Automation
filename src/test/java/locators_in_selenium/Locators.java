package locators_in_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) 
	{
		
		// Launch a Browser
		WebDriver driver = new ChromeDriver();
		
		// Open URL or site 
		driver.get("https://taalhealthcare.com/");
		
		// First Locator is "name" so
		driver.findElement(By.name("s")).sendKeys("Spegra"); // This is Single Lined Step..
		System.out.println("Test 1");
		// Another Step is 
		/*     WebElement searchBox = driver.findElement(By.name("s"));
			   searchBox.sendKeys("Spegra");
		*/
		
		// Second Locator is id.
		/*For Example we need to find that Logo of website is present or not then we can use "id Locator"  */
		System.out.println("Test 2");
		WebElement menubar =   driver.findElement(By.id("menu-active-top-header"));
		
		/* in One Step is like  =  driver.findElement(By.id("menu-active-top-header")).isDisplayed();*/
		
		boolean status = menubar.isDisplayed();
		System.out.println("Menubar Displayed is : "+ status);
		
		/* Now linkText Locator*/ 
		
	//	driver.findElement(By.linkText("Pharmacy")).click();   // partialLinkText is used for only some part of link names e.g for Google = goo, gle,ogl.
		System.out.println("Test 3 Passed");
		
		// Now For className Locator = this is used when we have to find group of elements having same class name 
		
		List <WebElement> navLinks = driver.findElements(By.className("ekit-menu-nav-link"));
		System.out.println("Number of nave bar links Test 4");
		System.out.println(navLinks.size());
		
		
		// Now TagName Locator
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of Totle links Test 5");
		System.out.println(allLinks.size());
		
		List <WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of Totle Images Test 6");
		System.out.println(images.size());
		
		
		// for Practice  
		// only using Linktext Locator
		System.out.println("Test 7 for practice");
		driver.findElement(By.linkText("Viropil Tablet")).click();
		System.out.println("Test 7 Passed");

	}

}
