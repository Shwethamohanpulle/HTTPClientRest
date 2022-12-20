package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public static FileInputStream fis;
	
	public TestBase () {
		prop = new Properties();
	 //FileInputStream fis;
		try {
			fis = new FileInputStream ("/Users/shwethamohanpulle/Documents/Projects/HackathonAPI/HTTPClient/src/main/java/com/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
