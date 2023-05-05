package pil.automation.LMS;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BookingInquiry {
	
	 static WebDriver BookingInquiry;
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	  static FileOutputStream word;
	   static XWPFDocument document=new XWPFDocument();
	   static XWPFParagraph paragraph=document.createParagraph();
	   static XWPFRun run=paragraph.createRun();
	   static String failcase ="F90B21",passcase="006400",skipcase="F17107",header="000000";
	   static String ExpectedURL="http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS";
	   
	   
	 @Test
	public static void login() throws Exception {
		
		word=new FileOutputStream("D:\\Automation\\outputdocument"+ System.currentTimeMillis()+ ".docx");
        documentheading("QM Test Results: Test Execution");
        
		BookingInquiry=new ChromeDriver();
		BookingInquiry.manage().deleteAllCookies();
		BookingInquiry.manage().window().maximize();
		
		title("Test 1: Load LMS Webpage");
		BookingInquiry.get(input(0));
		Thread.sleep(2000);
		result("PASSED: Page loaded successfully.");
		
		title("Test 2: Login to LMS");
		WebElement UserID=BookingInquiry.findElement(By.id("j_username"));
		UserID.sendKeys(input(1));
		
		WebElement Password=BookingInquiry.findElement(By.id("j_password"));
		Password.sendKeys(input(2));
		
		
		  WebElement Login=BookingInquiry.findElement(By.xpath("//*[@id='login_form']/button"));
		  Login.click();
		  result("PASSED: Login Successful");
		  

		   WebElement dropdown=BookingInquiry.findElement(By.xpath("//*[@id=\"logout_form\"]/div/select")); 
			  Select officecode=new Select(dropdown); 
			  officecode.selectByVisibleText("SG00");
			  
			  Alert dropdownalert=alertmsg(); 
			  dropdownalert.accept();
			 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 1)
	 public static void Booking() throws Exception {
		 
	  String LMSwindow=BookingInquiry.getWindowHandle();
	          
			  WebElement Svcmgmt=BookingInquiry.findElement(By.xpath("//li[@class='gnb-svcMGMT']"));
			  Svcmgmt.click(); 
			  Thread.sleep(2000); 
			  
			  WebElement bkgdocumentation=BookingInquiry.findElement(By.xpath( "//*[@class='main-gnb']/ul/li[2]/ul/li[1]/a")); 
			  bkgdocumentation.click();
				
	 String bookingwindow=windowhandling();
		  
			  WebElement frame=BookingInquiry.findElement(By.id("gnb_frame"));
			  BookingInquiry.switchTo().frame(frame);
			  
			  
			  BookingInquiry.findElement(By.xpath("/html/body/div/ul[19]/li[3]")).click();
			  BookingInquiry.findElement(By.xpath("/html/body/div/ul[19]/li[3]/div/ul/li[1]")).click();
			  Thread.sleep(2000);
			  BookingInquiry.findElement(By.xpath("/html/body/div/ul[19]/li[3]/div/ul/li[1]/div/ul/li[1]/a/span")).click();
			  
			  		  
	  String BookingCreation=windowhandling();
			  
	          title("Test 3: Retrieve Booking");
			  WebElement frame1=BookingInquiry.findElement(By.id("t1frame"));
			  BookingInquiry.switchTo().frame(frame1);
			  
			  WebElement Bkgno=BookingInquiry.findElement(By.name("bkg_no"));
			  Bkgno.sendKeys(input(3));
			  
			  WebElement retrieve=BookingInquiry.findElement(By.id("btn_t1retrieve"));
			  retrieve.click();
			  
			  BookingInquiry.switchTo().defaultContent();
			  
			  result("Booking retrieve complete");
			  
			  WebElement BLpreview=BookingInquiry.findElement(By.id("btn_BLPreview"));
			  BLpreview.click();
			  
			
	String BLPreviewwindow=windowhandling();
	
			  title("Test 4: Generate & Print BL Pdf");
              
		BookingInquiry.manage().window().maximize();
		 Thread.sleep(2000);
		WebElement Allradiobutton=BookingInquiry.findElement(By.id("rdo_form_level1"));
		Allradiobutton.click();
		Thread.sleep(2000);
		
		/*
		 * WebElement Print=BookingInquiry.findElement(By.id("btn_Print"));
		 * Print.click(); Thread.sleep(2000); result("BL PDF screenshot:");
		 * 
		 * Robot robot=new Robot();
		 * 
		 * robot.keyPress(KeyEvent.VK_TAB); Thread.sleep(2000);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER);
		 * 
		 * Thread.sleep(2000);
		 */
	
	    WebElement emailbutton=BookingInquiry.findElement(By.id("btn_Email"));
	    emailbutton.click();
	    
	String Emailwindow=windowhandling();
	
	 title("Test 5: Send BL PDF via email");
	    BookingInquiry.manage().window().maximize();
	    Thread.sleep(2000);
	    WebElement Email=BookingInquiry.findElement(By.id("email"));
	  
	    Email.clear();
	    Thread.sleep(2000);
	    Email.sendKeys(input(4));
	    Thread.sleep(5000);
	    WebElement sendbutton=BookingInquiry.findElement(By.id("btn_send"));
	    sendbutton.click();
	    
	      Thread.sleep(3000) ;
		  Alert emailalert=alertmsg(); 
		  String actualmsg= emailalert.getText();
		  String expectedmsg= "E-mail was transmitted successfully.";
		  
		  if(actualmsg.equals(expectedmsg)) {
			  emailalert.accept();
			  run.setFontSize(16);
	    	    run.setFontFamily("Aparajita");
	    	    run.setColor(passcase);
	    	    run.setBold(true);
				run.setText(actualmsg);
				run.addCarriageReturn();
				run.addBreak();
		  }
		  else {
			  emailalert.accept();
		     run.setFontSize(16);
  	         run.setFontFamily("Aparajita");
  	         run.setColor(failcase);
  	         run.setBold(true);
			 run.setText(actualmsg);
			 run.addCarriageReturn();
			 run.addBreak();
			  
		  }
		 
		  
		  BookingInquiry.switchTo().window(BLPreviewwindow);		
		 
		  Thread.sleep(2000);
		 
		 int size=BookingInquiry.getWindowHandles().size();
		 System.out.println(size);
		 
		 for (int i = 0; i < size; i++) {
			
		 if(!LMSwindow.equals(windowhandling())) {
			 BookingInquiry.close();
		 }
		 }
		 
	    System.out.println("success");
	    
	 }
	 @Test(priority = 2)
	    public static void Location() throws Exception {
	    	
	    	Thread.sleep(2000);
	    	String LMSWindow=BookingInquiry.getWindowHandle();
	    	
	    	 WebElement Businesscommon=BookingInquiry.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/ul/li[7]/span"));
	    	 Businesscommon.click();
	    	 Thread.sleep(2000);
	    	 WebElement MDA=BookingInquiry.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/ul/li[7]/ul/li[1]/a"));
	    	 MDA.click();
	    	 
	   String MDAwindow=windowhandling();
	  
	    	 WebElement frame=BookingInquiry.findElement(By.id("gnb_frame"));
	    	 BookingInquiry.switchTo().frame(frame);
	    	 
	    	 BookingInquiry.findElement(By.xpath("/html/body/div/ul[33]/li[8]")).click();
	    	 BookingInquiry.findElement(By.xpath("/html/body/div/ul[33]/li[8]/div/ul/li[3]/a")).click();
	    	 Thread.sleep(2000);
	    	 
	    	 
	    //String Locationreportwindow=windowhandling();
	    
	        WebElement Locationcode=BookingInquiry.findElement(By.name("loc_cd"));
	        Locationcode.sendKeys("SGSIN");
	        
	        WebElement Downexeclbutton=BookingInquiry.findElement(By.id("btn_DownExcel"));
	        Downexeclbutton.click();
	        
	        Thread.sleep(2000);
	       Alert excelalert=alertmsg();
	       excelalert.accept(); 
	       
	       int size=BookingInquiry.getWindowHandles().size();
	       
	       for (int i = 0; i < size; i++) {
			
	    	   if(!LMSWindow.equals(windowhandling())) {
	    		   BookingInquiry.close();
	    	   }
	    	  
		}
	       
	     
	    }
	 
	 @AfterSuite
	 public static void windowclose() throws Exception {
		 BookingInquiry.quit();
	       document.write(word);
	 }
	

	static String windowhandling() {
		  Set<String> windows1=BookingInquiry.getWindowHandles(); 
		  for (String x :  windows1){ 
			  BookingInquiry.switchTo().window(x); 
			  }
		  
		  return BookingInquiry.getWindowHandle();
		  
	}
       static Alert alertmsg() {
    	   Alert alert=BookingInquiry.switchTo().alert();
 		  String alertmsg=alert.getText(); 
 		  System.out.println(alertmsg);
		return alert; 
       }
       
      
       static String input(int row) throws Exception {
    	   File excel=new File("D:\\testing\\automation\\InputDetails.xlsx");
    	   FileInputStream fis=new FileInputStream(excel);
    	   workbook=new XSSFWorkbook(fis);
    	   sheet=workbook.getSheet("Sheet1");
    	   
    	   return sheet.getRow(row).getCell(1).getStringCellValue(); 
       }
       
    
       static void documentheading(String heading) throws Exception {
    	  
    	   //XWPFRun title=paragraph.createRun();
    	   run.setBold(false);
    	   run.setFontSize(18);
    	   run.setFontFamily("Aparajita");
    	   run.setColor(header);
    	   run.setUnderline(UnderlinePatterns.SINGLE);
    	   run.setText(heading);
    	   run.addCarriageReturn();
    	   run.addBreak();
		   
    	   
       }
       

       static void title(String text) throws Exception {
    	   
    	   run.setBold(true);
    	   run.setFontSize(16);
    	   run.setFontFamily("Aparajita");
    	   run.setText(text);
    	   run.addCarriageReturn();
    	   run.addBreak();
   	    	
  
       }

       static void result(String result) throws Exception {
    	   
    	   if(erroralert()==false) {
    	      //XWPFRun pass=paragraph.createRun();
    	      run.setFontSize(16);
    	      run.setFontFamily("Aparajita");
    	      run.setColor(passcase);
    	      run.setBold(true);
    	      run.setText(result);
    	      run.addCarriageReturn();
    	      run.addBreak();
			
    	   }
    	   else{
    		   Alert alert=BookingInquiry.switchTo().alert();
    		   String unexpectedalert=alert.getText();
    		   alert.accept();
    		   //XWPFRun fail=paragraph.createRun();
    		   run.setFontSize(16);
    		   run.setFontFamily("Aparajita");
    		   run.setColor(failcase);
    		   run.addCarriageReturn();
    		   run.setText("FAILED: " + unexpectedalert);
    		   run.addBreak();
   
    	         
    	   }

       }
       
       static Boolean erroralert() {
    	   try {
			BookingInquiry.switchTo().alert();
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
    	   
       }
      
}
