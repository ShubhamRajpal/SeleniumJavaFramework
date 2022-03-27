package TestDemos;

import org.testng.SkipException;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGFailedRetryDemo {

	@Test
	public void test14() {
		System.out.println("I am inside Test14");
	}
	@Test
	public void test15() {
		System.out.println("I am inside Test15");
		//int i=1/0;
	}
	@Test(retryAnalyzer=listeners.RetryAnalyzer.class)
	public void test16() {
		System.out.println("I am inside Test16");
		
		Assert.assertTrue(0>1);
	}
}
