package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	WebDriver driver;
	
	@Test
	public void test1() {
		System.out.println("Inside Test 1");
	}
	@Test
	public void test2() {
		System.out.println("Inside Test 2");
//		Assert.assertTrue(false);
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd"); //test will fail 
		driver.close();
	}
	@Test
	public void test3() {
		System.out.println("Inside Test 3");
		throw new SkipException("Test is skipped");
	}
}
