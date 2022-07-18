package com.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.testbase.ObjectsRepo;

public class DateUtil extends ObjectsRepo{
	
	public String getformatedDate() {
		SimpleDateFormat format = new SimpleDateFormat("DD-MM-YY HH-mm-ss");
		Date date = new Date();
		String formatedDate = format.format(date);
		return formatedDate;
	}

}
