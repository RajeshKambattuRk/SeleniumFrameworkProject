package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Logged Details...");	
		
		logger.trace("This is trace message");
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is warning message");
		logger.fatal("This is fatal message");
		
		System.out.println("Completed");

	}

}
