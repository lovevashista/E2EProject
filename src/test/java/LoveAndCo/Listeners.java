package LoveAndCo;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Base;

//To utilize listener in test Ng there is an interface called as iTestListener
public class Listeners implements ITestListener{
	
	//Creating Base class object so that i can access all the methods of the base class
	Base b = new Base();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//this function gets executed before a test within a suite starts
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//this function gets executed if the test case is passed
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//this function is executed if the test case is failed
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//This function gets executed if the test case is skipped
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//this function gets executed before the test suite starts execution.
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// this function gets executed after the test suite finishes execution.
	}

}
