package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath="//span[@class='fBody']/select[@id='fcf']") WebElement selectView;
	
	@FindBy(xpath="//select[@id='fcf']") WebElement selectviewOption;

	@FindBy(xpath="//input[@class='btn' and @title='Go!']") WebElement viewGo;
	
	@FindBy(xpath="//img[@class='pageTitleIcon']") WebElement leadsTitle;
	
	@FindBy(xpath="//input[@value=' New ']") WebElement newLead;
	
	@FindBy(id="name_lastlea2") WebElement leadLastname;
	
	@FindBy(id="lea3") WebElement leadCompanyname;
	
	@FindBy(xpath="//input[@name='save'][1]") WebElement saveLead;
	
//**********************************************************//
	
	public void validateviewdropdown() {
		waitForElement(20, selectView);
		selectDropdown(selectView,"ViewDrop");
		String viewlist = selectView.getText();
		System.out.println(viewlist);
		
		
	}

	public void selectfromViewDrop() {
		waitForElement(20,selectviewOption);
		selectByVisibleText(selectviewOption,"My Unread Leads");
		String unreadLeadTitle = driver.getTitle();
		System.out.println("unreadLeadTitle: "+ unreadLeadTitle);
		
	}

	public void clickOnGo() {
		waitForElement(20, viewGo);
		clickObj(viewGo,"ViewGo");
		
	}
	
	public void clickOnTodaysLead() {
		waitForElement(20, selectviewOption);
		selectByVisibleText(selectviewOption,"Today's Leads");
		String leadsTitle = driver.getTitle();
		System.out.println("leadsTitle: "+ leadsTitle);
	}

	public void clickOnNewRecentLeads() {
		waitForElement(20, newLead);
		clickObj(newLead,"NewLead");
	}

	public void enterIntoLeadLastname() {
		waitForElement(20, leadLastname);
		enterText(leadLastname,"ABCDE");
	}

	public void enterIntoCompanyName() {
		waitForElement(20, leadCompanyname);
		enterText(leadCompanyname, "ABCDE");	
	}

	public void clickOnLeadsSave() {
		waitForElement(20, saveLead);
		enterText(saveLead, "Save Lead");
		
	}
	
}
