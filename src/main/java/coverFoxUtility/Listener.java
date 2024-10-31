package coverFoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBaseMaven.Base;



public class Listener extends Base implements ITestListener{

	@Override
	public void onTestSuccess (ITestResult result) {
		Reporter.log("Tc SuccessFully Completed :  "+result.getName(), true);
		try {
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			Reporter.log("taking Screenshot",true);
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
