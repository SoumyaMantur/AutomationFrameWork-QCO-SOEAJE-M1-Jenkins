package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in Java readable format using fileinputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create A Workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get the control of sheet
		Sheet Sh = wb.getSheet("Organizations");
		
		//Step 4: get the control of Row
		Row Rw = Sh.getRow(1);
		
		//Step 5: get the control of Cell
		Cell Ce = Rw.getCell(2);
		
		//Step 6: read the data inside the cell
		String Value = Ce.getStringCellValue();
		System.out.println(Value);
	}

}
