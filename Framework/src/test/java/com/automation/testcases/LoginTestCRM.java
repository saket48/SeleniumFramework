
package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BroswerFactory;
import com.automation.utility.ExcelDataProvider;



public class LoginTestCRM  extends BaseClass{

		
	@Test
	public void loginApp() {
		
		logger = report.createTest("Login to CRM");
		
		String uname = excel.getStringData(0, 1, 0);
		String pwd = excel.getStringData(0, 1, 1);
		
	
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        logger.info("Starting Appn");
		
//        System.out.println("passwprd = = "+pwd+"-");
        
		loginPage.loginToCRM(uname,pwd);
		logger.pass("Login Sucessful");
		 
	}
	
}
