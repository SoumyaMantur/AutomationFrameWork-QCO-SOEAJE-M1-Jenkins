package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void CreateUser()
	{
		Assert.fail();
		System.out.println("CreateUser");
	}
	
	@Test (dependsOnMethods = "CreateUser")
	public void ModifyUser()
	{
		System.out.println("modifyUser");
	}
	
	@Test(enabled = false)
	public void DeleteUser()
	{
		System.out.println("DeleteUser");
	}


}
