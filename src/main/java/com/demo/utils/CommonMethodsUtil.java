package com.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethodsUtil {
	
	public void sendKeys(WebElement locator, String value) {
		locator.sendKeys(value);
	}
	
	public void clearAndSendKeys(WebElement locator, String value) {
		locator.clear();
		locator.sendKeys(value);
		
	}
	public String getText(WebElement locator ) {
		return locator.getText();
	}
	
	public List<String> getAllDropdownOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> list_drpdwn_options_locators = select.getOptions();
		List<String> list_drpdwn_options_string = new ArrayList<>();
		for (WebElement locator : list_drpdwn_options_locators) {
			list_drpdwn_options_string.add(locator.getText());			
		}
		return list_drpdwn_options_string;
	}
	
	public void selectDropdownOption(WebElement locator, String option, String type) {
		Select select = new Select(locator);
		switch (type) {
		case "index":
			int index = Integer.parseInt(option);
			select.selectByIndex(index);
			break;
		case "visibletext":
			select.selectByVisibleText(option);
			break;
		case "value":
		default:
			select.selectByValue(option);
			break;
		}
		
	}
	
	public void click(WebElement locator) {
		locator.click();
	}
	
	public void selectRadioButtonValue(List<WebElement> locator, String value) {
		for (WebElement webElement : locator) {
			System.out.println(webElement.getText());
			if(webElement.getText().equalsIgnoreCase(value)) {
				webElement.click();
				break;
			}			
		}
	}
		
	public void selectCheckboxOptions(List<WebElement> locator, String checks) {
		String[] checksArray = checks.split(",");
		for (String str : checksArray) {
			for (WebElement ele : locator) {
				if(ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					break;
				}
			}			
		}
	}
	

}
