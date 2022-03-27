package TestDemos;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class TestNGIgnoreDemo {
	@Ignore
	@Test()
	public void test10(){
		System.out.println("I am inside Test10");
	}
	@Test()
	public void test11() {
		System.out.println("I am inside Test11");
	}
}
