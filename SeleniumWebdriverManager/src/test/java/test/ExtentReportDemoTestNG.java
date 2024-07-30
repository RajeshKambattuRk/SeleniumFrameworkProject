package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		//create extent reports and attach reporters
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@BeforeTest
	public void setUpTest() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws IOException {
		
		ExtentTest test = extent.createTest("Selenium Automation", "Page contains the Selenium Automation information");
		driver.get("https://www.google.com/");
		test.pass("Navigated to Google page");
		
		test.log(Status.INFO, "");
		test.info("");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() throws IOException {
		ExtentTest test = extent.createTest("Selenium Automation", "Page contains the Selenium Automation information");
		test.log(Status.INFO, "");
		test.info("");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
