package com.demo.insuranceCalculation_Motorcycle;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demo.testbase.TestBase;

public class EndToEndTests_Motorcycle extends TestBase{
		
	@Test(priority = 0)
	public void insuranceCalculate() throws Exception {
		HashMap<String, String> testdata = excel.getTestDataInMap(1);
		
		System.out.println("This is Test data: "+ testdata);
		
		homepage.clickOnMotorCycleLink();
		vehicledata.enterVahicleData(testdata);
		vehicledata.clickNextButton();
		insdata.fillInsuranceData(testdata);
		insdata.clickNextButton();
		proddata.enterProductData(testdata);
		proddata.clickNextButton();
		
		/*
		 * String expectedPlanPrice = "241.00"; String actualplanPrice =
		 * priceoptions.getPricePerYear("Gold");
		 */
		/*
		 * Assert.assertEquals(priceoptions.getPricePerYear("Gold"),
		 * testdata.get("PriceValidation_Gold"), "Price not matching for Gold plan");
		 * Assert.assertEquals(priceoptions.getPricePerYear("Silver"),
		 * testdata.get("PriceValidation_Silver"),
		 * "Price not matching for Silver plan");
		 * Assert.assertEquals(priceoptions.getPricePerYear("Platinum"),
		 * testdata.get("PriceValidation_Platinum"),
		 * "Price not matching for Platinum plan");
		 * Assert.assertEquals(priceoptions.getPricePerYear("Ultimate"),
		 * testdata.get("PriceValidation_Ultimate"),
		 * "Price not matching for Ultimate plan");
		 * priceoptions.selectPlan(testdata.get("SelectOption"));
		 * priceoptions.clickNextButton();
		 */
		
	}
	
	/*
	 * @DataProvider (name = "vehData") public Object[][] testDataSupplier() throws
	 * Exception { Object[][] obj = new Object[excel.getRowCount()][1]; for (int i =
	 * 1; i <= excel.getRowCount(); i++) { HashMap<String, String> testData =
	 * excel.getTestDataInMap(i); obj[i-1][0] = testData; } return obj; }
	 */
	
}