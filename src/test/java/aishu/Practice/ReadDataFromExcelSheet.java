package aishu.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//read the file and load file into excel sheet
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		// create a workbook 
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Contact");
        Row rw = sh.getRow(1);
        Cell ce = rw.getCell(1);
        String val = ce.getStringCellValue();
        System.out.println(val);
	}

}
