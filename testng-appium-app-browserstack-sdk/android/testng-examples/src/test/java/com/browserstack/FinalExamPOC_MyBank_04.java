package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;

public class FinalExamPOC_MyBank_04 extends BaseClass{

	@Test
    public void myBank_04() throws Exception {
		String[] sender =  testData.MeenakshiDetails; // testData : sender Meenakshi
    	String[] receiver = testData.CyrilDetails; // testData : receiver Cyril
    	float amount =  (float) TestData.amountTestData(); // testData : amount 500.00 -->> get random cell or new cell data , 
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 4 Start",true);
    	    
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	Reporter.log("Navigate User: " + sender[0] + " as Sender", true);
    	userDetailsPageMethods.clickOnUser(sender);
    	
    	Reporter.log("Processing Transfer of Money with amount: " +amount,true);
    	userDetailsPageMethods.transferMoney(amount,sender,receiver);
    	     
        Reporter.log("Navigate Transaction History Page",true);
    	appObjects.clickOnElement(appObjects.History);
    	
    	Reporter.log("Checking Transaction History Page",true);
    	transferPageMethods.checkTransactionHistory(amount,sender,receiver);
    	utils.getAssertions();
        
    	Reporter.log("Test case 4 : Finished",true);
    	Reporter.log("    ",true);
    	}
    	
	}
	
