package ExceptionHandlinginTestNG;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExceptionHandling {
	
	@Test(timeOut = 2000 , expectedExceptions = Exception.class)
	public void timeouts() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Exception handling");
	}
 
}
