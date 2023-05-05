package RefreshStatements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class refreshExample {

	public static void main(String[] args) throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
		
		driver.findElement(By.id("j_username")).sendKeys("INNARMAN");
		driver.findElement(By.id("j_password")).sendKeys("Apr@2023");
		
		//Refresh command
		//driver.navigate().refresh();
		
		//get current url
		//driver.get(driver.getCurrentUrl());
		
		//JavascriptExecutor
		//JavascriptExecutor executor=(JavascriptExecutor) driver;
		//executor.executeScript("history.go(0)");//location.reload()
		
		//press F5
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
		
		
	}

}
