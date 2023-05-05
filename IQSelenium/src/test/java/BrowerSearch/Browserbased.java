package BrowerSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserbased {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("gym");
		
		Thread.sleep(3000);
		List<WebElement> searchlist = driver.findElements(By.xpath("//*[@id='Alh6id']/div[1]/div/ul/li"));
		System.out.println(searchlist.size());
		
		
 
		for (WebElement webElement : searchlist) {
			String text=webElement.getText();
			System.out.println(text);
          
			if(text.contains("nagar")) {
				webElement.click();
				break;
			}
	}

}
}
