package com.demo.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.testbase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {
	
	public EnterVehicleDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="make")
	WebElement dd_Make;
	
	@FindBy(id="model")
	WebElement dd_Model;
	
	@FindBy(id="cylindercapacity")
	WebElement input_CylinderCapacity;
	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement txt_cylinderCapacity_err_msg;
	
	@FindBy(id="engineperformance")
	WebElement input_EnginePerf;
	
	@FindBy(id="dateofmanufacture")
	WebElement input_DateOfManufacture;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_NoOfSeats;
	
	@FindBy(id="listprice")
	WebElement input_ListPrice;
	
	@FindBy(id="annualmileage")
	WebElement input_AnnualMileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement btn_Next;
	
	
	public void enterCylinderCapacity(String capacity) {
		commonmethods.sendKeys(input_CylinderCapacity, capacity);
	}
	
	public String getErrorMsgOnCylinderCapacity() {
		String error_msg = commonmethods.getText(txt_cylinderCapacity_err_msg);
		return error_msg;
	}
	
	public List<String> getAllModelDropdownOptions() {
		return commonmethods.getAllDropdownOptions(dd_Model);
	}
	
	public void enterVahicleData(HashMap<String, String> testdata) {
		commonmethods.selectDropdownOption(dd_Make, testdata.get("Vehicle Make"), "value");
		commonmethods.selectDropdownOption(dd_Model, testdata.get("Vehicle Model"), "value");
		commonmethods.sendKeys(input_CylinderCapacity, testdata.get("Vehicle Cylinder Capacity"));
		commonmethods.sendKeys(input_EnginePerf, testdata.get("Vehicle_Enging Performance"));
		commonmethods.sendKeys(input_DateOfManufacture, testdata.get("Vehicle_Date of Manufacture"));
		commonmethods.selectDropdownOption(dd_NoOfSeats, "2", testdata.get("Vehicle_no of seats"));
		commonmethods.sendKeys(input_ListPrice, testdata.get("Vehicle_listPrice"));
		commonmethods.sendKeys(input_AnnualMileage, testdata.get("Vehicle_Annual Mileage"));
	}
	
	public void clickNextButton() {
		commonmethods.click(btn_Next);
	}
}
