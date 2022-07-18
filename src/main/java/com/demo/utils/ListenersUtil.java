package com.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.spi.FileTypeDetector;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.demo.testbase.ObjectsRepo;

public class ListenersUtil extends ObjectsRepo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test = extentreport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String screenshotPath = System.getProperty("user.dir")+"/ExtentReport/Screenshots/"+dateutil.getformatedDate()+".jpeg";
		test.fail(result.getThrowable());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentreport = ExtentReportsUtil.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

}
