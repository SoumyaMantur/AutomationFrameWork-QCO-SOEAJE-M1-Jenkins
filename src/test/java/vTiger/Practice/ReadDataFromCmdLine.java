package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void readData()
	{
		String BVALUE = System.getProperty("browser");
		System.out.println(BVALUE);
		
		String UVALUE = System.getProperty("url");
		System.out.println(UVALUE);
		
		String USVALUE = System.getProperty("username");
		System.out.println(USVALUE);
		
		String PVALUE = System.getProperty("password");
		System.out.println(PVALUE);
		
		
	}
	

}
