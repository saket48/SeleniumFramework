package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	public static String captureScreenshot(WebDriver driver) {
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScrnshotPath =System.getProperty("user.dir")+"/Screenshots/CRM_"+getCurrentDateTime()+"_.png";
//		System.out.println(ScrnshotPath);
		
		
		try {
			
			FileHandler.copy(src,new File(ScrnshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture Screenshot !!");
		}
		
		return ScrnshotPath;
	}

	public static String getCurrentDateTime() {
	
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currDate = new Date();
			
		return customFormat.format(currDate);
	}
	
	
	
}

	
	