package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagefactorywithAnnotations {
  
	@FindBy(id ="j_username")
	public static WebElement username;
	
	@FindBy(id ="j_password")
	public static WebElement password;
	
	@FindBy(xpath ="//*[@type='button']")
	public static WebElement submitbutton;
	
	
}
