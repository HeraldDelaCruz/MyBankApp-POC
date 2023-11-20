package com.browserstack;

import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.utility.Utils;


public class ViewAcccount extends BaseClass {

    @Test
    public void viewAccount() throws Exception {
    	
    	appObjects = new AppObjects(driver);
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Utils.waitApptoLoad();
    	
    	//click on View Account
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//verify BANKING SYSTEM text is displayed
    	appObjects.BankingSystemTextIsDisplayed();
    	
    }
}

//MyBank_01
//Step 1: Launch MyBank app using .apk file.
//Step 2: Click on View accounts
//Step 3: Validate Banking System is displayed on Top
//Step 4: Log the number of account displayed in TestNg report.

