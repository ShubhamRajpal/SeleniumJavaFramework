package TestDemos;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentwaitDemo {
	
	@Test
	public void SeleniumWait(){
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com");
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("ABCD");
		e.sendKeys(Keys.ENTER);
	
		
		//driver.findElement(By.linkText("ABCD - NIMH Data Archive")).click();
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(40))		
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);
		
			WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement link =  driver.findElement(By.xpath("//a/h3[contains(text(),'ABCD - NIMH Data Archive')]"));
				if(link.isEnabled()) {
					System.out.println("Element Found!");
					
				}
				return link;
			}
		});
			
			element.click();
	}
}
