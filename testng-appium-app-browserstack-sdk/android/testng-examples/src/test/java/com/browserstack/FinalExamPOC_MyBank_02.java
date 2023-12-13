package com.browserstack;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.utility.BaseClass;

public class FinalExamPOC_MyBank_02 extends BaseClass {

	@Test
    public void myBank_02() throws IOException {
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 2 Start",true);
    	
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	String[] user = testData.MeenakshiDetails; // testData
    	Reporter.log("Navigate User: " + user[0], true);
    	userDetailsPageMethods.clickOnUser(user);
    	
    	Reporter.log("Validate Users details field if displayed:", true);
    	userDetailsPageMethods.validateUserDetails(user);
    	utils.getAssertions();

    	Reporter.log("Test case 2 : Finished",true);
    	Reporter.log("    ",true);
    
    }
	
	
}
