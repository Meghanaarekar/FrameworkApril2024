package com.saucelab.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	//create method for report configuration
	public void configuration()
	{
		//give name of file that you want to be shown result in
		htmlReporter=new ExtentSparkReporter("ExtentReport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
	
	//Add environment details
	reports.setSystemInfo("Machine","testpc1");
	reports.setSystemInfo("OS","Window11");
	reports.setSystemInfo("user1","test1");
	reports.setSystemInfo("Browser","chrome");
	
	//Add configurtion to change look and feel
	htmlReporter.config().setDocumentTitle("Extent Report Demo");
	htmlReporter.config().setReportName("Test Report");
	htmlReporter.config().setTheme(Theme.DARK);
	htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("finish");
		reports.flush();
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		configuration();
		System.out.println("on start method invoked");
			
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("Name of test method failed : "+ result.getName());
	test=reports.createTest(result.getName());
test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case is"+result.getName(), ExtentColor.RED));
	test.fail(result.getThrowable());
	String screenshotPath =System.getProperty("user.dir")+"\\Screenshots\\"+result.getName();
	File screenshotFile = new File(screenshotPath);
	if(screenshotFile.exists())
	{
		test.fail("Captured screenshot"+ test.addScreenCaptureFromPath(screenshotPath));
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method skipped : "+ result.getName());
		test=reports.createTest(result.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel("Name of skipped test case is"+result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("test case started"+result.getName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of test method pass : "+ result.getName());
		test=reports.createTest(result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel("Name of PASS test case is"+result.getName(), ExtentColor.GREEN));
	}
}
