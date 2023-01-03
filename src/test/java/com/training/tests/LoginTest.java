package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

//Tests - Sequence of Steps


public class LoginTest extends BaseTest{

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
		email = common.getproperty("email");     //commented to read data from ExcelFile
		password = common.getproperty("password");  //commented to read data from ExcelFile
		driver= getDriver(browser);
		Log.info("URL of the application: " + url);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		
	}
	
	@Test
	
	public void TC01navigateToSFDC() {
		Log.startTestCase("TestCase1");
		Log.info("Username entered: " + email);
		Log.info("Password entered: " + password);
		login.enterIntoEmail(email);
		Log.info("Password entered successfully");
		login.clickOnLogin();	
	}
	
	@Test
	public void TC02loginIntoSalesforce() {
		Log.startTestCase("TestCase2");
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		
	}
	
	@Test
	public void TC03checkRememberMe() {
		Log.startTestCase("TestCase3");
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.checkRememberMe();
		Log.info("checkRememberMe ");
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnLogout();
		login.validateUsername();
	}
	
	@Test
	public void TC04AforgetPassword() {
		Log.startTestCase("TestCase4A");
		login.enterIntoEmail(email);
		login.clickOnforgotPassword();
		Log.info("Forget Password" );
		login.clickOncontinueButton();
		
	}
	
	@Test

	public void  TC04BforgetPassword() {
		Log.startTestCase("TestCase4B");
		login.enterIntoEmail("123");
		login.enterIntoPassword("22131");
		login.clickOnLogin();
	}
	
	@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		Log.endTestCase("Ended");
		driver.close();
	}



}
