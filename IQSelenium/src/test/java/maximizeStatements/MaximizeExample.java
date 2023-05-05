package maximizeStatements;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximizeExample {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.com/");
		
		//Maximize()
		    //driver.manage().window().maximize();
		
		
		//use of dimension
			//Dimension dimension=new Dimension(1300, 768);
			//driver.manage().window().setSize(dimension);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("gym");
		driver.switchTo().activeElement().sendKeys("gym \n");
		
		
	}

}
