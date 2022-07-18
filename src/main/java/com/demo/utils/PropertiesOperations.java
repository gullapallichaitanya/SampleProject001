package com.demo.utils;

import java.io.File;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import com.demo.testbase.ObjectsRepo;

public class PropertiesOperations extends ObjectsRepo{
	ResourceBundle rd;
	public PropertiesOperations() {
		loadProperties();
	}
	public void loadProperties() {
		rd = ResourceBundle.getBundle("Config");
	}
	
	public String getPropertyValueByKey(String key) throws Exception {
		String value = rd.getString(key);
		if(StringUtils.isEmpty(key)) {
			throw new Exception("value not retried for "+key+" from properties file");
		} else return value;
	}
	

}
