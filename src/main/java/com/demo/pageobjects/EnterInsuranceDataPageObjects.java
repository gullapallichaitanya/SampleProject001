package com.demo.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testbase.TestBase;

public class EnterInsuranceDataPageObjects extends TestBase {
	
	public EnterInsuranceDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement input_FirstName;
	
	@FindBy(id="lastname")
	WebElement input_LastName;
	
	@FindBy(id="birthdate")
	WebElement date_BirthDate;
	
	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rdo_Gender;
	
	@FindBy(id="streetaddress")
	WebElement input_StreetAddress;
	
	@FindBy(id="country")
	WebElement dd_Country;
	
	@FindBy(id="zipcode")
	WebElement input_Zipcode;
	
	@FindBy(id="occupation")
	WebElement dd_Occupation;
	
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement> chkbox_Hobbies;
	
	@FindBy(id="website")
	WebElement input_Website;
	
	@FindBy(id="picture")
	WebElement input_Picture;
	
	
	@FindBy(id="preventervehicledata")
	WebElement btn_Prev;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;
	
	
	public void fillInsuranceData(HashMap<String, String> testdata) {
		commonmethods.sendKeys(input_FirstName, testdata.get("Insurant_FirstName"));
		commonmethods.sendKeys(input_LastName, testdata.get("Insurant_lastName"));
		commonmethods.sendKeys(date_BirthDate, testdata.get("Insurant_birthdate"));
		commonmethods.selectRadioButtonValue(rdo_Gender, testdata.get("Insurant_gender"));
		commonmethods.sendKeys(input_StreetAddress, "11th avenue");
		commonmethods.selectDropdownOption(dd_Country, testdata.get("Insurant_country"), "value");
		commonmethods.sendKeys(input_Zipcode, testdata.get("Insurant_zipcode"));
		commonmethods.selectDropdownOption(dd_Occupation, testdata.get("Insurant_occupation"), "value");
		commonmethods.selectCheckboxOptions(chkbox_Hobbies, testdata.get("Insurant_hobby"));
		//upload picture
	}
	
	public void clickNextButton() {
		commonmethods.click(btn_Next);
	}
	

}
