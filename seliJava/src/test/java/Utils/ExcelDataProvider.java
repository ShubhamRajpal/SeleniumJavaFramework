package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
WebDriver driver=null;
	
	@BeforeTest
	public void setup() {
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("Webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Test(dataProvider="test1data")
	public void test1 (String username,String password) throws Exception {
		System.out.println(username+"|"+password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);

	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelpath = "C:\\Users\\Shubham\\Workspace1\\seliJava\\Excel\\data.xlsx";
		Object data[][] = testData(excelpath, "Sheet1");
		
		return data;
	}
	
	public static Object[][] testData(String excelpath,String Sheetname) {
		
		ExcelUtils ex1 = new ExcelUtils(excelpath,Sheetname);
		
		int rowCount = ex1.getRowCount();
		int colCount = ex1.getColCount();
		
		
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String Celldata = ex1.getCellDataString(i, j);
//				System.out.print(Celldata+ " |");
				data[i-1][j] = Celldata;
				}
//			System.out.println();
		}
		
		return data;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}
