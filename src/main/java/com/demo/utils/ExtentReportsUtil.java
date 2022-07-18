package com.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.testbase.ObjectsRepo;

public class ExtentReportsUtil extends ObjectsRepo{
	
	public static ExtentReports setupExtentReport() {
		String reportPath = System.getProperty("user.dir")+"/ExtentReport/sparkReport_"+dateutil.getformatedDate()+".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extentreport = new ExtentReports();
		extentreport.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("Document Title - Demo Practice Project");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Report Name - Demo Practice Report");
		return extentreport;
	}

}
