package Screenshotmethods;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class UsingTakeScreenshot {

	public static void main(String[] args) throws IOException, AWTException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	
		driver.get("http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
		
		driver.findElement(By.id("j_username")).sendKeys("INNARMAN");
		driver.findElement(By.id("j_password")).sendKeys("Apr@2023");
		driver.findElement(By.xpath("//*[@type='button']")).click();
		driver.findElement(By.xpath("//li[@class='gnb-svcMGMT']")).click();
		
		// Type1
		/*TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		File destfile=new File("D:\\testing\\Notes\\study notes\\snap.jpg");
		FileHandler.copy(sourcefile, destfile);*/
		
		
		//Type 2
		Robot robot=new Robot();
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(screensize);
		BufferedImage srcfile=robot.createScreenCapture(rectangle);
		File destfile=new File("D:\\\\testing\\\\Notes\\\\study notes\\\\image.jpg");
		ImageIO.write(srcfile, "jpg", destfile);
		
		

	}

}
