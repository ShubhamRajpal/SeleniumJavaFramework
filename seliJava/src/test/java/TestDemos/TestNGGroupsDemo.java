package TestDemos;

import org.testng.SkipException;
import org.testng.annotations.Test;
//@Test(groups= {"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("I am inside Test1");
	}
	@Test(groups= {"sanity","smoke"})
	public void test2() {
		System.out.println("I am inside Test2");
	}
	@Test(groups= {"Regression"})
	public void test3() {
		System.out.println("I am inside Test3");
	}

	@Test
	public void test4() {
		System.out.println("I am inside Test4");
	}
}
