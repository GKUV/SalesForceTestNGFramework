package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class AccountTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String password;
	LoginPage login;
	HomePage home;
	AccountPage account;
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		email = common.getproperty("email");
		password = common.getproperty("password");
		driver= getDriver("chrome");
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		account = new AccountPage(driver);
	
	}
	
	@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}

	@Test

	public void TC10createAnAccount() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.clickOnAccountsTab();
		account.clickOnNewAccount();
		account.enterIntoAccountName();
		account.selectFromDropdown();
		account.setPriority();	
	}

	@Test
	public void TC11createNewView() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.clickOnAccountsTab();
		account.clickOnCreateNewView();
		account.enterIntoViewName();
		account.enterIntoUniqueName();
		account.clickOnSave();
	}

	@Test
	public void TC12editView() {      //working
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.clickOnAccountsTab();
		account.selectViewFromViewDrop();
		account.clickOnEditlink();
		account.editViewName();
		account.selectfield();
		account.selectOperator();
		account.selectValue();
		account.clickOnSave();
		
	}
	
	@Test
	public void TC13MergeAccounts() {   //Note: Add two accounts with same name and them Merge account
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.clickOnAccountsTab();
		account.clickOnMergeAccountLink();
		account.enteraccount();
		account.clickOnFindAccounts();
	//	account.checkonaccountsToBeMerged();
		account.clickOnNext();
		account.clickOnMergebutton();
		account.clickOkOnPopUp();
		
	}
	
	@Test
	
	public void TC14CreateAccountReport()  {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.clickOnAccountsTab();
		
		account.clickOnAccountsWithLastActivity();  
		account.selectCreatedDateFromDateFieldDropdown(); 
		account.selectTodaysDateInFrom();   //Work on select date from calendar    
		account.selectTodaysDateInTo();  
		account.clickOnSaveButton();       
		account.enterIntoReportName(); 
		account.enterIntoUniqueReportName(); 
		account.clickOnSaveAndRunReport();   
		
		
	}
}

