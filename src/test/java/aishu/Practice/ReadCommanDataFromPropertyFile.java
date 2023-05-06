package aishu.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadCommanDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//load file into java stream
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\commonDataPropertiesFile");
		//create object for property file 
		Properties pobj = new Properties();
		 //load fileinput stream to property 
		pobj.load(fs);
		// load property file means use the key to read value
		String BROWSER = pobj.getProperty("Browser");
		System.out.println(BROWSER);
		String URL = pobj.getProperty("Url");
		System.out.println(URL);
		String USERNAME = pobj.getProperty("UserName");
		System.out.println(USERNAME);
		String PASSWORD = pobj.getProperty("Password");
		System.out.println(PASSWORD);
		
	}

}
