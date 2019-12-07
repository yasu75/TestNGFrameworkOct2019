package com.hubspot.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtendReportListener implements ITestListener{
	//When test case get started, this nethod is called
	public void onTestStart(ITestResult result) {
	System.out.println("Extent report result");
	System.out.println(result.getName()+ "test case is started");
	
	}
	//When test case get passed, this method is called
	public void onTestSuccess(ITestResult result) {
	System.out.println(result.getName()+ "test case passed");	
		
	}
	//When test case get failed, this method is called
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the test case failed is: "+ result.getName());
		
	}
	//When test case get skipped, this method is called
	public void onTestSkipped(ITestResult skipped) {
		System.out.println("The name of the test case skipped is: "+ skipped.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	//
	public void onStart(ITestContext context) {
	//System.out.println(context.getName());	
		Reporter.log("About to begin executing test "+context.getName(),true );
		
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Compeleted executing test "+context.getName(),true );
		
	}

}
