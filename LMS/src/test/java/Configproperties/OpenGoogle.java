package Configproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.util.Properties;

public class OpenGoogle {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fileInputStream=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		String browser=properties.getProperty("browser");
		String driverlocation=properties.getProperty("DriverLocation");

          System.out.println(browser + " "+  driverlocation);
		
	}
         
}
