package com.browserstack;

import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.utility.Utils;


public class MyBank_04 extends BaseClass {

    @Test
    public void myBank_04() {
    	
    	appObjects = new AppObjects(driver);
    	utils = new Utils(driver);
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	utils.waitApptoLoad();
    	
    	//click on View Account
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//click on User: Nikita
    	appObjects.clickOnElement(appObjects.Nikita);
    	
    	//validate fields if displayed
    	appObjects.clickOnElement(appObjects.TransferMoneyBtn);
    	
    	//validate fields if displayed
    	appObjects.sendkeys("500");
    	
    	System.out.println("Test case 3 : Finished \n");
    }	
}

//MyBank_04
//Step 1: Launch MyBank app using .apk file.
//Step 2: Click on View accounts
//Step 3: Click on arrows on right side 
//Step 4: Validate the transaction you did in Test case 03 is displayed.
//With success message.

