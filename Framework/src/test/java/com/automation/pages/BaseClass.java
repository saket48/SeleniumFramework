package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BroswerFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() {
		
		String appURL = config.getStagingURL();
		String browser = config.getBrowser();
		driver = BroswerFactory.startApplication(driver,browser,appURL);
	}
	
	@AfterClass
	public void teardown() {
		BroswerFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.captureScreenshot(driver);
		}
		
	}
	
}
