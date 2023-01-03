package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import com.training.base.BasePage;

public class RandomPage extends BasePage{

	public RandomPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[@class='currentStatusUserName']") WebElement namelink;
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']") WebElement editProfile;
	
//	@FindBy(xpath="//img[@alt='Edit Profile' and @xpath='1']") WebElement editProfile;
	
	@FindBy(xpath="//input[@value='Dismiss All']") WebElement popup;
	
	@FindBy(xpath="//input[@id='lastName']") WebElement lastname;
	
	@FindBy(xpath="//img[@class='allTabsArrow']") WebElement allTab;
	
	@FindBy(xpath="//input[@value='Customize My Tabs']") WebElement custMyTab;
	
	@FindBy(xpath="//select[@id='duel_select_1']/option[3]") WebElement selectFromSelectorTab;   //have selected Subscriptions tab from selectors Tab
	
	@FindBy(id="duel_select_0_left") WebElement clickRemove;
	
	@FindBy(xpath="//input[@class='btn primary']") WebElement saveButton;
	
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement nameLink;
	
	
//**************************************************************************//
	public void clickOnNameLink() {
		waitForElement(20, namelink);
		clickObj(namelink,"namelink");
	
	}

	public void enterLastname() {
		
		waitForElement(10, lastname);
		lastname.clear();
		lastname.sendKeys("ABCD");
	}

	public void clickOnAllTabs() {
		waitForElement(20, allTab);
		clickObj(allTab,"allTab");
		String TabTitle = driver.getTitle();
		System.out.println(TabTitle);
	}

	public void clickOnCustomizeMyTab() {
		waitForElement(20, custMyTab);
		clickObj(custMyTab,"Customize My Tab");
	}

	public void selectATabFromSelectedTab() {
		waitForElement(20, selectFromSelectorTab);
		clickObj(selectFromSelectorTab,"Select from Selector Tab");	
	}
	
	public void clickOnremove() {
		waitForElement(20, clickRemove);
		clickObj(clickRemove,"Click Remove");
	}

	public void clickOnSavebutton() {
		waitForElement(20, saveButton);
		clickObj(saveButton,"Save Button");
	}

	public void clickOnFirstLastNameLink() {
		waitForElement(20, nameLink);
		clickObj(nameLink,"Name Link Button");
		
	}

//	public void clickOnEditProfile() throws InterruptedException {
//		String parentWindow = driver.getWindowHandle(); 
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); 
//		}
//		Thread.sleep(2000);
//		if (popup.isDisplayed()) {
//			popup.click(); 
//			driver.switchTo().window(parentWindow);	  
//		}		  
			   


}
