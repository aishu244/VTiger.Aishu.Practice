package aishu.Practice;

import java.io.IOException;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException {
		JavaLibrary jlib=new JavaLibrary();
		int rno = jlib.getRandomNumber();
		System.out.println(rno);
		
		JavaLibrary jlib1 = new JavaLibrary();
		String date = jlib1.getSystemDate();
		System.out.println(date);
		
		JavaLibrary jlibb=new JavaLibrary();
		String format = jlibb.getSystemDateInFormat();
		System.out.println(format);
		
		PropertyFileLibrary  plib = new PropertyFileLibrary();
		String read = plib.readDataFromPropertyFile("Browser");
		System.out.println(read);
		
		ExcelFileLibrary elib=new ExcelFileLibrary();
		String read1 = elib.readDataFromExcelSheet("Organization", 1, 2);
		System.out.println(read1);
		
		int cont = elib.getRowCount("Contact");
		System.out.println(cont);
		elib.writeDataIntoExcel("Contact", 5, 7, "VtigerPractice");
		
		
		
	}


}
