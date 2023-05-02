package vTiger.Practice;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void assertPractice()
	{
		SoftAssert SA = new SoftAssert();
		
		System.out.println("Step 1");
		Assert.assertEquals("hi", "hello"); //passed
		
		System.out.println("Step 2");
	    SA.assertEquals(1, 0);//failed
	    
		System.out.println("Step 3");
		SA.assertTrue(false);//failed
		
		System.out.println("Step 4");
		SA.assertAll(); //log all the assertion failures
	}
	
	@Test
	public void Practice()
	{
		System.out.println("Second Script Step 1");
		Assert.assertEquals(true, true);
		System.out.println("Second Script Step 2");
	}

}
