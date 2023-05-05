package pil.automation.LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectModel.LoginPOM;



public class Loginpage {
    static WebDriver driver;
    
    String[][] data= {
    		{"INNARMAN","APR@2023"},
    		{"INNARMAN0","APR@2023"},
    		{"INNARMAN","123"},
    };
    
    @DataProvider(name = "logindata")
    public String[][] dataprovider(){
		return data;
    	
    }
    
    
    @Test(dataProvider = "logindata")
	public void login(String name, String pass) {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://lmstest.pilship.com/opuscntr/MainPage.do");
		
		driver.findElement(By.id("j_username")).sendKeys(name);
		driver.findElement(By.id("j_password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@type='button']")).click();
		driver.quit();
	}
}
