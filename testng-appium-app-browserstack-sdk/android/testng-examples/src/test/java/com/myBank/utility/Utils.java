package com.myBank.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utils extends BaseClass{
	public static AndroidDriver driver;
	
	public Utils(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void waitApptoLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickOnElement(String[] element) throws IOException 
	{
		boolean isClicked = false;
		
		if (element[0] == "id") {
			try {
				WebElement elem = driver.findElement(AppiumBy.id(element[1]));
				elem.click();
				isClicked = true;
			}
			catch(NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+"Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
			}
			}
			
		
		else if (element[0] == "accessibilityId") {
			try {
				WebElement elem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				elem.click();
				isClicked = true;
			}
			catch(NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
			}
			}
		
		else {
			try {
				WebElement elem = driver.findElement(AppiumBy.xpath(element[1]));
				elem.click();
				isClicked = true;
			}
			catch(NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
			}
			}
		
		if (isClicked == true) {
			Reporter.log(" - PASSED : " + element[2] + " was clicked",true);
			}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " was NOT clicked",true);
			softAssert.fail(" - FAILED : " + element[2] + " was NOT clicked");
			utils.getScreenShot();
		}
	}
	

	public void assertTextIsDisplayed(String[] element) throws IOException 
		{
		WebElement webElem;
		boolean isDisplayed = false;
		
		if (element[0] == "id") {
			try {
				webElem = driver.findElement(AppiumBy.id(element[1]));
				webElem.isDisplayed();
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
			}
		}
		
		else if (element[0] == "accessibilityId") {
			try {
				webElem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				webElem.isDisplayed();
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
				
			}
		}
		else {
			try {
				webElem = driver.findElement(AppiumBy.xpath(element[1]));
				webElem.isDisplayed();
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
		}
			
		if (isDisplayed == true) {
			Reporter.log(" - PASSED : " + element[2] + " text is displayed",true);
		}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " text is NOT displayed",true);
			softAssert.fail(" - FAILED : " + element[2] + " text is NOT displayed");
			utils.getScreenShot();
			}
		}
	}


	public void sendTextToField(String[] element,String amount) throws IOException 
		{
		WebElement webElem;
	
		boolean isKeyin = false;
	
		if (element[0] == "id") {
			try {
				webElem = driver.findElement(AppiumBy.id(element[1]));
				webElem.sendKeys(amount);
				isKeyin = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
				}
			}	
		else if (element[0] == "accessibilityId") {
			try {
				webElem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				webElem.sendKeys(amount);
				isKeyin = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
				}
			}
		else {
			try {
				webElem = driver.findElement(AppiumBy.xpath(element[1]));
				webElem.sendKeys(amount);
				isKeyin = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				utils.getScreenShot();
				}
		
		if (isKeyin == true) {
			Reporter.log(" - PASSED : " + element[2] + " text is entered",true);
		}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " text is NOT entered",true);
			softAssert.fail(" - FAILED : "+ element[2] + " text is NOT entered");
			utils.getScreenShot();
			}
		}
	}
	 
	public static void scrollDown() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 450, "width", 200, "height", 950,
			    "direction", "DOWN",
			    "percent", 10
				));
		}
	
	
	public static void scollToText(String text) throws IOException {
		try {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : Failed to navigate element, Element NOT found", true);
			softAssert.fail(" - FAILED : to navigate element, Element NOT found");
			utils.getScreenShot();
			}
		}
	
	public void navigateBack() {
		driver.navigate().back();
		Reporter.log("Navigate to Previous page");
	
	}
	
	
	public void getAssertions() {
		softAssert.assertAll();
	};
	
	
	public void getScreenShot() throws IOException {
		//Date currentDate = new Date();
		String ssFileName = new SimpleDateFormat("MMddyyyy-hhmmss").format(new Date());

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\CapturedScreenshot\\FailedTests\\Failed - " +ssFileName+ ".png";
		File destinationFile = new File(destination);
		
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			} 
		catch (IOException e) {
			Reporter.log(" - Failed to capture screenshot , " + e.getMessage());
		}
	}
	
	
	
}	 	