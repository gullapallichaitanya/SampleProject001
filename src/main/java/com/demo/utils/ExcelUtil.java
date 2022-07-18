package com.demo.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.demo.testbase.ObjectsRepo;

public class ExcelUtil extends ObjectsRepo{
		Workbook wb;
		Sheet sh;
		String filePath = ".//src//test//resources//TestData//TestData.xlsx";
	
	  public ExcelUtil() throws Exception {
		
		File src = new File(filePath);
		wb = WorkbookFactory.create(src); 
	  
	  }
	 
	
		
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
		//filePath = ".//src//test//resources//TestData//TestData.xlsx";
		HashMap<String, String> testData = new HashMap<String, String>();
		File src = new File(filePath);
		wb = WorkbookFactory.create(src);
		sh = wb.getSheet("Insurance");
		//String cellvalue = sh.getRow(0).getCell(0).toString()
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(0).setCellType(CellType.STRING);
			testData.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		return testData;
	}
	
	/*public int getRowCount() {
		sh = wb.getSheet("Insurance");
		int rowcount = sh.getLastRowNum();
		return rowcount;
		
	}*/

}
