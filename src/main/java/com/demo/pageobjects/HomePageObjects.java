package com.demo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testbase.TestBase;

public class HomePageObjects extends TestBase {
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement link_Automobile = driver.findElement(By.xpath(null))
	@FindBy(id="nav_automobile")
	WebElement link_Automobile;
	
	@FindBy(id="nav_truck")
	WebElement link_Truck;
	
	@FindBy(id="nav_motorcycle")
	WebElement link_MotorCycle;
	
	@FindBy(id="nav_camper")
	WebElement link_Camper;
	
	public void clickOnMotorCycleLink() {
		link_MotorCycle.click();
		
	}
}
