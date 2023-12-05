package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.myBank.utility.BaseClass;


public class FinalExamPOC_MyBank_01 extends BaseClass {
	
	@Test
	public void myBank_01() {
		
    	Reporter.log("    ",true);
    	Reporter.log("Test case 1 Start",true);
    	
    	utils.waitApptoLoad();
    	
    	Reporter.log("Navigate View Accounts Page",true);
    	utils.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	Reporter.log("Verify 'Banking System' text from header if Displayed:",true);
    	homePageMethods.validateBankText();
	
    	Reporter.log("Get and Log the accounts listed in the page:",true);
    	homePageMethods.getAccountNum();    	
    	
    	Reporter.log("Test case 1 : Finished",true);
    	Reporter.log("    ",true);
    	
    }
      
    
}
    
    
    
    
    




