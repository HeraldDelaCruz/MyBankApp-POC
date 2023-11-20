package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.utility.Utils;


public class MyBank_01 extends BaseClass {

    @Test
    public void myBank_01() throws Exception {
    	
    	appObjects = new AppObjects(driver);
    	utils = new Utils(driver);
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	utils.waitApptoLoad();
    	
    	//click on View Account
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
		//verify BANKING SYSTEM text is displayed
    	//appObjects.bankingSystemTextIsDisplayed();
    	utils.assertTextIsDisplayed(appObjects.BankingSystemtxt);
    	
    	//get accountnums
    	appObjects.getAccountNum();
    	
    	System.out.println("Test case 1 : Finished \n");
    }
}

//MyBank_01
//Step 1: Launch MyBank app using .apk file.
//Step 2: Click on View accounts
//Step 3: Validate Banking System is displayed on Top
//Step 4: Log the number of account displayed in TestNg report.

