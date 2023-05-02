package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in Java readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create the workbook
		Workbook Wb = WorkbookFactory.create(fis);
		
		//Step 3: get the control of Sheet
		Sheet Sh = Wb.getSheet("Contacts");
		
		//Step 4: Create a Row
		Row Rw = Sh.createRow(10);
		
		//Step 5: Create a Cell
		Cell Ce = Rw.createCell(7);
		
		//Step 6: Set the Value into the Cell
		Ce.setCellValue("BatMan");
		
		//Step 7: Open the file in writable format
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: Write the data into workbook
		Wb.write(fos);
		
		//Step 9: Close the workbook
		Wb.close();
		System.out.println("Data added and workbook closed");
		

	}

}
