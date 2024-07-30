package config;

import java.util.Properties;

import test.TestNG_Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	static String filePath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}
	public static void getProperties() {
		
		try {
			prop = new Properties();
			InputStream input = new FileInputStream(filePath + "/src/test/java/config/config.properties");
			prop.load(input);
			String browserName = prop.getProperty("browser");
			System.out.println(browserName);
			TestNG_Demo.broswerName = browserName;
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}
	
	public static void setProperties(){
		try {
			OutputStream output = new FileOutputStream(filePath+"/src/test/java/config/config.properties");
//			prop.setProperty("browser", "firefox");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}

}
