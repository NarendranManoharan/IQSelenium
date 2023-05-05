package pil.automation.LMS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginpageUsingJAVA {
	WebDriver driver;
	static List<String> usernamelist=new ArrayList<String>();
	static List<String> passwordlist=new ArrayList<String>();
	
	@DataProvider(name = "throughexcel")
	 public static String[][] dataprovider() throws Exception{
		//String[][] data=readexcel();
			return null;
	    	
	    }
	
	public static void readexcel() throws Exception {
		File excel=new File("D:\\testing\\Automation\\InputDetails.xlsx");
	     FileInputStream fis =new FileInputStream(excel);
	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
	     XSSFSheet sheet=workbook.getSheet("Sheet2");
	     
	     Iterator<Row> rowiterator= sheet.iterator();
	     while(rowiterator.hasNext()) {
	    	 Row rowvalue=rowiterator.next();
	    	 Iterator<Cell> Celliterator= rowvalue.iterator();
	    	 int i=4;
	    	 while(Celliterator.hasNext()) {
	    		Cell cellvalue= Celliterator.next();
	            
	            if(i%2==0) {
                usernamelist.add(cellvalue.toString());
	            }
	            else {
	            	passwordlist.add(cellvalue.toString());
	            }
	            i++;
	    	 }
	    	
	     }
	     System.out.println(usernamelist);
	     System.out.println(passwordlist);
	 
	}
	
/*	public void executeTEST() {
		
		for (int i = 0; i <usernamelist.size()-1; i++) {
			login(usernamelist.get(i+1), passwordlist.get(i+1));
		}
	}
	
	*/
	
	@Test(dataProvider = "throughexcel")
	public void login(String name, String pass) {
		for (int i = 0; i <usernamelist.size()-1; i++) {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://lmstest.pilship.com/opuscntr/MainPage.do");
		
		driver.findElement(By.id("j_username")).sendKeys(usernamelist.get(i+1));
		driver.findElement(By.id("j_password")).sendKeys(passwordlist.get(i+1));
		driver.findElement(By.xpath("//*[@type='button']")).click();
		driver.quit();
	}
	}

}
