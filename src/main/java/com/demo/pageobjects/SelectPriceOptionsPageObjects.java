package com.demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testbase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase{
	public SelectPriceOptionsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nextsendquote")
	WebElement btn_Next;
	
	public WebElement LocatorPricePerYear(String plan) {
		WebElement priceElement = null;
		priceElement = driver.findElement(By.xpath("//table[@id='priceTable']//tr[1]/td[@data-label='"+plan+"']/span"));
		return priceElement;
	}
	
	public WebElement LocatorSelectPlanRadioButton(String plan) {
		WebElement locator = null;
		locator = driver.findElement(By.xpath("//input[@name='Select Option' and @value='"+plan+"']/parent::label"));
		return locator;
	}
	
	public String getPricePerYear(String plantype) {
		String price = null;
		price = commonmethods.getText(LocatorPricePerYear(plantype));
		return price;
	}
	
	public void selectPlan(String plantype) {
		commonmethods.click(LocatorSelectPlanRadioButton(plantype));
	}
	
	public void clickNextButton() {
		commonmethods.click(btn_Next);		
	}
}
