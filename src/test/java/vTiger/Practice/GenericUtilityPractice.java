package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jutil=new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jutil.getSystemdate());
		
		System.out.println(jutil.getSystemDateinFormat());
		
		PropertyFileUtility putil = new PropertyFileUtility();
		String value1 = putil.readDatafromPropertyFile("browser");
		System.out.println(value1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDatafromExcel("Organizations", 1, 2);
		System.out.println(data);
		
	    eUtil.writeDataIntoExcel("HI", 5, 6, "SpiderMan");
		System.out.println("Data Added");

	}

}
