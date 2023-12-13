package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;

public class FinalExamPOC_MyBank_03 extends BaseClass{

	@Test
    public void myBank_03() throws Exception {
		String[] sender =  testData.NikitaDetails; // testData : sender Nikita
    	String[] receiver = testData.ShebonDetails; // testData : receiver Shebon
    	float amount =  (float) TestData.amountTestData(); // testData : amount 550.00 
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 3 Start",true);
    	    
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	Reporter.log("Navigate User: " + sender[0] + " as Sender", true);
    	userDetailsPageMethods.clickOnUser(sender);
    	
    	Reporter.log("Processing Transfer of Money with amount: " +amount,true);
    	userDetailsPageMethods.transferMoney(amount,sender,receiver);
    	
        Reporter.log("Test case 3 : Finished",true);
        Reporter.log("    ",true);
        
    	}
    	
	}
	
