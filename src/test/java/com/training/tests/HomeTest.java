package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String password;
	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		email = common.getproperty("email");
		password = common.getproperty("password");
		driver= getDriver("chrome");
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}
	
@AfterMethod
	
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
	
	
	@Test
	public void TC05validateHomeScreen() {
		
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnLogout();
		
		
	}
	
	@Test
	public void TC06validateMyProfileOptions() throws InterruptedException {      //working  except cropping photo
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnMyProfile();
		Thread.sleep(3000);
		home.clickOnEditProfile();     //Edit Profile
		Thread.sleep(3000);
		home.switchToAboutTabframe();
		home.clickOnAboutTab();
		home.enterLastname();
		home.clickSaveAll();
		
		home.clickOnPostlink();      //Post link options
		home.enterIntoPostText();
		
		home.clickOnFilelink();     //File link options
		home.clickOnUploadfromComputer();  
		Thread.sleep(3000);
		home.mousehoverOverPhoto();  //Add photo link
		home.photoUpload();					
	
	}
	
	@Test
	public void TC07MySettingsOptionFromUserMenu() {    //note: before running this Remove Reports from Selected Tabs & save
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnMySettings();
		home.clickOnPersonalLink();
		home.clickOnLoginHistory();
		home.clickOnDownloadHistory();
		//Display And Layout
		home.clickOndisplayAndlayout();
		home.clickOnCustomizeTab();
		home.selectFromCustomApp();
		home.selectFromAvailableTab();
		home.clickOnAddButton();
		home.clickOnSaveDisplay();
		//email settings
		home.clickOnEmaillink();
		home.clickOnEmailSetting();
		home.enterIntoEmailName();
		home.enterIntoEmail();
		home.clickOnAutobcc();
		home.clickOnEmailSaveButton();
		//calendar and Reminder 	
		home.clickOnCalendarlink();
		home.clickOnActivityReminder();
		home.clickOnOpenTestReminder();
	}
	
	@Test
	public void TC08DeveloperConsoleFromUserMenu() throws InterruptedException {    //working
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnDeveloperConsole();	
	}
	
	@Test
	public void TC09LogoutFromUserMenu() {           //
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserMenudropdown();
		home.clickOnLogout();
	}
	
	
	

}
