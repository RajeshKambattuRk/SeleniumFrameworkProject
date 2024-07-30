package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	static WebDriver driver = null;
	
	public static void main(String args[]) throws InterruptedException {
		
		googleSearch();
	}
	
	public static void googleSearch() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
//		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		//switching frame
		driver.switchTo().frame("callout");
		GoogleSearchPage.close_callout_frame(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		GoogleSearchPage.textbox_Search(driver).sendKeys("Automation Selenium");
		GoogleSearchPage.button_Search(driver).sendKeys(Keys.RETURN);
		
		driver.close();
		
	}
}
