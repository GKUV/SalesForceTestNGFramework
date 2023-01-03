package com.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Accounts']") WebElement accountTab;
	
	@FindBy(xpath="//input[@name='new']") WebElement newAccountbutton;
	
	@FindBy(xpath="//input[@name='acc2']") WebElement newaccountname;
	
	@FindBy(id="acc6") WebElement selectTechPartnerFromDropdown;
	
	@FindBy(id="00N5g00000bxNPm") WebElement setCustPriority;
	
	@FindBy(xpath="//a[text()='Create New View']") WebElement newView;
	
	@FindBy(id="fname") WebElement viewName;
	
	@FindBy(id="devname") WebElement viewUniqueName;
	
	@FindBy(xpath="(//input[@class=\"btn primary\"])[2]") WebElement viewSave;
	
	@FindBy(xpath="//select[@id='fcf']") WebElement selectView;
	
	@FindBy(id="fcf") WebElement selectViewdrop;
	
//	@FindBy(xpath="//option[contains(text(),'NewSalesforceView')]") WebElement selectView;
	
	@FindBy(xpath="//a[text()='Edit']") WebElement editview;
	
	@FindBy(xpath="//select[@id='fcol1']") WebElement field;
	
	@FindBy(xpath="//select[@id='fop1']") WebElement operator;
	
	@FindBy(xpath="//input[@name='fval1']") WebElement value;
	
	@FindBy(xpath="//a[text()='Merge Accounts']") WebElement mergeAccountslink;
	
	@FindBy(xpath="//input[@id='srch']") WebElement mergeAccountsName;
	
	@FindBy(xpath="//input[@name='srchbutton']") WebElement findAccounts;
	
	@FindBy(xpath="//input[@id='cid0']") WebElement firstCheckbox;
	
	@FindBy(xpath="//input[@id='cid1']") WebElement SecondCheckbox;
	
	@FindBy(xpath="(//input[@name='goNext'])[2]") WebElement nextbutton;
	
	@FindBy(xpath="(//input[@title='Merge'])[1]") WebElement mergeButton;
	
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]") WebElement lastActivitylink;
	
	@FindBy(xpath="//img[@id='ext-gen148']") WebElement dateFieldDropdown;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]") WebElement createdDate;     ////input[@id='ext-gen20']
	
	@FindBy(xpath="//input[@name='startDate']") WebElement startDate;
	
	@FindBy(xpath="//img[@id='ext-gen152']") WebElement fromCalendarimg;
	
	@FindBy(xpath="//button[@id='ext-gen283']") WebElement fromTodaysDate;
	
	@FindBy(xpath="//img[@id='ext-gen154']") WebElement toCalendarimg;
	
//	@FindBy(xpath="//button[@id='ext-gen301']") WebElement toTodaysDate;   //its changing dynamically
	
	@FindBy(xpath="//table[@id='ext-comp-1112']/tbody/tr[2]/td[2]/em/button") WebElement toTodaysDate;
	
	@FindBy(xpath="//button[@id='ext-gen49']") WebElement unsavedReportSaveclick;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']") WebElement reportName;
	
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']") WebElement uniqueReportName;
	
	@FindBy(xpath="//button[contains(text(),'Save and Run Report')]") WebElement saveAndRun;
	
	
//*********************************************************//	

	public void clickOnAccountsTab() {
		waitForElement(10,accountTab);
		accountTab.click();	
	}

	public void clickOnNewAccount() {
		waitForElement(10,newAccountbutton);
		newAccountbutton.click();	
	}

	public void enterIntoAccountName() {
		waitForElement(10,newaccountname);
		newaccountname.sendKeys("Vidhu");
	}

	public void selectFromDropdown() {
		Select type = new Select(selectTechPartnerFromDropdown);
		type.selectByVisibleText("Technology Partner");
	}

	public void setPriority() {
		Select priority = new Select(setCustPriority);
		priority.selectByVisibleText("High");
		
	}

	public void clickOnCreateNewView() {
		waitForElement(20,newView);
		newView.click();
	}
	
	public void enterIntoViewName() {
		waitForElement(20,viewName);
		viewName.clear();
		viewName.sendKeys("SFView");
		
	}

	public void enterIntoUniqueName() {
		waitForElement(20,viewUniqueName);
		viewUniqueName.clear();
		viewUniqueName.sendKeys("SF_1");
		
	}

	public void clickOnSave() {
		viewSave.click();
		
	}

	public void selectViewFromViewDrop() {
		waitForElement(20,selectView);
		selectView.click();
		
		Select view = new Select(selectViewdrop);
//		view.selectByVisibleText("SFView");
		view.selectByIndex(4);
		
	}
	


	public void clickOnEditlink() {
		waitForElement(20,selectView);
		editview.click();
		
	}

	public void editViewName() {
		waitForElement(20,viewName);
		viewName.clear();
		viewName.sendKeys("NewSalesforceView");
		
	}

	public void selectfield() {
		Select viewfield = new Select(field);
		viewfield.selectByVisibleText("Billing City");
	}

	public void selectOperator() {
		Select viewoperator = new Select(operator);
		viewoperator.selectByVisibleText("contains");
		
	}

	public void selectValue() {
		value.sendKeys("a");
		
	}
	
//*************************************************************	
	public void clickOnMergeAccountLink() {
		waitForElement(20,mergeAccountslink);
		mergeAccountslink.click();
		
	}

	public void enteraccount() {
		waitForElement(20,mergeAccountsName);
		mergeAccountsName.sendKeys("Vidhu");
		
	}

	public void clickOnFindAccounts() {
		waitForElement(20,findAccounts);
		findAccounts.click();
		
	}

	public void checkonaccountsToBeMerged() {
		waitForElement(20,firstCheckbox);
		firstCheckbox.click();
		waitForElement(20,SecondCheckbox);
		SecondCheckbox.click();
		
	}

	public void clickOnNext() {
		waitForElement(20,nextbutton);
		nextbutton.click();
		
	}

	public void clickOnMergebutton() {
		waitForElement(40,mergeButton);
		mergeButton.click();
		
	}

	public void clickOkOnPopUp() {
		driver.switchTo().alert().accept();
		
	}
//*************************************************************

	public void clickOnAccountsWithLastActivity() {
		waitForElement(20, lastActivitylink);
		lastActivitylink.click();
		
	}

	public void selectCreatedDateFromDateFieldDropdown() {
		waitForElement(20, dateFieldDropdown);
		dateFieldDropdown.click();
		waitForElement(20, createdDate);
		createdDate.click();
		
		
	}

//	public void selectTodaysDateInFrom() {
//		waitForElement(20, fromCalendarimg);
//		fromCalendarimg.click();
//		waitForElement(30, fromTodaysDate);
//		fromTodaysDate.click();
//	}
	
	public void selectTodaysDateInFrom() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		startDate.sendKeys("10/28/2022");

	}

	public void selectTodaysDateInTo() {
		waitForElement(20, toCalendarimg);
		toCalendarimg.click();
//		waitForElement(20, toTodaysDate);
		toTodaysDate.click();
		
	}

	public void clickOnSaveButton() {
		waitForElement(10, unsavedReportSaveclick);
		unsavedReportSaveclick.click();
		
	}

	public void enterIntoReportName()  {
//		String parentWindow = driver.getWindowHandle();
		for(String winHandle:driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		waitForElement(20, reportName);
		reportName.clear();
		reportName.sendKeys("AccountReport");
				
	}

	public void enterIntoUniqueReportName() {
		waitForElement(20, uniqueReportName);
		uniqueReportName.clear();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		uniqueReportName.sendKeys("Report_1");
		
	}

	public void clickOnSaveAndRunReport() {
		waitForElement(20, saveAndRun);
		saveAndRun.click();
		
	}

	


}
