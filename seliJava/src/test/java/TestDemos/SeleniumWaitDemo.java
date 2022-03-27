package TestDemos;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
WebDriver driver=null;
	@org.testng.annotations.Test
	public void SeleniumWait() {
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		
		driver.findElement(By.name("abcd")).click();
		
		
		
		driver.close();
		driver.quit();
		
	
	}
}
