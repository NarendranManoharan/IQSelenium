package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
       static WebDriver driver;
     //  public static WebElement //*[@type='button'];
       
     @Test
	public static void login() throws InterruptedException {
    	 driver=new ChromeDriver();
    	 driver.manage().deleteAllCookies();
    	 driver.manage().window().maximize();
	
    	 driver.get("http://lmstest.pilship.com/opuscntr/MainPage.do");
	Thread.sleep(2000);
	
	
	PageFactory.initElements(driver, PagefactorywithAnnotations.class);
	
	PagefactorywithAnnotations.username.sendKeys("INNARMAN");
	PagefactorywithAnnotations.password.sendKeys("Apr@2023");
	PagefactorywithAnnotations.submitbutton.click();	
	
	
	/*
	 * LoginPOM.username(driver).sendKeys("INNARMAN");
	 * LoginPOM.password(driver).sendKeys("Apr@2023");
	 * LoginPOM.submitbutton(driver).click();
	 */
	Thread.sleep(2000);
	driver.quit();
	
	}
}
