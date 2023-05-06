package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileLibrary {
/**
 * this method read data from excel sheet for the sheetname, rowno,cellno given by user
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelSheet(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantLibrary.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.getCell(cellnum);
		String val = ce.getStringCellValue();
		return val;
	}
	/**
	 * this method will count row total
	 * @param sheetnm
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetnm) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantLibrary.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetnm);
		int count = sh.getLastRowNum();
		return count;
	}
	
	/**
	 * this method will write data into excel sheet
	 * @param sheetnm
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetnm, int rownum, int cellnum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantLibrary.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetnm);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.createCell(cellnum);
		ce.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantLibrary.ExcelFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("data written succesfully");
	}
	/**
	 * this method read the all data from present the particular sheet
	 * @param sheetnm
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetnm) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream(IConstantLibrary.ExcelFilePath);
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetnm);
	int lastrow = sh.getLastRowNum();
	 int lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastrow][lastcell];
	
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
