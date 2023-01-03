package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElement(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
/*****************************************************************************************************/ 
	
	
	
	
	
	
	public void clickElement(WebElement element) {
		if (element.isDisplayed()) {
			waitForElement(10, element);
			element.click();
			System.out.println("Element "+element+"clicked");
		 }
		else
			System.out.println("Element "+element+"NOT clicked");
	}
	
	public static void enterText(WebElement element, String textval) {
		if (element.isDisplayed()) {
			element.sendKeys(textval);
			System.out.println("pass--> "+ textval + ": is entered in the field: "+element);
		}
		else
			System.out.println("Fail: field does not exist please check application");

	}

	
	public static void clickObj(WebElement element,String objName){
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass:" +objName + " button is clicked");
		  }
		else {
			System.out.println("Fail: " +objName+" button is not displayed ,please check the application");
		}
	}
	
	public static void selectDropdown(WebElement element, String objName) {
		
		if(element.isDisplayed()) {
			System.out.println("Pass: "+objName+" is  selected");
			element.click();
		} 
		else{
			System.out.println("Fail:"+objName+" is not present.Please chk application");		
		}
		}
	
	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		 }
		 }
	
	public static void SelectByValue(WebElement obj, String val) {
		  if(obj.isDisplayed()) {
			  Select selObj=new Select(obj);
			  selObj.selectByValue(val);
			  System.out.println("pass:"+val + " is selected from drop down ");
//		  logger.log(LogStatus.PASS, " is selected from drop down " );
		 }
		  else {
		   System.out.println("Fail:"+val+"is not selected");
//		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
		 }
	
	public static void selectByIndex(WebElement obj, int index) {
		  if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		  selObj.selectByIndex(index);
		  
		  System.out.println("pass:"+index + " is selected from drop down ");
//		  logger.log(LogStatus.PASS, " is selected from drop down " );
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
//		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
		 }
	

}
