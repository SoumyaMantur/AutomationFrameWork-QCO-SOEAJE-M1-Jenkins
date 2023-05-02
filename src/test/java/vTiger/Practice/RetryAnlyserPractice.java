package vTiger.Practice;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class RetryAnlyserPractice {
	
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementationClass.class)
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("HI");
	}
	


}
