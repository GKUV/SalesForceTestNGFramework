package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;
import com.training.utilities.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

//Tests - Sequence of Steps


public class LoginTest2 extends BaseTest{

	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String browser;
	String email;
	String password;
	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	
	public void beforeMethod() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		url = common.getproperty("url");
		browser = common.getproperty("browser");
	//	email = common.getproperty("email");     //commented to read data from ExcelFile
	//	password = common.getproperty("password");  //commented to read data from ExcelFile
		driver= getDriver(browser);
		Log.info("URL of the application: " + url);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		
	}
	
	
	@Test(dataProvider = "loginValid")
	
	public void loginwithValidUsername(String UserName,String Password) {
		Log.startTestCase("TestCase1");
		Log.info("Username entered: " + UserName);
		Log.info("Password entered: " + Password);
		login.enterIntoEmail(UserName);
		login.enterIntoPassword(Password);
		Log.info("Password entered successfully");
		login.clickOnLogin();	
	}
	
	
	@Test(dataProvider = "loginInvalid")
	public void loginWithInvalidUsername(String UserName,String Password) {
		Log.startTestCase("TestCase2");
		Log.info("Username entered: " + UserName);
		Log.info("Password entered: " + Password);
		login.enterIntoEmail(UserName);
		login.enterIntoPassword(Password);
		login.clickOnLogin();	
	}
	
	@DataProvider
	public Object[][] loginInvalid() throws IOException{
		Object[][] loginTestArray = ExcelUtils.getTableArray("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\TestNG\\TestNG-Salesforce framework\\InputData.xlsx", "Login", 2);
		return loginTestArray;
	}
	
	@DataProvider
	public Object[][] loginValid() throws IOException{
		Object[][] loginTestArray = ExcelUtils.getTableArray("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\TestNG\\TestNG-Salesforce framework\\InputData.xlsx", "Login", 1);
		return loginTestArray;
	}
	
	
	@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		Log.endTestCase("Ended");
		driver.close();
	}



}
