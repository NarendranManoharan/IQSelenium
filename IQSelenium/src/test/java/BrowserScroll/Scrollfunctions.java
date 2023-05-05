package BrowserScroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrollfunctions {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.get("https://www.google.com/search?q=yelagiri+go+kart&rlz=1C1GCEU_enIN1017IN1017&oq=&aqs=chrome.0.69i59i450l8.118678j0j7&sourceid=chrome&ie=UTF-8");
		Thread.sleep(2000);
		//scroll up and down
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		
		//executor.executeScript("window.scroll(0,1000)", "");
		//executor.executeScript("window.scroll(0,0)", "");
		
		//scroll down to the page
		executor.executeScript("window.scroll(0,document.body.scrollHeight)", "");
		
	}

}
