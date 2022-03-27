package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenersDemo {
	WebDriver driver=null;


	@Test(priority=-1)
	public void test1() {
		System.out.println("I am inside Test1");
	}
	@Test(priority=-1)
	public void test2() {
		System.out.println("I am inside Test2");
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txPassword")).sendKeys("Admin1");
		driver.close();
	}
	@Test(priority=1)
	public void test3() {
		System.out.println("I am inside Test2");
		throw new SkipException("This Test is skipped");
	}
}
