package com.prestashops.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties configFile;

	static {

		try {
			String path = "configuration.properties";
			FileInputStream input = new FileInputStream(path);
			
			configFile = new Properties();
			configFile.load(input);
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String value = configFile.getProperty(key);
		return value;
	}
	

//	public static void main(String[] args) {
//		Properties prop = new Properties();
//		Properties prop2 = new Properties();
//
//		try {
//			FileInputStream fis = new FileInputStream("config.properties");
//			prop.load(fis);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(prop.getProperty("DC"));
//
//		try {
//			FileInputStream fis2 = new FileInputStream("config2.properties");
//			prop.load(fis2);
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
//
//	}

}
