package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {
  
	public static WebElement username(WebDriver driver) {
		return driver.findElement(By.id("j_username"));
	}
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.id("j_password"));
	}
	public static WebElement submitbutton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@type='button']"));
	}
}
