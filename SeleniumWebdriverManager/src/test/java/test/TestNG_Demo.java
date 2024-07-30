package test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pages.GoogleSearchPage;

public class TestNG_Demo {
	
	static WebDriver driver = null;
	public static String broswerName = null;
	
	
	@BeforeTest
	public void setupTest (){
		PropertiesFile.getProperties();
		if(broswerName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(broswerName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
	}
	
	@Test
	public void googleSearch() throws InterruptedException {
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();		
		//switching frame
		driver.switchTo().frame("callout");
		Thread.sleep(1000);
		GoogleSearchPage.close_callout_frame(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		GoogleSearchPage.textbox_Search(driver).sendKeys("Automation Selenium");
		GoogleSearchPage.button_Search(driver).click();
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully..");
		PropertiesFile.setProperties();
	}
}

