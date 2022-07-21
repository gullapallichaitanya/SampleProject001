package com.demo.testbase;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import io.github.bonigarcia.wdm.webdriver.WebDriverCreator;

public class TestBase extends ObjectsRepo {
	
	/*
	 * protected HomePageObjects homepage = new HomePageObjects(); protected
	 * EnterVehicleDataPageObjects vehicledata = new EnterVehicleDataPageObjects();
	 */
	public static final String USERNAME = "gullapallichaita_tiDwCl";
	public static final String AUTOMATE_KEY = "dkZQEPzXRRWd7a1Yyx6a";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	public void launchBrowserAndNavigate() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		//String browser = propOps.getPropertyValueByKey("browser");
		String browser = System.getProperty("Browser");
		String url = propOps.getPropertyValueByKey("url");
		//String url - System.getProperty("appUrl");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		options.addArguments("--incognito");
		options.addArguments("--disable-site-isolation-trials");
		System.out.println("Browser::::::::::::::::::::::::" + browser);
		
		if (browser.equalsIgnoreCase("chrome")) {
			//driver = WebDriverManager.chromedriver().create();
			//caps.setBrowserName("chrome");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "latest");			
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			//driver = WebDriverManager.firefoxdriver().create();
			//caps.setBrowserName("firefox");
			//caps.setCapability("marionette",true);
			caps.setCapability("browser", "Firefox");
			//caps.setCapability("browser_version", "latest");
			caps.setCapability("marionette",true);
			
		} else if (browser.equalsIgnoreCase("ie")) {
			//driver = WebDriverManager.iedriver().create();
			caps.setCapability("browser", "ie");
			caps.setCapability("browser_version", "latest");
			
		} else if (browser.equalsIgnoreCase("edge")) {
			//driver = WebDriverManager.edgedriver().create();
			//caps.setBrowserName("edge");
			caps.setCapability("browser", "Edge");
			caps.setCapability("browser_version", "latest");
			
			
		}
		
		options.merge(caps);
		driver = new RemoteWebDriver(new URL(URL), options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
