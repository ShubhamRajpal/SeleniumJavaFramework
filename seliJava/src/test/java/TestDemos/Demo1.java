package TestDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import bsh.Capabilities;
import config.PropertiesFile;



public class Demo1 {
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	}
	
	static WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest myFirstTest;
	public static String browsername=null;
	@Test
	public void practoSearch() throws Exception {
		
	 htmlreporter = new ExtentHtmlReporter("extent.html");
	
	extent = new ExtentReports();
	extent.attachReporter(htmlreporter);
		
	 myFirstTest = extent.createTest("MyFirstTest","This is a test to open Practo Website");
	 
	 PropertiesFile.getProperties();
	if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","D:\\chromedriver.exe");
		driver = new FirefoxDriver();
	}
		
	
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	myFirstTest.log(Status.INFO, "Starting Test Case...");
	driver.get("https://www.practo.com/");
	myFirstTest.log(Status.PASS, "Opened URL successfully ");
	
	// To get the Title of the page
	String page = driver.getTitle();
	System.out.println("Page Title is: "+page);

	driver.findElement(By.linkText("Login / Signup")).click();
	
	Thread.sleep(500);
	
	driver.findElement(By.linkText("Register")).click();
	
	driver.findElement(By.id("name")).sendKeys("Megan Fox");
	WebElement code = driver.findElement(By.id("country"));
	Select ddcode = new Select(code);
	ddcode.selectByValue("IN");
	
	// To print the values of dropdown list.
		java.util.List<WebElement> l = ddcode.getOptions();
		System.out.println("Vales of DropDown is: ");
		for(WebElement i:l){
			System.out.println(i.getText());
		}
		
	driver.findElement(By.id("mobile")).sendKeys("8887751845");
	driver.findElement(By.id("password")).sendKeys("Meganfox@123");
	driver.findElement(By.xpath("//button[@id='EmailRegister']")).isDisplayed();
	
	
	}	
	@AfterTest
	public void teardown() {
		driver.close();
		PropertiesFile.setProperties();
		myFirstTest.log(Status.INFO,"Test Completed");
		
		extent.flush();
	}
	
}
