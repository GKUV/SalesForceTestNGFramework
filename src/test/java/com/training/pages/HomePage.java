package com.training.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;
import com.training.base.BasePage;

public class HomePage  extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		 super(driver);
	 }
	
	@FindBy(id="userNavLabel") WebElement clickOnuserMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']") WebElement userMenudropdown;
	
//	@FindBys(id="userNavLabel", value = { @FindBy }) List<WebElement> clickOnuserMenu;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]") WebElement myProfile;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logout;
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']") WebElement editProfile;
	
	@FindBy(id="contactInfoContentId") WebElement imageframe1;
	
	@FindBy(xpath="//li[@id='aboutTab']") WebElement aboutTab;
	
	@FindBy(id="lastName") WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save All']") WebElement saveAll;
	
	@FindBy(xpath="//span[text()='Post']") WebElement postlink;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']") WebElement postimageframe;
	
	@FindBy(xpath="//body[contains(text(),'@mention')]") WebElement posttext;
	
	@FindBy(id="publishersharebutton") WebElement sharebutton;
	
	@FindBy(xpath="//span[contains(text(),'File') and @class='publisherattachtext ']") WebElement filelink;
	
	@FindBy(id="chatterUploadFileAction") WebElement uploadfromComputer;
	
	@FindBy(id="chatterFile") WebElement choosefile;
	
//	@FindBy(id="photoSection") WebElement mousehovermyprofilephoto;
	
	@FindBy(xpath="//span[@id='displayBadge']") WebElement mousehovermyprofilephoto;
	
	@FindBy(xpath="//a[@id='uploadLink']") WebElement addPhoto;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']") WebElement photoimageframe;
	
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile") WebElement photoChoosefile;
	 
	@FindBy(id="j_id0:uploadFileForm:uploadBtn") WebElement savebutton;
	
	@FindBy(xpath="//input[@id='j_id0:j_id7:save']") WebElement savePhoto;
	 
	@FindBy(xpath="//input[@name='dismiss_all']") WebElement activityRemainder;
	
	@FindBy(xpath="//a[contains(text(),'My Settings')]") WebElement mySettings;
	
	@FindBy(xpath="//div[@id='PersonalInfo']")  WebElement personallink ;
	
	@FindBy(id="LoginHistory_font") WebElement loginhistory ;
	
	@FindBy(xpath="//div[@class='pShowMore']") WebElement downloadhistory ;
	
	@FindBy(id="DisplayAndLayout_font") WebElement displayAndlayout; 
	
	@FindBy(id="CustomizeTabs_font") WebElement customizeTab; 
	
	@FindBy(id="p4") WebElement customApp; 
	
	@FindBy(xpath="//select[@id='duel_select_0']")  WebElement availableTabs; 
	
	@FindBy(id="duel_select_0_right") WebElement clickaddbutton; 
	
	@FindBy(xpath="//input[@class='btn primary']") WebElement savebuttonForDisplay; 
	
	@FindBy(xpath="//span[@id='EmailSetup_font']") WebElement emaillink;
	
	@FindBy(xpath="//a[@id='EmailSettings_font']") WebElement emailsetting;
	
	@FindBy(xpath="//input[@id='sender_name']") WebElement emailName;
			
	@FindBy(xpath="//input[@id='sender_email']") WebElement email;
	
	@FindBy(xpath="//input[@id='auto_bcc1']") WebElement autobcc;
	
	@FindBy(xpath="//input[@value=' Save ']") WebElement emailsavebutton;
	 
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']") WebElement calendarlink; 
	
	@FindBy(xpath="//span[@id='Reminders_font']") WebElement activityreminder;
	
	@FindBy(xpath="//input[@id='testbtn']") WebElement openTestReminder; 
	
	@FindBy(xpath="//a[text()='Developer Console']") WebElement developerconsole;
	
	@FindBy(xpath="//a[@title='Leads Tab']") WebElement leadsTab;
	
	@FindBy(xpath="//a[@title='Contacts Tab']") WebElement contactsTab;
	
	@FindBy(xpath="//a[@title='Home Tab']") WebElement homeTab;
	 
//************************************************************************************************
	public void clickOnDeveloperConsole() {
	
		waitForElement(10,developerconsole);
		developerconsole.click();
	
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		System.out.println("Window size: "+getAllWindows.size());
		driver.switchTo().window(window[1]).close();
	
		driver.switchTo().window(window[0]);
	}
    

//************************************************************************************************

	public void clickuserMenudropdown() {
		waitForElement(20, clickOnuserMenu);
		clickOnuserMenu.click();
		waitForElement(20, userMenudropdown);
		String dropdown = userMenudropdown.getText();
		System.out.println("User Menu dropdown: "+dropdown);
		
		
	}
	
	public void clickOnLogout() {
		waitForElement(20, logout);
		logout.click();
		
	}
	
	public void clickOnMyProfile() {
		waitForElement(10, myProfile);
		myProfile.click();
	//	driver.switchTo().alert();  //Handle popup window here
		
	}
	
	public void clickOnEditProfile() {
		waitForElement(20, editProfile);
		editProfile.click();
		
//		waitForElement(20, imageframe1);
//		driver.switchTo().frame(imageframe1);
//		waitForElement(10, aboutTab);
//		aboutTab.click();
//		waitForElement(10, lastname);
//		lastname.clear();
//		lastname.sendKeys("Abcd");
//		waitForElement(10, saveAll);
//		saveAll.click();	
	}
	
	public void switchToAboutTabframe() {
	
		waitForElement(30, imageframe1);
		driver.switchTo().frame(imageframe1);
	}
	
	public void clickOnAboutTab() {
		waitForElement(10, aboutTab);
		aboutTab.click();
	}
	
	public void enterLastname() {
		waitForElement(10, lastname);
		lastname.clear();
		lastname.sendKeys("Abc");
	}
	
	public void clickSaveAll() {
		waitForElement(10, saveAll);
		saveAll.click();
	}
	
	public void clickOnPostlink() {
		waitForElement(10, postlink);
		postlink.click();
	}
	
//	
//	public void clickElement(postlink) {
//			
//	}
	
	
	public void enterIntoPostText() {
		waitForElement(20,postimageframe);
		driver.switchTo().frame(postimageframe);
		waitForElement(20,posttext);
		posttext.sendKeys("Hello!! Welcome again to Salesforce Automation using TestNG Framework!");
		driver.switchTo().defaultContent();
		waitForElement(20,sharebutton);
		sharebutton.click();

	}
	
	public void clickOnFilelink() {
		waitForElement(10,filelink);
		filelink.click();
		
	}
	
	public void clickOnUploadfromComputer() {
		waitForElement(30,uploadfromComputer);
		uploadfromComputer.click();
		waitForElement(20,choosefile);  //redo the below step by selecting the file from computer
 //		choosefile.sendKeys("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\ReadFile.txt");
 		choosefile.sendKeys("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\TestNG\\TestNG-Salesforce framework\\SFDC 37 Testcases.xlsx");
 		waitForElement(20,sharebutton);
	    sharebutton.click();
		
	}
	
	public void mousehoverOverPhoto() {
		waitForElement(20,mousehovermyprofilephoto);		
		Actions action = new Actions(driver);
		action.moveToElement(mousehovermyprofilephoto).build().perform();
	}
	
	public void photoUpload() throws InterruptedException {
		waitForElement(20,addPhoto);
		addPhoto.click();
		waitForElement(40,photoimageframe);
		driver.switchTo().frame(photoimageframe);
		
		waitForElement(20,photoChoosefile);
//		photoChoosefile.sendKeys("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\TestPhoto.jpg");
		photoChoosefile.sendKeys("C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\Photo.jpg");
		
		waitForElement(20,savebutton);
		savebutton.click();  		
		
		waitForElement(20,savePhoto);
		savePhoto.click();
	}
//***********************************************************************************************************
	
	
	public void clickOnMySettings() {
		waitForElement(20, mySettings);
		mySettings.click();
	}

	public void clickOnPersonalLink() {
		waitForElement(20, personallink);
		personallink.click();
	}
		
	public void clickOnLoginHistory() {
		waitForElement(20, loginhistory);
		loginhistory.click();
	}
		
//		Robot robot = new Robot();
//		robot.mouseWheel(100);

	public void clickOnDownloadHistory() { 
		waitForElement(20, downloadhistory);
		downloadhistory.click();
	}

	public void clickOndisplayAndlayout() {
		
		waitForElement(20, displayAndlayout);
		displayAndlayout.click();
	}	
		
	public void clickOnCustomizeTab() {	
		waitForElement(20, customizeTab);
		customizeTab.click();
	}	
		
//		Select viewoperator = new Select(operator);
//		viewoperator.selectByVisibleText("contains");
	
	public void selectFromCustomApp() {	
		Select  custApp = new Select(customApp);
		custApp.selectByVisibleText("Salesforce Chatter");
	}	
		
	public void selectFromAvailableTab() {
		waitForElement(20,availableTabs);
		Select availTab = new Select(availableTabs);
		availTab.selectByIndex(2);
		
	//	availTab.selectByVisibleText("Reports");
		//
//		List<WebElement> availTabList =  availTab.getOptions();
//		for(int i=0;i<availTabList.size();i++)
//			System.out.println(availTabList.get(i).getText());		
	}
		
	public void clickOnAddButton() {	
		waitForElement(20, clickaddbutton);
		clickaddbutton.click();
	}
		
	public void clickOnSaveDisplay() {
		waitForElement(20, savebuttonForDisplay);
		savebuttonForDisplay.click();
	}
	
//**************************************************************************************
	public void clickOnEmaillink() {
		waitForElement(20, emaillink);
		emaillink.click();
	}	
	
	public void clickOnEmailSetting() {	
		waitForElement(20, emailsetting);
		emailsetting.click();
	}	
	
	public void enterIntoEmailName() {	
		waitForElement(20, emailName);
		emailName.clear();
		emailName.sendKeys("Guruprasad");
	}	
	
	public void enterIntoEmail() {
		waitForElement(20, email);
		email.clear();
		email.sendKeys("kokiguru27@gmail.com");
	}	
		
	public void clickOnAutobcc() {	
		waitForElement(20, autobcc);
		autobcc.click();
	}	
		
	public void clickOnEmailSaveButton() {
		waitForElement(20, emailsavebutton);
		emailsavebutton.click();
	}
	
	//*********************************************************
	public void clickOnCalendarlink() {
		waitForElement(20, calendarlink);
		calendarlink.click();
	}	
		
	public void clickOnActivityReminder() {	
		waitForElement(20, activityreminder);
		activityreminder.click();
	}
		
	public void clickOnOpenTestReminder() {
		waitForElement(20, openTestReminder);
		openTestReminder.click();
	}

	public void clickOnLeadsTab() {
		waitForElement(20, leadsTab);
		clickObj(leadsTab, "Leads Tab");
	}

	public void clickOnContactTab() {
		waitForElement(20, contactsTab);
		clickObj(contactsTab,"contactsTab");
		String contactsTitle = driver.getTitle();
		System.out.println("contactsTitle: "+ contactsTitle);
	}

	public void clickOnHomeTab() {
		
		waitForElement(20, homeTab);
		clickObj(homeTab,"HOME Tab");
	}
	

	//*****************************************************
	
	
}
