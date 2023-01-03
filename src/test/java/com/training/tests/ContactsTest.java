package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunitiesPage;
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest {
	
	WebDriver driver;
	String url;
	String browser;
	String email;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	ContactsPage contacts;
	
	@BeforeMethod
	
	public void beforeMethod() throws IOException {
		url=common.getproperty("url");
		browser=common.getproperty("browser");
		email=common.getproperty("email");
		password=common.getproperty("password");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		contacts = new ContactsPage(driver);
	}
	
	@AfterMethod
	
	public void afterMethod() {
		takescreenshot(driver);
		driver.close();
	}
	
	@Test
	public void TC25CreateNewContact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickOnNewButton();
		contacts.enterIntoLastNameField();
		contacts.enterIntoAcctNameField();
		contacts.clickOnsaveContact();
		
	}
	
	@Test
	public void TC26NewViewInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickONCreateNewView();          		 
		contacts.enterIntoViewLastNameField();			
		contacts.enterIntoUniqueViewNameField();		
		contacts.clickOnViewsaveContact();				
		
	}
	
	@Test
	public void TC27RecentlyCreatedContacts() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickOnRecentlyCreateddropdown();
		
	}
	
	@Test
	public void TC28CheckMyContacts() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickOnMyContactsFromDropdown();	
	}
	
	@Test
	public void TC29ViewAcontactInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.viewAContactinContactPage();
	}
	
	@Test
	public void TC30CheckErrormsginNewView() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickONCreateNewView();
		contacts.checkErrorMsginNewView();
		
	}
	
	@Test
	public void TC31CheckCancelButton() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickONCreateNewView();
		contacts.checkCancelButton();
		
	}
	
	@Test
	public void TC32SaveAndNew() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contacts.clickOnNewButton();
		contacts.checkforSaveAndNewButton();
	}

}
