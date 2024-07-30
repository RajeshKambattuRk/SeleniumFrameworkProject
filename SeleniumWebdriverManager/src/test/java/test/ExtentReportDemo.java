package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPage;

public class ExtentReportDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
	
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreports.html");
		//create extent reports and attach reporters
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test, adds all logs event under it
		ExtentTest test = extent.createTest("Selenium Automation", "Page contains the Selenium Automation information");
		
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting Test case");
		
		driver.get("https://www.google.com/");
		test.pass("Navigated to Google.com");
		
		driver.manage().window().maximize();		
		//switching frame
		driver.switchTo().frame("callout");
		Thread.sleep(1000);
		GoogleSearchPage.close_callout_frame(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).sendKeys("Automation Script");
		test.pass("Enter text in search box");
//		driver.findElement(By.name("btnk")).click();
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();
		test.pass("Pressed keyboard Enter key");
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		test.pass("close the browser");
		test.info("Testing is completed");
		
		//flushing the report
		extent.flush();
		
		
		
	}

}
