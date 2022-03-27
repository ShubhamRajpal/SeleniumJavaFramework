package TestDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Demo3 {

	static WebDriver driver;
	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {
		System.out.println("BrowserName:"+browsername);
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);

		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void GoogleSearch3() throws Exception {



		driver.manage().window().maximize();

		driver.get("https://google.com/");

		// To get the Title of the page
		String page = driver.getTitle();
		System.out.println("Page Title is: "+page);


		WebElement m = driver.findElement(By.name("q"));
		m.sendKeys("Gmail");
		m.sendKeys(Keys.RETURN);


		driver.close();
		driver.quit();
	}	
}
