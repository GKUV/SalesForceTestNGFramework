package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	String url;
	String browser;
	String email;
	String password;
	LoginPage login;
	HomePage home;
	LeadsPage leads;
	
	@BeforeMethod
	
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		leads = new LeadsPage(driver);
	}
	
@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
	@Test
	
	public void TC20CheckLeadsTab() throws InterruptedException {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Thread.sleep(2000);
		home.clickuserMenudropdown();
		home.clickOnLogout();

	}
	
	@Test
	public void TC21ValidateViewDropdownList() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		leads.validateviewdropdown();
		home.clickuserMenudropdown();
		home.clickOnLogout();
	}	
	
	@Test
	public void TC22FunctionalityOfGoButton() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		leads.selectfromViewDrop();
		home.clickuserMenudropdown();
		home.clickOnLogout();
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		leads.clickOnGo();
	}

	@Test
	public void TC23ListItemTodaysLeads() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		leads.clickOnTodaysLead();
	}
	
	@Test
	public void TC24CheckNewButton() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		leads.clickOnNewRecentLeads();
		leads.enterIntoLeadLastname();
		leads.enterIntoCompanyName();
		leads.clickOnLeadsSave();
		
	}
}
