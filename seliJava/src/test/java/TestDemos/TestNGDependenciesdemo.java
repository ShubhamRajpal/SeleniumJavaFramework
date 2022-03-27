package TestDemos;

import org.testng.annotations.Test;

public class TestNGDependenciesdemo {

//	@Test(dependsOnGroups= {"sanity.*"})
//	public void test1() {
//		System.out.println("I am inside Test1");
//	}
//	@Test(groups= {"sanity1"})
//	public void test2() {
//		System.out.println("I am inside Test2");
//	}
//	@Test(groups= {"sanity2"})
//	public void test3() {
//		System.out.println("I am inside Test3");
//	}

	
	@Test(dependsOnMethods= {"test8"},priority=1)
	public void test7(){
		System.out.println("I am inside Test7");
	}
	@Test(priority=2)
	public void test8() {
		System.out.println("I am inside Test8");
	}
	@Test()
	public void test9() {
		System.out.println("I am inside Test9");
	}
}
