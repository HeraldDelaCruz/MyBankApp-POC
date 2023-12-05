package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;

public class FinalExamPOC_MyBank_03 extends BaseClass{

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
    	transferPageMethods.checkTransactionHistory(amount,sender,receiver);
        
    	Reporter.log("Test case 4 : Finished",true);
    	Reporter.log("    ",true);
    	}
    	
	}
	
