package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.RandomPage;
import com.training.utilities.CommonUtilities;

public class RandomTest extends BaseTest{
	
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	String url;
	String browser;
	String email;
	String password;
	LoginPage login;
	HomePage home;
	RandomPage random;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url= common.getproperty("url");
		browser= common.getproperty("browser");
		email=common.getproperty("email");
		password=common.getproperty("password");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		random = new RandomPage(driver);
		
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
	
	@Test
	public void TC33ValidateFirstAndLastNamelink() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		random.clickOnNameLink();
		
	}
	
	@Test
	public void TC34VerifyUpdatedLastname() throws InterruptedException {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		random.clickOnNameLink();
		Thread.sleep(3000);
		home.clickOnEditProfile();
		Thread.sleep(3000);
		home.switchToAboutTabframe();
		home.clickOnAboutTab();
		random.enterLastname();
		home.clickSaveAll();
		
	}
	
	@Test
	public void TC35verifyTabCustomization() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		random.clickOnAllTabs();
		random.clickOnCustomizeMyTab();
		random.selectATabFromSelectedTab();
		random.clickOnremove();
		random.clickOnSavebutton();
		random.clickOnFirstLastNameLink();
		home.clickOnLogout();
	}
	
	@Test
	public void TC36EventBlockingInCalendar() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
//		random.clickOnCurrentDateLink();
//		random.clickOn8PMTime();
//		random.clickOnSubjectComb();
//		random.clickOtherfromCombobox();
//		random.clickOnTheEndTime();
//		random.select9PMfromDD();
//		random.clickOnSave();
		
		
	}
	
	@Test
	public void TC37WeeklyRecurrenceBlockingInCalendar() {
		
	}
	

}
