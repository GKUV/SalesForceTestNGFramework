package com.training.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.training.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.FILE_SEPARATOR;
import static com.training.utilities.Constants.SCREENSHOT_PATH;


public class BaseTest {
	
	private WebDriver driver;
	
	public WebDriver getDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		 	WebDriverManager.firefoxdriver().setup();
		 	driver = new FirefoxDriver();
		 	driver.manage().window().maximize();
		}
		return driver;
		
	}
	
	public void takescreenshot(WebDriver driver) {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		
		String reportFilePath = USER_DIR+FILE_SEPARATOR+SCREENSHOT_PATH;
		
		String fileName = "Salesforce"+timestamp+".png";
		String filepath = reportFilePath+FILE_SEPARATOR+fileName;
		
		File destFile = new File(filepath);
		
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/* name of the method:   entertext
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  obj-->object
	 *                      textval--->to be entered 
	 */
	
	public static void enterText(WebElement element, String textval) {
		if (element.isDisplayed()) {
			element.sendKeys(textval);
			System.out.println("pass--> "+ textval + ": is entered in the field: "+element);
		}
		else
			System.out.println("Fail: field does not exist please check application");

	}
	
	public static void clickObj(WebElement element,String objName)
	{
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass:" +objName + " button is clicked");
		}
		else {
			System.out.println("Fail: " +objName+" button is not displayed ,please check the application");
		}
	}
	
	public static void selectCheckBox(WebElement element, String objName) {
		
		if(element.isDisplayed()) {
			if(element.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
			}
			else {
				element.click();
				System.out.println("Pass: "+objName+" is selected");
			}
		    }
			else {
			System.out.println("Fail:"+objName+" is not present.Please chk application");	
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
	
	public static void validateErrormsg(String actualmsg, String errormsg) {
		
		if(actualmsg.equals(errormsg)) {
			System.out.println("TestCase is passed");
		}
		else {
			System.out.println("TestCase is failed");
	    }
	}

	public static void switchFrame(WebDriver driver,WebElement element) {
		 
	    if(element.isDisplayed()) {
	    	driver.switchTo().frame(element);
	    	System.out.println("Pass: we can switch to the "+element+ " frame");
	    }
	     else {
	    	 System.out.println("fail: we can't switch to the "+element+ " frame");
	    }
	}

	public static void switchFrameid( WebDriver driver,String obj) {
		 driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	}

	
	public static void switchdefaultFrame( WebDriver driver) {
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the "+ driver + " back to frame");
	}
	
	public static void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
			Actions action=new Actions(driver);
			action.moveToElement(obj).build().perform();
			System.out.println("Pass: "+obj+" is present");
//		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
//			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
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

	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		 }
		 }

	public static void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
		}else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
		}
	}

}
