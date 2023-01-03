package com.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;

public class LoginPage extends BasePage {
	
	 public LoginPage(WebDriver driver) {
		 super(driver);
	 }
	
	
		@FindBy(id="username")
		WebElement email;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(id="Login")
		WebElement loginButton;
		
		@FindBy(id="rememberUn")
		WebElement rememberMe;
		
		@FindBy(name="continue")
		WebElement continueButton;
		
		@FindBy(id="forgot_password_link")
		WebElement forgetPassword;
		
		@FindBy(id="un")
		WebElement username;
	
	
	public void enterIntoEmail(String stremail) {
		waitForElement(20,email);
		email.sendKeys(stremail);
	}
	
	
	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void clickOnLogin() {
		waitForElement(20, loginButton);
		loginButton.click();
		String expectedtitle = "Home Page ~ Salesforce - Developer Edition";
		String actualtitle = driver.getTitle();
	//	Assert.assertEquals(actualtitle, expectedtitle);
		if (expectedtitle.equalsIgnoreCase(actualtitle))
			System.out.println("User is in Home Page");
		else
			System.out.println("User is not in Home Page");
	}
	
	public void checkRememberMe() {
		rememberMe.click(); 
	}

	
	public void validateUsername() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='idcard-identity']")));
	
		String actualUsername = driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		String expectedUsername = "gkuv1230@tekarch.com";
		Assert.assertEquals(actualUsername, expectedUsername); 
	}
	
	public void clickOnforgotPassword() { 
		forgetPassword.click(); 
	}
	
	public void clickOncontinueButton() {
		waitForElement(10,continueButton);
		continueButton.click();
		
	}

	
	public void enterIntoUsername(String stremail) {
		waitForElement(10,username);
		username.sendKeys(stremail); 
	}
	
	
	
}
