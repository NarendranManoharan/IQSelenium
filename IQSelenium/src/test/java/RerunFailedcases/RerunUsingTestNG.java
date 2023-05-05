package RerunFailedcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RerunUsingTestNG  {
	
	@Test
	public void Testcase1(){
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void Testcase2(){
		Assert.assertEquals(true, false);
	}
}
