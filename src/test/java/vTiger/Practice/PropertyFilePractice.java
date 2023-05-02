package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1: Load the file into FileInput stream to make it java readable
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create an object of properties class from java.util
		Properties pobj=new Properties();
		
		//Step 3: Load the File input stream into properties
		pobj.load(fis);
		
		//Step 4: fetch the data using the key
		String BROWSER = pobj.getProperty("browser");
		System.out.println(BROWSER);
		String URL = pobj.getProperty("url");
		System.out.println(URL);
		

		
	}

}
