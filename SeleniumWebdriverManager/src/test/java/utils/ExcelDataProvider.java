package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

//	public static void main(String[] args) {
//		String excelPath = "C:\\Users\\61093154\\eclipse-workspace\\SeleniumWebdriverManager\\excel\\data.xlsx";
//		testData(excelPath, "Sheet1");
//	}
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest (){
		PropertiesFile.getProperties();
		driver = new ChromeDriver();
		
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username+ "|" + password);
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);	
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData(){
		String excelPath = "C:\\Users\\61093154\\eclipse-workspace\\SeleniumWebdriverManager\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	
//	public static Object testData(String excelPath, String sheetName) {
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount= excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
	
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + "|");
				data[i-1][j]=cellData;
			}	
			//System.out.println();
		}
		return data;
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully..");
		PropertiesFile.setProperties();
	}
	
	
}
