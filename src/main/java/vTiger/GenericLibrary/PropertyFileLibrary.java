package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantLibrary.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

	
}
