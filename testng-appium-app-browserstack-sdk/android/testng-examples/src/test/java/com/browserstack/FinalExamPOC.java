package com.browserstack;


import java.text.DecimalFormat;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myBank.methods.HomePageMethods;
import com.myBank.pages.AppObjects;
import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;
import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;


public class FinalExamPOC extends BaseClass {
	
	@Test
	public void myBank_01() {
		
    	Reporter.log("    ",true);
    	Reporter.log("Test case 1 Start",true);
    	
    	utils.waitApptoLoad();
    	
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	Reporter.log("Verify 'Banking System' text from header if Displayed:",true);
    	homePageMethods.validateBankText();
	
    	Reporter.log("Get and log the accounts listed in the page:",true);
    	homePageMethods.getAccountNum();    	
    	
    	Reporter.log("Test case 1 : Finished",true);
    	Reporter.log("    ",true);
    	
    }
	
    @Test
    public void myBank_02() {
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 2 Start",true);
    	
    	utils.waitApptoLoad();
    	
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	String[] user = testData.ShebonDetails; // testData
    	Reporter.log("Navigate User: " + user[0], true);
    	userDetailsPageMethods.clickOnUser(user);
    	
    	Reporter.log("Validate Users details field if displayed:", true);
    	userDetailsPageMethods.validateUserDetails(user);
    	   	
    	Reporter.log("Test case 2 : Finished",true);
    	Reporter.log("    ",true);
    
    }
    
	@Test
    public void myBank_03() throws Exception {
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 3 Start",true);
    	
    	utils.waitApptoLoad();
    
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	String[] sender = testData.NikitaDetails; // testData : sender Nikita
    	String[] receiver = testData.ShebonDetails; // testData : user Shebon
    	float amount =  (float) TestData.excelTestData(1,5,0); // testData : amount 500.00
    	
    	Reporter.log("Navigate User: " + sender[0] + " as Sender", true);
    	userDetailsPageMethods.clickOnUser(sender);
    	
    	Reporter.log("Processing Transfer of Money",true);
    	userDetailsPageMethods.transferMoney(amount,sender,receiver);
    	
        Reporter.log("Test case 3 : Finished",true);
        Reporter.log("    ",true);
    	
      
        Reporter.log("    ",true);
        Reporter.log("Test case 4 Start",true);
        
        Reporter.log("Navigate Transaction History Page",true);
    	appObjects.clickOnElement(appObjects.History);
    	
    	Reporter.log("Checking Transaction History Page",true);
    	userDetailsPageMethods.checkTransactionHistory(amount,sender,receiver);
        
    	Reporter.log("Test case 4 : Finished",true);
    	Reporter.log("    ",true);


    }	
      
    
}
    
    
    
    
    




