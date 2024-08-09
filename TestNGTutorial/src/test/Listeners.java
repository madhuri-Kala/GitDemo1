package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// to implement TestNG Listneres we need to implements  interfaced called ITestListener

public class Listeners implements ITestListener {

	/* VIMP-Listeners concepts
	 *   1. This class is used when your test is failed it. testng xml file will redirected to this Listeners java class. It will do the actions which is mentioned in that method.
	// 2. For e.g. onTestFailure method we want to take screenshot.We will write the code to take screenshot so whenever test is failed. It will execute that code.
	// But for this class method to run you need to mentioned the path of this "Listeners.java" class in testng.xml file.Please refer the "testng.xml" file.
	3. If you want to know which test cases has been failed. we can get the information by using ITestResult  object called "result" calling ITestResult result.getName() method using result object
	*/
	
	@Override
	public void onTestStart(ITestResult result)
	{

	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("This Listeners test has been passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("This Listeners test has been failed "+ result.getName());
	}
	

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	@Override
	public void onStart(ITestContext result)
	{
		
	}
}
