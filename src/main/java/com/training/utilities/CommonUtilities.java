package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;
import static com.training.utilities.Constants.FILE_SEPARATOR;

public class CommonUtilities {
	
	public String getproperty(String key) throws IOException {
			
	//	String spath = "C:\\Users\\guruk\\eclipse-workspace\\TestNGSalesforceFrameWork\\properties\\application.properties";
		
		String spath = USER_DIR+FILE_SEPARATOR+APPLICATION_PROPERTIES;   //filepath
		FileInputStream fileput = new FileInputStream(spath); //fileInputStream
		Properties prop = new Properties();
		prop.load(fileput);
		String value = prop.getProperty(key);
		return value;
	}
	
	
	

}
