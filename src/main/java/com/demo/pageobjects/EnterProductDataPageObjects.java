package com.demo.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testbase.TestBase;

public class EnterProductDataPageObjects extends TestBase {
	
	public EnterProductDataPageObjects() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="startdate")
	WebElement date_StartDate;
	
	@FindBy(id="insurancesum")
	WebElement dd_InsuranceSum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_DamageInsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chkbox_OptionalProducts;
	
	@FindBy(id="preventerinsurancedata")
	WebElement btn_Prev;
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_Next;
	
	public void enterProductData(HashMap<String, String> testdata) {
		commonmethods.sendKeys(date_StartDate, testdata.get("Product_startdate"));
		//commonmethods.selectDropdownOption(dd_InsuranceSum, testdata.get("Product_insurancesum"), "value");
		commonmethods.selectDropdownOption(dd_DamageInsurance, testdata.get("Product_damageinsurance"), "value");
		commonmethods.selectCheckboxOptions(chkbox_OptionalProducts, testdata.get("Product_optionalproducts"));
	}
	
	public void clickNextButton() {
		commonmethods.click(btn_Next);
	}

}
