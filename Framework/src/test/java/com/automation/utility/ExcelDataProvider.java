package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wkbk;
	public ExcelDataProvider() {
		
		File  src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			
		wkbk = new XSSFWorkbook(fis);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read Excel !! "+e.getMessage());
		}
		
	}
	
	 public String getStringData(String sheetname,int row,int col)
	 {
		 return wkbk.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		
	 }
	
	 public String getStringData(int sheetIndex,int row,int col)
	 {
		 return wkbk.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	 }
	 
	 public double getNumericDatabysheetNo(int sheetIndex,int row,int col)
	 {
		 return wkbk.getSheetAt(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
		
	 }
}
