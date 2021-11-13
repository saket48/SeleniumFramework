
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
		
		String uname = excel.getStringData(0, 0, 0);
		String pwd = excel.getStringData(0, 0, 1);
		
	
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

		
		loginPage.loginToCRM(uname,pwd);
		
		 
	}
	
}
