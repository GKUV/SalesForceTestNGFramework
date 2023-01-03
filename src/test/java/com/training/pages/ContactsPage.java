package com.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@value=' New ']") WebElement newContact;
	
	@FindBy(id="name_lastcon2") WebElement contactLastName;
	
	@FindBy(id="con4") WebElement contactAcctName;
	
	@FindBy(xpath="//input[@value=' Save '][1]") WebElement saveNewContact;
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]") WebElement contactsView;
	
	@FindBy(id="fname") WebElement contactsViewName;
	
	@FindBy(id="devname") WebElement contactsUniqueViewName;
	
	@FindBy(xpath="//input[@value=' Save '][1]") WebElement saveContactsView;
	
	@FindBy(id="fcf") WebElement createdView;
	
	@FindBy(xpath="//select[@id='hotlist_mode']") WebElement recentlyCreatedContact;
	
	@FindBy(xpath="//input[@value=' Go! ']") WebElement clickGo;
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a") WebElement viewAContact;  //change the tr[] number based on which contact to be viewed;
	//
	@FindBy(xpath="//div[@class='errorMsg'][1]") WebElement errorMsg;
	
	@FindBy(xpath="//input[@value='Cancel'][1]") WebElement cancelView;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@value='Save & New']") WebElement SaveAndNewButton;
	
//********************************************************************************************************//
	
	public void clickOnNewButton() {
		waitForElement(20, newContact);
		clickObj(newContact,"newContact");
	}

	public void enterIntoLastNameField() {
		waitForElement(20, contactLastName);
		enterText(contactLastName, "Udbhav");
	}

	public void enterIntoAcctNameField() {
		waitForElement(20, contactAcctName);
		enterText(contactAcctName, "Udbhav HE");
	}

	public void clickOnsaveContact() {
		waitForElement(20, saveNewContact);
		clickObj(saveNewContact, "saveNewContact");
		
	}

	public void clickONCreateNewView() {
		waitForElement(20,contactsView);
		clickObj(contactsView,"contactsView");
		
	}

	public void enterIntoViewLastNameField() {
		waitForElement(20, contactsViewName);
		contactsViewName.clear();
		enterText(contactsViewName,"XYZ");
		
	}

	public void enterIntoUniqueViewNameField() {
		
		waitForElement(20, contactsUniqueViewName);
		contactsUniqueViewName.clear();
		enterText(contactsUniqueViewName,"contactsUniqueViewName");
		
	}
	
	public void clickOnViewsaveContact() {
		waitForElement(20, saveContactsView);
		clickObj(saveContactsView,"saveContactsView");
	}

	public void clickOnRecentlyCreateddropdown() {
		waitForElement(20, recentlyCreatedContact);
		selectByVisibleText(recentlyCreatedContact,"Recently Created");
	}

	public void clickOnMyContactsFromDropdown() {
		waitForElement(20, createdView);
		selectByVisibleText(createdView,"My Contacts");
	}
	
	public void clickOnGoButton() {
		waitForElement(20, clickGo);
		clickObj(clickGo,"clickGo");
	}

	public void viewAContactinContactPage() {
		waitForElement(20, viewAContact);
		clickObj(viewAContact, "viewAContact");
		
	}

	public void checkErrorMsginNewView() {
		waitForElement(20, contactsUniqueViewName);
		contactsUniqueViewName.clear();
		enterText(contactsUniqueViewName,"EFGH");
		waitForElement(20, saveContactsView);
		clickObj(saveContactsView,"saveContactsView");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualErrmsg = "Error: You must enter a value";
		String expectedErrMsg = errorMsg.getText();
		System.out.println("actualErrmsg: "+actualErrmsg);
		System.out.println("expectedErrMsg: "+expectedErrMsg);
		Assert.assertEquals(actualErrmsg, expectedErrMsg);
		
	}

	public void checkCancelButton() {
		waitForElement(20, contactsViewName);
		contactsViewName.clear();
		enterText(contactsViewName,"PQR");
		waitForElement(20, contactsUniqueViewName);
		contactsUniqueViewName.clear();
		enterText(contactsUniqueViewName,"EFGH");
		waitForElement(20, cancelView);
		clickObj(cancelView,"cancelView");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	public void checkforSaveAndNewButton() {
		waitForElement(20, contactLastName);
		enterText(contactLastName, "Indian");
		waitForElement(20, contactAcctName);
		enterText(contactAcctName, "Global Media");
		waitForElement(20, SaveAndNewButton);
		clickObj(SaveAndNewButton,"SaveAndNewButton");
		
	}
	
}
