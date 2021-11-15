package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BroswerFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Starting the setup Suite",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/CRM_"
		+Helper.getCurrentDateTime()+"_.html");
		report = new ExtentReports();
		report.attachReporter(spark);
		
		Reporter.log("Data Setup done",true);
	}
	
	@BeforeClass
	public void setup() {
		
		String appURL = config.getStagingURL();
		String browser = config.getBrowser();
		driver = BroswerFactory.startApplication(driver,browser,appURL);
		Reporter.log("application launched ",true);
		
	}
	
	@AfterClass
	public void teardown() {
		BroswerFactory.quitBrowser(driver);
		Reporter.log("Browser closed",true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String SSPath = Helper.captureScreenshot(driver);
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(SSPath).build());
			Reporter.log("Test passed", true);
			
		}
		
		
		report.flush();
	}
	
}
