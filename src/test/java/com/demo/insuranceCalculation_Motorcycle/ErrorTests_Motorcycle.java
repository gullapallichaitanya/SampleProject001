package com.demo.insuranceCalculation_Motorcycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.demo.testbase.TestBase;

public class ErrorTests_Motorcycle extends TestBase{
	
	@Test(enabled = false, priority = 0)
	public void errorMessage_CylinderCapacityField() throws Exception {
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		//verify error message
		homepage.clickOnMotorCycleLink();
		vehicledata.enterCylinderCapacity("1000");
		String actualErrorMessage = vehicledata.getErrorMsgOnCylinderCapacity();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "error message is not as expected");
	}
	
	@Test (enabled = false, priority = 1)
	public void errorMessage_CylinderCapacityField1() throws Exception {
		String expectedErrorMessage = "Must be a number between 1 and 3000";
		//verify error message
		homepage.clickOnMotorCycleLink();
		vehicledata.enterCylinderCapacity("2222");
		String actualErrorMessage = vehicledata.getErrorMsgOnCylinderCapacity();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "error message is not as expected");
	}
	
	@Test (enabled = true)
	public void verify_model_dropdown_options() throws Exception {
		List<String> expectedOptions = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		homepage.clickOnMotorCycleLink();
		List<String> actualOptions = vehicledata.getAllModelDropdownOptions();
		Assert.assertEquals(expectedOptions, actualOptions);		
	}

}
