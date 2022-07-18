package com.demo.testbase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demo.pageobjects.EnterInsuranceDataPageObjects;
import com.demo.pageobjects.EnterProductDataPageObjects;
import com.demo.pageobjects.EnterVehicleDataPageObjects;
import com.demo.pageobjects.HomePageObjects;
import com.demo.pageobjects.SelectPriceOptionsPageObjects;
import com.demo.utils.CommonMethodsUtil;
import com.demo.utils.DateUtil;
import com.demo.utils.ExcelUtil;
import com.demo.utils.PropertiesOperations;

public class ObjectsRepo {
	public static WebDriver driver;
	public static PropertiesOperations propOps;
	public static DateUtil dateutil;
	public static ExtentReports extentreport;
	public static ExtentTest test;
	public static HomePageObjects homepage;
	public static EnterVehicleDataPageObjects vehicledata;
	public static CommonMethodsUtil commonmethods;
	public static EnterInsuranceDataPageObjects insdata;
	public static EnterProductDataPageObjects proddata;
	public static SelectPriceOptionsPageObjects priceoptions;
	public static ExcelUtil excel;

}
