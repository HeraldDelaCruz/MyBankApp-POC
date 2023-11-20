package com.browserstack;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.utility.Utils;


public class MyBank_02 extends BaseClass {

    @Test
    public void myBank_02() {
    	
    	appObjects = new AppObjects(driver);
    	utils = new Utils(driver);
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	utils.waitApptoLoad();
    	
    	//click on View Account
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//click on User: Nikita
    	appObjects.clickOnElement(appObjects.Nikita);
    	
    	//validate fields if displayed
    	utils.assertTextIsDisplayed(appObjects.Nikita_Name);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_Email);
    	utils.assertTextIsDisplayed(appObjects.Nikita_MobileNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_ifsc);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountBalance);
    	
    	System.out.println("Test case 2 : Finished \n");
    
    }
}

//MyBank_02
//Step 1: Launch MyBank app using .apk file.
//Step 2: Click on View accounts
//Step 3: Click on any of the one of the user 
//Step 4: Validate below fields are displayed.
//	Name 
//	Account Number 
//	Email id:
//	Mobile Number 
//	IFSC Code
//	Current Balance 


