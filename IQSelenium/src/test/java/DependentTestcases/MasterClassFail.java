package DependentTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class MasterClassFail {
	
	@Test(timeOut = 2000 )
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("login succesful");
		
	}
	
	@Test(dependsOnMethods = "login" , alwaysRun = true)
	public void booking() {
		System.out.println("Booking generated");
		Assert.assertEquals(true, false);
	}

}
