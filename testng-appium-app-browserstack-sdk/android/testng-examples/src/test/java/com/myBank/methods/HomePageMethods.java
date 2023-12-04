package com.myBank.methods;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.myBank.pages.AppObjects;
import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;
import com.myBank.utility.Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class HomePageMethods extends Utils{
	public static AndroidDriver driver;
	
	public HomePageMethods(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	//TC_01
	public void validateBankText() {
		utils.assertTextIsDisplayed(appObjects.BankingSystem);
		isElementPresent(appObjects.BankingSystem);
	}
	
	public void getAccountNum()  {
		List<WebElement> accountNum = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/CustName"));
		List<WebElement> accountName = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/AccNum"));
		
		int accountCount = accountNum.size()-1;
		String accountCountstr = Integer.toString(accountCount);
		
		for (int i = 0; i < accountNum.size()-1 ; i++) {
			WebElement accountNumbers = accountNum.get(i);
			String accountDetails = accountNumbers.getText();
         
			WebElement accountNames = accountName.get(i);
			String accountNamess = accountNames.getText();
         	
			Reporter.log("PASSED : Account " + (i + 1) + " details : " + accountNamess + " " +accountDetails, true);
	 	}
		
		Reporter.log("PASSED : number of accounts listed: " + accountCountstr, true);
	 }

	
	public void isElementPresent(String[] element) {
        int xloc = 56;
        int yloc = 196;
		
        WebElement elem = driver.findElement(AppiumBy.xpath(element[1])); // (56, 196)

        Point elementLocation = elem.getLocation();
        int elementX = elementLocation.getX();
        int elementY = elementLocation.getY();
        
        if (elementX == xloc && elementY == yloc) {
        	Reporter.log("PASSED : Text is at the correct position",true);
        }
        else {
        	Reporter.log("FAILED : Text is not present in the position",true);
        }
		
    	}
	}
        