package vTiger.GenericLibrary;
/**
 * this class will generate related to java
 * @author HP
 *
 */

import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	/**
	 * this method will get random number every execution
	 * @return
	 */
 
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(500);
		return value;
	}
	
	public String getSystemDate()
	{
		Date d = new Date();
		String val = d.toString();
		return val;
		
	}
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
        String[] dArr = d.toString().split(" ");
		String month = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3];
		
		String dateInFormat=date+" "+month+" "+year+"  "+time;
		return dateInFormat;
	}
}



















