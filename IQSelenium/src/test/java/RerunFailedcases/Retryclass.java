package RerunFailedcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryclass implements IRetryAnalyzer{

	
	int failedCount=0;
	int limit=4;
	@Override
	public boolean retry(ITestResult result) {
		
		if(failedCount<limit) {
			failedCount++;
			return true;
		}
		return false;
	}
	

}
