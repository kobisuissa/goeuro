package com.goeuro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoEuroMain {
	
	private static final Logger logger = LoggerFactory.getLogger(GoEuroMain.class);

	static ApplicationContext context;
	static GoEuroAPIClient client;
	
	public static void main(String[] args) {
		 try {
			 validateCommandLineArgs(args);
			 
			 String queryString = extractQueryString(args);
			 
			 context = new ClassPathXmlApplicationContext("spring-context.xml");
			 client = (GoEuroAPIClient) context.getBean("goEuroAPIClient");
			 
			 logger.debug("Received the following query string: \"" + queryString + "\"");
			 
			 client.executeQuery(queryString);
			 
		 } catch (Exception e) {
			 logger.error(e.getMessage());
		 } finally {
			 cleanup();
		 }
	}

	private static String extractQueryString(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (String s : args) {
			sb.append(s).append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}

	private static void validateCommandLineArgs(String[] args) throws Exception {
		if (args == null || args.length == 0) {
			throw new Exception("At least 1 keyword should be specified for searching positions.");
		}
	}

	private static void cleanup() {
		context = null;
		client = null;
	}

}
