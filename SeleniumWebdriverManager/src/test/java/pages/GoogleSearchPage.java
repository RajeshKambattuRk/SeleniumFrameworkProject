package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private static WebElement element = null;
		
	public static WebElement textbox_Search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement close_callout_frame(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text() = 'Stay signed out']"));
		return element;
	}
	
	public static WebElement button_Search(WebDriver driver) {
		element = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
		return element;
	}
	
	
}
