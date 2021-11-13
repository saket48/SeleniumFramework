package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import freemarker.log.Logger;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
	  this.driver = ldriver;
		
	}
	
		
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div/div/a")
	WebElement lgnbtn;
	
	//WebElement loginlink = driver.findElement(By.xpath("));
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginSubmit;
	
	public void loginToCRM(String uname,String pwd)
	{
		
		try {
			Thread.sleep(3000);
			lgnbtn.click();
		}catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			Thread.sleep(1000);
			username.sendKeys(uname);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
			password.sendKeys(pwd);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			loginSubmit.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
