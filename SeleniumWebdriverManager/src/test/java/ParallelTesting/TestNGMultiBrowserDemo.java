package ParallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser name: "+browserName);
		System.out.println("Thread Id : "+Thread.currentThread().getId());
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	}
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfully");
	}
	
}
