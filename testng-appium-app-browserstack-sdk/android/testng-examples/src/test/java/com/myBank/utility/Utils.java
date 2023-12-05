package com.myBank.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utils extends BaseClass{
	static AndroidDriver driver;
	
	public Utils(AndroidDriver driver) {
		Utils.driver = driver;
		
	}
	
	
	public void waitApptoLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void clickOnElement(String[] element) 
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
			}
			}
		
		if (isClicked == true) {
			Reporter.log(" - PASSED : " + element[2] + " was clicked",true);
			}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " was NOT clicked",true);
			softAssert.fail(" - FAILED : " + element[2] + " was NOT clicked");
		}
	}
	

	public void assertTextIsDisplayed(String[] element) 
		{
		WebElement webElem;
		boolean isDisplayed = false;
		
		if (element[0] == "id") {
			try {
				webElem = driver.findElement(AppiumBy.id(element[1]));
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
			}
		}
		
		else if (element[0] == "accessibilityId") {
			try {
				webElem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
				
			}
		}
		else {
			try {
				webElem = driver.findElement(AppiumBy.xpath(element[1]));
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log(" - FAILED : "+element[2]+" Element is NOT displayed",true);
				softAssert.fail(" - FAILED : "+element[2]+" Element is NOT displayed");
		}
			
		if (isDisplayed == true) {
			Reporter.log(" - PASSED : " + element[2] + " text is displayed",true);
		}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " text is NOT displayed",true);
			softAssert.fail(" - FAILED : " + element[2] + " text is NOT displayed");
			}
		}
	}


	public void sendTextToField(String[] element,String amount) 
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
				}
		
		if (isKeyin == true) {
			Reporter.log(" - PASSED : " + element[2] + " text is entered",true);
		}
		
		else {
			Reporter.log(" - FAILED : " + element[2] + " text was NOT entered",true);
			softAssert.fail(" - FAILED : "+ element[2] + " text was NOT entered");
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
	
	
	public static void scollToText(String text) {
		try {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : Failed to navigate element, Text NOT found", true);
			softAssert.fail(" - FAILED : to navigate element, Text NOT found");
			}
		}
	
	public void navigateBack() {
		driver.navigate().back();
		Reporter.log("Navigated to Previous page");
	}
	 
}	 	