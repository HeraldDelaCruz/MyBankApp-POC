package com.browserstack;

import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.utility.Utils;


public class MyBank_03 extends BaseClass {

    @Test
    public void myBank_03() {
    	
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

//MyBank_03
//Step 1: Launch MyBank app using .apk file.
//Step 2: Click on View accounts
//Step 3: Click on any of the one of the user 
//Step 4: Click on Transfer money 
//Step 5: Click on Enter amount 
//Step 6: Enter the amount 
//Step7: Click on Send 
//Step 8: Select one of the user 
//Stpe 9: Validate Transaction successful message is displayed.


