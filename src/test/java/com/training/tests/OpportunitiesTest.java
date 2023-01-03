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
import com.training.pages.OpportunitiesPage;
import com.training.utilities.CommonUtilities;

public class OpportunitiesTest extends BaseTest{
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String password;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunitiesPage opportunities;
	
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
		opportunities = new OpportunitiesPage(driver);	
	}
@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}

	@Test
	public void TC15OpportunitesDropdown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunitiesTab();
		opportunities.verifyOpportunitesDropdown();
		
	}
	
	@Test
	public void TC16CreateNewOpportunity() throws InterruptedException {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunitiesTab();
		opportunities.clickNewbutton();
		opportunities.enterIntoOpptysName();        
		opportunities.clickOnAccountNameLookUp();
		opportunities.enterIntoCloseDate();    			
		opportunities.enterIntoStage();        			
		opportunities.enterIntoProbability();  			
		opportunities.enterIntoLeadSource();
		opportunities.clickOnPriCampaignSrcLookup();  
		opportunities.clickOnOpptysSave();
	}
	
	@Test
	
	public void TC17OpportyPipelineReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunitiesTab();
		opportunities.clickOnOpportunitiesPipelinelink();  
		
	}
	
	@Test
	public void TC18StuckOpportunity() {    
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunitiesTab();
		opportunities.clickOnStuckOpportunitieslink();
	}
	
	@Test
	public void TC19TestQuartlySummaryReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunitiesTab();
		opportunities.clickOnQuartlySummaryReports();       
																
	}

	
}

//opportunities.enterIntoAccountName();
//opportunities.switchToChildWindow();
//opportunities.switchToSearchframe(); 
//opportunities.enterIntoSearchField();
//opportunities.clickGo();
//opportunities.switchtoResultsframe();   			//frame[@id='resultsFrame']
//opportunities.selectAcctNameFromLookUpTable(); 		//table[@class='list']/tbody/tr[4]/th and .click();
//opportunities.switchToParentWindow();
//

//opportunities.switchtoPriCampaignSrcframe();    
//opportunities.enterIntoSearchTab();    			
//opportunities.clickOnGoButton();  				
//opportunities.selectFromPriCampLookUpTable();  	
//opportunities.clickOnOpptysSave();  			
//
