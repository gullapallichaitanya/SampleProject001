package com.demo.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demo.pageobjects.EnterInsuranceDataPageObjects;
import com.demo.pageobjects.EnterProductDataPageObjects;
import com.demo.pageobjects.EnterVehicleDataPageObjects;
import com.demo.pageobjects.HomePageObjects;
import com.demo.pageobjects.SelectPriceOptionsPageObjects;
import com.demo.utils.CommonMethodsUtil;
import com.demo.utils.DateUtil;
import com.demo.utils.ExcelUtil;
import com.demo.utils.PropertiesOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ObjectsRepo {
	
	/*
	 * protected HomePageObjects homepage = new HomePageObjects(); protected
	 * EnterVehicleDataPageObjects vehicledata = new EnterVehicleDataPageObjects();
	 */
	
	public void launchBrowserAndNavigate() throws Exception {
		//String browser = propOps.getPropertyValueByKey("browser");
		String browser = System.getProperty("Browser");
		String url = propOps.getPropertyValueByKey("url");
		//String url - System.getProperty("appUrl");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
			
		} else if (browser.equalsIgnoreCase("ie")) {
			driver = WebDriverManager.iedriver().create();
			
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@BeforeSuite
	public void initiateObjects() {
		dateutil= new DateUtil();
		propOps = new PropertiesOperations();
	}
	
	@BeforeMethod
	public void setup() throws Exception {		
		launchBrowserAndNavigate();	
		homepage = new HomePageObjects();
		vehicledata = new EnterVehicleDataPageObjects();
		insdata = new EnterInsuranceDataPageObjects();
		proddata = new EnterProductDataPageObjects();
		priceoptions = new SelectPriceOptionsPageObjects();
		excel = new ExcelUtil();
		commonmethods = new CommonMethodsUtil();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
