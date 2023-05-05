package WaitStatements;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
		
		driver.findElement(By.id("j_username")).sendKeys("INNARMAN");
		driver.findElement(By.id("j_password")).sendKeys("Apr@2023");
		driver.findElement(By.xpath("//*[@type='button']")).click();
		driver.findElement(By.xpath("//li[@class='gnb-svcMGMT']")).click();
		
		WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(20000));
		WebElement button=driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Booking & Documentation'][1]")));
		button.click();
		
		
		
		//`driver.findElement(By.xpath("//a[@href='/opuscntr/opusMainTobe.do?parentPgmNo=ESM_BKG_M001']")).click();
		Set<String> ss=driver.getWindowHandles();
		Iterator<String> itr=ss.iterator();
		String a=itr.next();
		String b=itr.next();
		driver.switchTo().window(b);
		driver.switchTo().frame(driver.findElement(By.id("gnb_frame")));
		String BookingScreen=driver.getWindowHandle();
		driver.findElement(By.xpath("//li[@pgmno='ESM_BKG_M019']")).click();
		driver.findElement(By.xpath("//li[@pgmno='ESM_BKG_M020']")).click();
		driver.findElement(By.xpath("//li[@pgmno='ESM_BKG_0079_Q']")).click();
		WebElement frame=driver.findElement(By.id("t1frame"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@name='bkg_no'][@type='text']")).sendKeys("SIN300072100");
		driver.findElement(By.id("btn_t1retrieve")).click();
		System.out.println("Process completed");
		driver.close();

	}

}
