package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Demo_Log4J.Demo_Log4j;
import TestDemos.Demo1;

public class PropertiesFile {
	static Properties p= new Properties();
	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {
		try {
			
			InputStream ip = new FileInputStream("C:/Users/Shubham/Workspace1/seliJava/src/test/java/config/config.properties");
			p.load(ip);
			String browser = p.getProperty("browser");
			System.out.println(browser);
			Demo1.browsername=browser;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream op = new FileOutputStream("C:/Users/Shubham/Workspace1/seliJava/src/test/java/config/config.properties");
			p.setProperty("browser","chrome");
			p.setProperty("Result", "PASS");
			p.store(op,null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
