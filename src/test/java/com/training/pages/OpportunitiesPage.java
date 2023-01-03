package com.training.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunitiesPage extends BasePage{

	public OpportunitiesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='Opportunities Tab']") WebElement opptysTab;

	@FindBy(xpath="//select[@id='fcf']") WebElement opptysDropdown;
	
	@FindBy(xpath="//input[@value=' New ']") WebElement newOpptyButton;
	
	@FindBy(xpath="//input[@id='opp3']") WebElement opptyName;
	
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']") WebElement accountLookup;
	
	@FindBy(xpath="//frame[@title='Search']") WebElement searchframe;
	
	@FindBy(xpath="//input[@id='lksrch' and @type='text']") WebElement enterText;
	
	@FindBy(xpath="//input[@value=' Go! ']") WebElement pressGo;
	
	@FindBy(xpath="//frame[@id='resultsFrame']") WebElement accountiframe;
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a") WebElement selectAccountName;
	
	@FindBy(xpath="//span[@class='dateFormat']") WebElement selectCloseDate;  
	
//	@FindBy(xpath="//input[@id='opp9']") WebElement selectCloseDate;  //to select from the calendar
	
	@FindBy(xpath="//select[@id='opp11']") WebElement selectStage;
	
	@FindBy(xpath="//input[@id='opp12']") WebElement probability;
	
	@FindBy(xpath="//select[@id='opp6']") WebElement leadSource;
	
//	@FindBy(xpath="//img[@title='Primary Campaign Source Lookup (New Window)']") WebElement priCampLookup;
	
	@FindBy(xpath="//a[@id='opp17_lkwgt']") WebElement priCampLookup;
	
	@FindBy(xpath="//frame[@title='Search']") WebElement priCampiframe;
	
	@FindBy(xpath="//frame[@id='resultsFrame']") WebElement resultsFrame;
	
	@FindBy(xpath="//input[@placeholder='Search...']") WebElement priCampsearchTab;
	
	@FindBy(xpath="//input[@value=' Go! ']") WebElement clickGo;
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a") WebElement priCampTable;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']") WebElement opptySave;
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]") WebElement pipeline;
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]") WebElement stuck;
	
	@FindBy(xpath="//select[@id='quarter_q']/option[2]") WebElement intervalOption;   //just change the option number for diff option
	
	@FindBy(xpath="//select[@id='open']/option[2]") WebElement includeOption;        //same here, change the option number for diff 
	
	@FindBy(xpath="//input[@value='Run Report']") WebElement runReport;
	
	
//*******************************************************************
	public void clickOnOpportunitiesTab() {
		waitForElement(40,opptysTab);
		opptysTab.click();
		
	}

	public void verifyOpportunitesDropdown() {
		waitForElement(30,opptysDropdown);
		String listOfOpptysDropdown = opptysDropdown.getText();
		System.out.println(listOfOpptysDropdown);
		
	}

	public void clickNewbutton() {
		waitForElement(20,newOpptyButton);
		newOpptyButton.click();
	}

	public void enterIntoOpptysName() {
		waitForElement(20,opptyName);
		opptyName.sendKeys("TestNGOppty");
		
	}

	public void clickOnAccountNameLookUp() {
		
		waitForElement(20,accountLookup);
		accountLookup.click();
		
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] window = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]);
		
		waitForElement(20,searchframe);
		driver.switchTo().frame(searchframe);
		
		waitForElement(20,enterText);
		enterText.sendKeys("*HE");
		
		waitForElement(20,pressGo);
		pressGo.click();
		
		driver.switchTo().defaultContent();
		
		waitForElement(20,resultsFrame);
		driver.switchTo().frame(resultsFrame);
		
		waitForElement(20,selectAccountName);
		selectAccountName.click();
		
		driver.switchTo().window(window[0]);
		
	}
	
	public void switchToChildWindow() {
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] window = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]);
	}
	
	
		
	
	public void enterIntoSearchField() {
		waitForElement(20,enterText);
		enterText.sendKeys("*HE");
	}

	public void clickGo() {
		waitForElement(20,pressGo);
		pressGo.click();
		driver.switchTo().defaultContent();
	}
	
	public void switchtoResultsframe() {
		waitForElement(20,resultsFrame);
		driver.switchTo().frame(resultsFrame);
		
	}
	
	public void selectAcctNameFromLookUpTable() {
		waitForElement(20,selectAccountName);
		selectAccountName.click();
		driver.switchTo().defaultContent();
	//	driver.switchTo().window(window[0]);
		
	}
	
	public void enterIntoCloseDate() {
		waitForElement(20,selectCloseDate);
		selectCloseDate.click();
//		selectCloseDate.clear();
//		selectCloseDate.sendKeys("11/8/2022");
//		
	}

	public void enterIntoStage() {
		waitForElement(20,selectStage);
		Select stage = new Select(selectStage);
		stage.selectByIndex(3);

		
	}

	public void enterIntoProbability() {
		waitForElement(20,probability);
		probability.clear();
		probability.sendKeys("30");
		
	}

	public void enterIntoLeadSource() {
		waitForElement(20,leadSource);
		Select leadSrc = new Select(leadSource);
		leadSrc.selectByIndex(2);
		
	}

	
	public void clickOnPriCampaignSrcLookup() {
		waitForElement(20, priCampLookup);
		priCampLookup.click();
		
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] window = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]);
		
		waitForElement(20,searchframe);
		driver.switchTo().frame(searchframe);
		
		waitForElement(20,priCampsearchTab);
		priCampsearchTab.sendKeys("*a");
		
		waitForElement(20,clickGo);
		clickGo.click();
		
		driver.switchTo().defaultContent();
		
		waitForElement(20,resultsFrame);
		driver.switchTo().frame(resultsFrame);
		
		waitForElement(20,priCampTable);
		priCampTable.click();
		
		driver.switchTo().window(window[0]);
		
	}

	
	public void enterIntoSearchTab() {
		
		waitForElement(20,priCampsearchTab);
		priCampsearchTab.sendKeys("*a");	
	}

	public void clickOnGoButton() {
		waitForElement(20,clickGo);
		clickGo.click();
	}
	
	public void selectFromPriCampLookUpTable() {
		waitForElement(20,priCampTable);
		priCampTable.click();
	}

	public void clickOnOpptysSave() {
		waitForElement(20,opptySave);
		opptySave.click();
	}

	public void switchToSearchframe() {
		waitForElement(20,searchframe);
		driver.switchTo().frame(searchframe);
	}

	public void enterIntoAccountName() {
		WebElement acctName = driver.findElement(By.xpath("//input[@id='opp4']"));
		waitForElement(20,acctName);
		acctName.sendKeys("Vidhu HE");
		
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] window = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]);
		
		waitForElement(20,searchframe);
		driver.switchTo().frame(searchframe);
		
		waitForElement(20,priCampsearchTab);
		priCampsearchTab.sendKeys("*a");
		
		waitForElement(20,clickGo);
		clickGo.click();
		
		driver.switchTo().defaultContent();
		
		waitForElement(20,resultsFrame);
		driver.switchTo().frame(resultsFrame);
		
		waitForElement(20,priCampTable);
		priCampTable.click();
		
		driver.switchTo().window(window[0]);
		
	}


	public void clickOnOpportunitiesPipelinelink() {
		waitForElement(20, pipeline);
		pipeline.click();
		
	}

	public void clickOnStuckOpportunitieslink() {
		waitForElement(20, stuck);
		stuck.click();
		
	}

	public void clickOnQuartlySummaryReports() {
		waitForElement(20, intervalOption);
		intervalOption.click();
		waitForElement(20, includeOption);
		includeOption.click();
		waitForElement(20, runReport);
		runReport.click();
		
		
	}

//***************************************************************************************
	

}

