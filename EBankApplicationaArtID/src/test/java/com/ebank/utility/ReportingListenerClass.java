package com.ebank.utility;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

// this listerner class
public class ReportingListenerClass extends TestListenerAdapter{
	
	public ExtentReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{}
	public void onTestSuccess(ITestResult tr)
	{}
	public void onTestFailure(ITestResult tr)
	{}
	public void onTestSkipped(ITestResult tr)
	{}
	public void onFinish(ITestContext testContext)
	{}

}
