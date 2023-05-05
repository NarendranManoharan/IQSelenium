package pil.automation.LMS;
	import java.awt.AWTException;
	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
	import java.util.Iterator;
	import java.util.Set;

	import javax.imageio.ImageIO;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.util.Units;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.apache.poi.xwpf.usermodel.Document;
	import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
	import org.apache.poi.xwpf.usermodel.XWPFDocument;
	import org.apache.poi.xwpf.usermodel.XWPFParagraph;
	import org.apache.poi.xwpf.usermodel.XWPFRun;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class LMSproject {
		static ChromeDriver BookingInquiry;
		static XSSFSheet sheet1;
		static XSSFSheet sheet2; 
		static XSSFSheet sheet3;
		static FileOutputStream word;
		static XWPFDocument document;
		static XWPFParagraph paragraph;
		 static XWPFRun title;
		static String failcase ="F90B21",passcase="006400",skipcase="F17107",header="000000";
	
		 public static void main(String[] args) throws Exception{

			Date d=new Date();
			 SimpleDateFormat sdate=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
			 String date=sdate.format(d);
			 System.out.println(date);
			File excel = new File("D:\\testing\\Automation\\InputDetails.xlsx");
			FileInputStream fis = new FileInputStream(excel);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet1 = workbook.getSheetAt(0);  

			 word = new FileOutputStream("D:\\testing\\Automation\\OutputDocument"+System.currentTimeMillis()+ ".docx");
			  document = new XWPFDocument(); 
			 paragraph = document.createParagraph();
			title = paragraph.createRun();
			    title.setBold(false);
				title.setFontSize(18);
				title.setFontFamily("Aparajita");
				title.setUnderline(UnderlinePatterns.SINGLE);
				title.setText("QM Test Results: Test Execution Date -"+date);
				title.addCarriageReturn();
				title.addBreak();
			
					BookingInquiry=new ChromeDriver();
					BookingInquiry.manage().deleteAllCookies();
					BookingInquiry.manage().window().maximize();
					

					BookingInquiry.get("D:\\testing\\Automation\\frontpage.html");
					WebDriverWait wait = new WebDriverWait(BookingInquiry, Duration.ofSeconds(50000));
					wait.until(ExpectedConditions.alertIsPresent());
					Thread.sleep(2000);
					BookingInquiry.switchTo().alert().accept();
					
					String LMSPAGE=BookingInquiry.getWindowHandle();
					BookingInquiry.switchTo().window(LMSPAGE);
					
					
					XWPFRun tc1=paragraph.createRun();
					tc1.setBold(true);
					tc1.setFontSize(16);
					tc1.setFontFamily("Aparajita");
					tc1.setText("Test 1: Load LMS Webpage");
					tc1.addCarriageReturn();
					 

				//tc1.Load LMS page	
					
					String CurrentURL=BookingInquiry.getCurrentUrl();
					System.out.println(CurrentURL);
					String ExpectedURL="http://lmstest.pilship.com/opuscntr/SignOn.do";

					if(CurrentURL.equals(ExpectedURL))
					{
						XWPFRun tc1line=paragraph.createRun();
						tc1line.setFontSize(16);
						tc1line.setFontFamily("Aparajita");
						tc1line.setColor(passcase);
						tc1line.setBold(true);
						tc1line.setText("PASSED: Page loaded successfully.");
						tc1line.addCarriageReturn();
						tc1line.addBreak();
						 BufferedImage LmsWebpage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					      String lmsfile="D:\\testing\\Automation\\screenshot\\LMSWebpage" + System.currentTimeMillis() + ".jpg";
					      File Loginpage=new File(lmsfile);
					      ImageIO.write(LmsWebpage, "jpg", Loginpage);
					      FileInputStream LMSpic=new FileInputStream(Loginpage);
					      String Login=Loginpage.toString();
					      tc1line.addPicture(LMSpic, XWPFDocument.PICTURE_TYPE_JPEG, Login, Units.toEMU(400), Units.toEMU(250));
						  Thread.sleep(3000);
						  
						  
				 //tc2.Login to LMS	
						  
						XWPFRun tc2=paragraph.createRun();
						tc2.setFontSize(16);
						tc2.setFontFamily("Aparajita");
						tc2.setBold(true);
						tc2.setColor(header);
						tc2.addCarriageReturn();
						tc2.addBreak();
						tc2.setText("Test 2: Login to LMS");
						tc2.addCarriageReturn();

		
					BookingInquiry.findElement(By.id("j_username")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
					BookingInquiry.findElement(By.id("j_password")).sendKeys(sheet1.getRow(2).getCell(1).getStringCellValue());
					BookingInquiry.findElement(By.xpath("//*[@type='button']")).click();
					Thread.sleep(2000);

					if(isalertpresent()==true)
					{
						XWPFRun tc2line=paragraph.createRun();
						tc2line.setFontSize(16);
						tc2line.setFontFamily("Aparajita");
						tc2line.setColor(passcase);
						tc2line.setBold(true);
						tc2line.setText("PASSED: Login Successful.");
						tc2line.addCarriageReturn();
						tc2line.addBreak();
					
					Select dropdown =new Select(BookingInquiry.findElement(By.xpath("//select[@name='s_usr_chg_ofc_cd']")));
					dropdown.selectByVisibleText("SG00");
					Alert alert=BookingInquiry.switchTo().alert();
					alert.accept();
		
				      Thread.sleep(5000);
					 BufferedImage Homepage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				      String Homepagefile="D:\\testing\\Automation\\screenshot\\Homepage" + System.currentTimeMillis() + ".jpg";
				      File Homepageloc=new File(Homepagefile);
				      ImageIO.write(Homepage, "jpg", Homepageloc);
				      FileInputStream Homepagepic=new FileInputStream(Homepageloc);
				      String Home=Homepageloc.toString();
				      tc2line.addPicture(Homepagepic, XWPFDocument.PICTURE_TYPE_JPEG, Home, Units.toEMU(400), Units.toEMU(250));
				      Thread.sleep(3000);
					String mainPage =BookingInquiry.getWindowHandle();
					BookingInquiry.findElement(By.xpath("//li[@class='gnb-svcMGMT']")).click();
					Thread.sleep(1000);
					BookingInquiry.findElement(By.xpath("//a[@href='/opuscntr/opusMainTobe.do?parentPgmNo=ESM_BKG_M001']")).click();
					Thread.sleep(2000);
					Set<String> ss=BookingInquiry.getWindowHandles();
					Iterator<String> itr=ss.iterator();
					String a=itr.next();
					String b=itr.next();
					BookingInquiry.switchTo().window(b);
					BookingInquiry.switchTo().frame(BookingInquiry.findElement(By.id("gnb_frame")));
					String BookingScreen=BookingInquiry.getWindowHandle();
					BookingInquiry.findElement(By.xpath("//li[@pgmno='ESM_BKG_M019']")).click();
					Thread.sleep(2000);
					BookingInquiry.findElement(By.xpath("//li[@pgmno='ESM_BKG_M020']")).click();
					Thread.sleep(2000);
					BookingInquiry.findElement(By.xpath("//li[@pgmno='ESM_BKG_0079_Q']")).click();
					Thread.sleep(2000);
					WebElement frame=BookingInquiry.findElement(By.id("t1frame"));
					BookingInquiry.switchTo().frame(frame);
					Thread.sleep(2000);
					
					
		     //tc3.Retrieve Booking
					XWPFRun tc3=paragraph.createRun();
					tc3.setFontSize(16);
					tc3.setFontFamily("Aparajita");
					tc3.setBold(true);
					tc3.addCarriageReturn();
					tc3.addBreak();
					tc3.setColor(header);
					tc3.setText("Test 3: Retrieve Booking");
					tc3.addCarriageReturn();
					tc3.addBreak();	
					BookingInquiry.findElement(By.xpath("//input[@name='bkg_no'][@type='text']")).sendKeys(sheet1.getRow(3).getCell(1).getStringCellValue());
					Thread.sleep(2000);
		             
					BookingInquiry.findElement(By.id("btn_t1retrieve")).click();
					
					
					Thread.sleep(2000);
					if(isalertpresent()==true)
					{
						XWPFRun tc3pass=paragraph.createRun();
						tc3pass.setFontSize(16);
						tc3pass.setFontFamily("Aparajita");
						tc3pass.setColor(passcase);
						tc3pass.setBold(true);
						tc3pass.setText("Booking retrieve complete.");
						tc3pass.addCarriageReturn();
						tc3pass.addBreak();
					 
					BufferedImage Bookingimg=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					File DestfileBooking=new File("D:\\testing\\Automation\\screenshot\\Booking" + System.currentTimeMillis() + ".jpg");
					ImageIO.write(Bookingimg, "jpg", DestfileBooking);
					FileInputStream Booking=new FileInputStream(DestfileBooking);
					String BookingLoc=DestfileBooking.toString();
					tc3pass.addPicture(Booking, XWPFDocument.PICTURE_TYPE_JPEG, BookingLoc, Units.toEMU(400), Units.toEMU(250));
					Thread.sleep(2000);
					
					
		     //tc.4 Generate & Print BL Pdf
					XWPFRun tc4=paragraph.createRun();
					tc4.setFontSize(16);
					tc4.setFontFamily("Aparajita");
					tc4.setBold(true);
					tc4.setColor(header);
					tc4.addCarriageReturn();
					tc4.addBreak();
					tc4.setText("Test 4: Generate & Print BL Pdf");
					tc4.addCarriageReturn();
					tc4.addBreak();	
					BookingInquiry.switchTo().defaultContent();
					BookingInquiry.findElement(By.id("btn_BLPreview")).click();
					Thread.sleep(2000);
						 
					
					
					
					if(isalertpresent()==true)
					{
					 
					Set<String> windowNewTab=BookingInquiry.getWindowHandles();
					
					for(String x : windowNewTab)
					{
						if(!mainPage.equals(x) && !BookingScreen.equals(x))
						{
						BookingInquiry.switchTo().window(x);
						}
						}
			    		
			    		   Thread.sleep(2000);
			    		  String BLPreview=BookingInquiry.getWindowHandle();
			    		  BookingInquiry.manage().window().maximize();
			    		 
			    		   BookingInquiry.findElement(By.id("rdo_form_level1")).click();	
			    		   Thread.sleep(2000);
					BookingInquiry.findElement(By.id("btn_Print")).click();
					Thread.sleep(10000);
					Rectangle BLscreenshot=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					 BufferedImage BLPrintscreenshot = new Robot().createScreenCapture(BLscreenshot);
					 String imgfile="D:\\testing\\Automation\\screenshot\\BLPrint"+System.currentTimeMillis()+".jpg";
					 File DestFile=new File(imgfile);
					 ImageIO.write(BLPrintscreenshot, "jpg", DestFile);
					   XWPFRun tc4line=paragraph.createRun();
					   tc4line.setBold(true);
					   tc4line.setColor(passcase);
					   tc4line.setFontFamily("Aparajita");
					   tc4line.setFontSize(16);
					   tc4line.setText("BL PDF screenshot:");
					   
				      FileInputStream Blprintpic = new FileInputStream(DestFile);
				      String BLprintLocation=DestFile.toString();
				      tc4line.addPicture(Blprintpic, XWPFDocument.PICTURE_TYPE_JPEG, BLprintLocation, Units.toEMU(400), Units.toEMU(250));
				      tc4line.addCarriageReturn();
				      tc4line.addBreak();	
		     
		            
					 StringSelection fileLocation = new StringSelection("D:\\testing\\Automation\\BLPrintPdf\\BLPrint"+System.currentTimeMillis()+".pdf");
				     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileLocation, null);
				     Thread.sleep(2000);

				    Robot robot = new Robot();
				     robot.delay(2000);
				     robot.keyPress(KeyEvent.VK_ENTER);
				     robot.keyRelease(KeyEvent.VK_ENTER);
				     robot.delay(2000);
				     robot.keyPress(KeyEvent.VK_CONTROL);
				     robot.keyPress(KeyEvent.VK_V);	     
			         robot.keyRelease(KeyEvent.VK_V);
			         robot.keyRelease(KeyEvent.VK_CONTROL);
			         robot.delay(2000);
			         robot.keyPress(KeyEvent.VK_ENTER);
			         robot.keyRelease(KeyEvent.VK_ENTER);
			         Thread.sleep(2000);
			         BookingInquiry.manage().window().maximize();
			         BookingInquiry.findElement(By.id("btn_Email")).click();
			         Thread.sleep(2000);
			         Set<String> windowNewTab1=BookingInquiry.getWindowHandles();
						
						for(String x : windowNewTab1) {
							if(!mainPage.equals(x) && !BookingScreen.equals(x) && !BLPreview.equals(x))
							{
							BookingInquiry.switchTo().window(x);
							}
						}
						
						Thread.sleep(2000);
						BookingInquiry.manage().window().maximize();
						Thread.sleep(2000);
					
						
						
			  //tc5.Send BL PDF via email
						XWPFRun tc5=paragraph.createRun();
						tc5.setFontSize(16);
						tc5.setFontFamily("Aparajita");
						tc5.setBold(true);
						tc5.setColor(header);
						tc5.addCarriageReturn();
						tc5.setText("Test 5: Send BL PDF via email");
						tc5.addCarriageReturn();
						tc5.addBreak();	
						BookingInquiry.findElement(By.id("email")).clear();
						Thread.sleep(2000);
			            BookingInquiry.findElement(By.id("email")).sendKeys(sheet1.getRow(4).getCell(1).getStringCellValue());
			            Thread.sleep(2000);
			            
			           BookingInquiry.findElement(By.id("btn_send")).click();
			           Thread.sleep(2000);
			           String Currentemailalert=BookingInquiry.switchTo().alert().getText();
			           String Expectedemailalert="E-mail was transmitted successfully.";
			           
			         
						if(Currentemailalert.equals(Expectedemailalert))
						{
						
			         
			         Rectangle emailscrn=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					 BufferedImage emailscreenshot = new Robot().createScreenCapture(emailscrn);
					 String emailLoc="D:\\testing\\Automation\\screenshot\\Email"+System.currentTimeMillis()+".jpg";
					 File Emailpath=new File(emailLoc);
					 ImageIO.write(emailscreenshot, "jpg", Emailpath);
			         
			    
			        alert.accept();
			         Thread.sleep(2000);
			         XWPFRun tc5line=paragraph.createRun();
			         tc5line.setBold(true);
			         tc5line.setColor(passcase);
			         tc5line.setFontFamily("Aparajita");
			         tc5line.setFontSize(16);
			         tc5line.setText("PASSED: BL PDF sent via email successfully.");
			         tc5line.addCarriageReturn();
			         tc5line.addBreak();
					 String EmailpicLoc=Emailpath.toString();
					 FileInputStream emailpic=new FileInputStream(EmailpicLoc);
					 tc5line.addPicture(emailpic, XWPFDocument.PICTURE_TYPE_JPEG, EmailpicLoc, Units.toEMU(400), Units.toEMU(250));
					 tc5line.addCarriageReturn();
					 tc5line.addBreak();
					 int size=BookingInquiry.getWindowHandles().size();
				       
				       for (int i = 0; i < size; i++) {
						
				    	   if(!mainPage.equals(windowhandling())) {
				    		   BookingInquiry.close();
				    	   }	  
					}
				       BookingInquiry.switchTo().window(mainPage);
				       
						}
						
						else
						{
							
							String Emailalert=BookingInquiry.switchTo().alert().getText(); 
							tc5.setFontSize(16);
							tc5.setFontFamily("Aparajita");
							tc5.setBold(true);
							tc5.setColor(failcase);
							tc5.setText("FAILED: " + Emailalert);
							tc5.addCarriageReturn();
							tc5.addBreak();
							BufferedImage emailImage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
							File Destfileemail=new File("D:\\testing\\Automation\\screenshot\\Booking"+System.currentTimeMillis()+".jpg");
							ImageIO.write(emailImage, "jpg", Destfileemail);
							FileInputStream emailImg=new FileInputStream(Destfileemail);
							String emailImgLoc=Destfileemail.toString();
							tc5.addPicture(emailImg, XWPFDocument.PICTURE_TYPE_JPEG, emailImgLoc, Units.toEMU(400), Units.toEMU(250));
							
							alert.accept();
							 int size=BookingInquiry.getWindowHandles().size();
						       
						       for (int i = 0; i < size; i++) {
								
						    	   if(!mainPage.equals(windowhandling())) {
						    		   BookingInquiry.close();
						    	   }	  
							}
						       BookingInquiry.switchTo().window(mainPage);
							System.out.println("tc5 failed-Error Captured: " + Emailalert );
							Thread.sleep(2000);
							Location();
						}
					 }
					else {
						System.out.println("tc4: nothing");
					}
					}
					
						else {
							String Bookingalert=BookingInquiry.switchTo().alert().getText();
							XWPFRun tc3fail=paragraph.createRun();			
							tc3fail.setFontSize(16);
							tc3fail.setFontFamily("Aparajita");
							tc3fail.setBold(true);
							tc3fail.setColor(failcase);
							tc3fail.setText("FAILED: " + Bookingalert);
							tc3fail.addCarriageReturn();
							tc3fail.addBreak();
							BufferedImage BookingImage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
							File DestfileBooking1=new File("D:\\testing\\Automation\\screenshot\\Booking"+System.currentTimeMillis()+".jpg");
							ImageIO.write(BookingImage, "jpg", DestfileBooking1);
							FileInputStream BookingImg=new FileInputStream(DestfileBooking1);
							String BookingImgLoc=DestfileBooking1.toString();
							tc3fail.addPicture(BookingImg, XWPFDocument.PICTURE_TYPE_JPEG, BookingImgLoc, Units.toEMU(400), Units.toEMU(250));
							alert.accept();	
							
							BookingInquiry.close();
							BookingInquiry.switchTo().window(mainPage);
							
							System.out.println("tc3 failed-Error Captured: " + Bookingalert);
							Thread.sleep(2000);
							Location();

						}
					}
					
					else
						{
						    String Loginalert=BookingInquiry.switchTo().alert().getText();
						    BookingInquiry.switchTo().alert().accept();
							tc2.setFontSize(16);
							tc2.setFontFamily("Aparajita");
							tc2.setColor(failcase);
							tc2.addCarriageReturn();
							tc2.setText("FAILED: " + Loginalert);
							tc2.addBreak();
							BufferedImage LoginpageImage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
							File DestfileLoginpage=new File("D:\\testing\\Automation\\screenshot\\Loginpage"+System.currentTimeMillis()+".jpg");
							ImageIO.write(LoginpageImage, "jpg", DestfileLoginpage);
							FileInputStream LoginpageImg=new FileInputStream(DestfileLoginpage);
							String LoginpageImgLoc=DestfileLoginpage.toString();
							tc2.addPicture(LoginpageImg, XWPFDocument.PICTURE_TYPE_JPEG, LoginpageImgLoc, Units.toEMU(400), Units.toEMU(250));
							System.out.println("tc2 failed-Error Captured: " + Loginalert);
							document.write(word);
							BookingInquiry.close();
							
						}
					}
					else {
					
						tc1.setFontSize(16);
						tc1.setFontFamily("Aparajita");
						tc1.setColor(failcase);
						tc1.setText("FAILED: Invalid URL");
						BufferedImage LMSURLImage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
						File DestfileLMSURL=new File("D:\\testing\\Automation\\screenshot\\Loginpage"+System.currentTimeMillis()+".jpg");
						ImageIO.write(LMSURLImage, "jpg", DestfileLMSURL);
						FileInputStream LMSURLImg=new FileInputStream(DestfileLMSURL);
						String LMSURLImgLoc=DestfileLMSURL.toString();	
						tc1.addPicture(LMSURLImg, XWPFDocument.PICTURE_TYPE_JPEG, LMSURLImgLoc, Units.toEMU(400), Units.toEMU(250));
						document.write(word);
						BookingInquiry.close();
					}
					
					


	
		}
				   
			//tc6.Download Location MDA Report
		public static void Location() throws Exception {
					 BookingInquiry.findElement(By.xpath("//li[@class='gnb-bizComm']")).click();
					 Thread.sleep(2000);
				      BookingInquiry.findElement(By.xpath("//a[@href='/opuscntr/opusMainTobe.do?parentPgmNo=BCM_CCD_M001']")).click();
				      Thread.sleep(2000);
				      Set<String> ss1=BookingInquiry.getWindowHandles();
						Iterator<String> itr1=ss1.iterator();
						String MainPage=itr1.next(); 	
						String MDA=itr1.next();
				      BookingInquiry.switchTo().window(MDA);
				      Thread.sleep(2000);
				      BookingInquiry.switchTo().frame(BookingInquiry.findElement(By.id("gnb_frame")));
				      BookingInquiry.findElement(By.xpath("//li[@pgmno='BCM_CCD_M0010']")).click();
				      Thread.sleep(2000);
				      BookingInquiry.findElement(By.xpath("//li[@pgmno='BCM_CCD_0045']")).click();
				      Thread.sleep(2000);
				      
				      Thread.sleep(2000);
					
						BookingInquiry.findElement(By.name("loc_cd")).sendKeys(sheet1.getRow(5).getCell(1).getStringCellValue());
					      Thread.sleep(2000);
					      BookingInquiry.findElement(By.id("btn_DownExcel")).click();
				      Thread.sleep(2000);
				      XWPFRun tc6=paragraph.createRun();
					    tc6.setFontSize(16);
						tc6.setFontFamily("Aparajita");
						tc6.setBold(true);
						tc6.setColor(header);
						tc6.addCarriageReturn();
						tc6.addBreak();
						tc6.setText("Test 6: Download Location MDA Report");
						tc6.addCarriageReturn();
						tc6.addBreak();
						String LocationAlert=  BookingInquiry.switchTo().alert().getText();	
				     String ErrorAlert="There is no data.";
				      if(!LocationAlert.equals(ErrorAlert))
						{
				    	  BookingInquiry.switchTo().alert().accept();
				    	  Thread.sleep(5000);
				      BufferedImage Locscreenshot=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				      String locfile="D:\\testing\\Automation\\screenshot\\Location" + System.currentTimeMillis() + ".jpg";
				      File DestfileLoc=new File(locfile);
				      ImageIO.write(Locscreenshot, "jpg", DestfileLoc); 
				      Thread.sleep(2000);
				      
				      BookingInquiry.close();
				      XWPFRun tc6line=paragraph.createRun();
				      tc6line.setBold(true);
				      tc6line.setColor(passcase);
				      tc6line.setFontFamily("Aparajita");
				      tc6line.setFontSize(16);
				      tc6line.setText("Location MDA Report Screenshot (Check C:\\Users\\narman\\Downloads for .csv file)");
				      tc6line.addCarriageReturn();
				      tc6line.addBreak();
				      tc6line.setText("Download Customer MDA complete.");
				      tc6line.addCarriageReturn();
				      tc6line.addBreak();
				      FileInputStream locpic=new FileInputStream(DestfileLoc);
				      String Locationscreen=DestfileLoc.toString();
				      tc6line.addPicture(locpic, XWPFDocument.PICTURE_TYPE_JPEG, Locationscreen, Units.toEMU(400), Units.toEMU(250));
					 document.write(word);
					  word.close();
					  document.close();
					  BookingInquiry.quit();
					  System.out.println("Document completed successfully");
						}
						else 
						{
							String Locationalert=BookingInquiry.switchTo().alert().getText();
						    
							tc6.setFontSize(16);
							tc6.setFontFamily("Aparajita");
							tc6.setBold(true);
							tc6.setColor(failcase);
							tc6.setText("FAILED: " + Locationalert);
							tc6.addCarriageReturn();
							tc6.addBreak();	
							BufferedImage LocationImage=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
							File DestfileLocation=new File("D:\\testing\\Automation\\screenshot\\Booking"+System.currentTimeMillis()+".jpg");
							ImageIO.write(LocationImage, "jpg", DestfileLocation);
							FileInputStream LocationImg=new FileInputStream(DestfileLocation);
							String LocationImgLoc=DestfileLocation.toString();
							tc6.addPicture(LocationImg, XWPFDocument.PICTURE_TYPE_JPEG, LocationImgLoc, Units.toEMU(400), Units.toEMU(250));
							 BookingInquiry.switchTo().alert().accept();
							document.write(word);
							BookingInquiry.close();
							System.out.println("tc6 failed-Error Captured: " + Locationalert);
						}
		}
								
					
					static boolean isalertpresent() {
						try {
							
						    BookingInquiry.switchTo().alert();
						return false;
						
						}
						catch(Exception e){
							return true;
						}
								}
					static String windowhandling() 
					{
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
				       
	}
	
		