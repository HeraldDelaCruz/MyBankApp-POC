package com.myBank.utility;

import static org.junit.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.myBank.utility.BaseClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.myBank.pages.*;

public class Utils extends BaseClass{
	static AndroidDriver driver;
	
	public Utils(AndroidDriver driver) {
		this.driver = driver;
		
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
				Reporter.log("Element not displayed",true);
			}
			}
			
		
		else if (element[0] == "accessibilityId") {
			try {
				WebElement elem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				elem.click();
				isClicked = true;
			}
			catch(NoSuchElementException e) {
				Reporter.log("Element not displayed",true);
			}
			}
		
		else {
			try {
				WebElement elem = driver.findElement(AppiumBy.xpath(element[1]));
				elem.click();
				isClicked = true;
			}
			catch(NoSuchElementException e) {
				Reporter.log("Element not displayed",true);
			}
			}
		
		if (isClicked == true) {
			Reporter.log(element[2] + " was clicked",true);
			}
		
		else {
			Reporter.log(element[2] + " was NOT clicked",true);
			softAssert.fail(element[2] + " was NOT clicked");
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
				Reporter.log("Element is not displayed",true);
				
			}
		}
		
		else if (element[0] == "accessibilityId") {
			try {
				webElem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log("Element is not displayed",true);
				
			}
		}
		else {
			try {
				webElem = driver.findElement(AppiumBy.xpath(element[1]));
				isDisplayed = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log("Element is not displayed",true);
		}
			
		if (isDisplayed == true) {
			Reporter.log(element[2] + " text is displayed",true);
		}
		
		else {
			Reporter.log(element[2] + " text is NOT displayed",true);
			softAssert.fail(element[2] + " text is NOT displayed");
			}
		}
	}


	public void sendTextToField(String[] element,String amount) 
		{
		WebElement webElem;
	
		boolean isSent = false;
	
		if (element[0] == "id") {
			try {
				webElem = driver.findElement(AppiumBy.id(element[1]));
				webElem.sendKeys(amount);
				isSent = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log("Element is not displayed",true);	
				}
			}	
		else if (element[0] == "accessibilityId") {
			try {
				webElem = driver.findElement(AppiumBy.accessibilityId(element[1]));
				webElem.sendKeys(amount);
				isSent = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log("Element is not displayed",true);	
				}
			}
		else {
			try {
				webElem = driver.findElement(AppiumBy.xpath(element[1]));
				webElem.sendKeys(amount);
				isSent = true;
				}
			catch (NoSuchElementException e) {
				Reporter.log("Element is not displayed",true);	
				}
		
		if (isSent == true) {
			Reporter.log(element[2] + " text was Sent",true);
		}
		
		else {
			Reporter.log(element[2] + " text was NOT Sent",true);
			softAssert.fail(element[2] + " text was NOT Sent");
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
			Reporter.log("text not found", true);
			}
		}
	
	public void navigateBack() {
		driver.navigate().back();
		Reporter.log("Navigated to Previous page");
	}
	 
}	 	