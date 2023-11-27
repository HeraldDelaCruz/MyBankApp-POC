package com.browserstack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
import com.myBank.testdata.TestData;
import com.myBank.utility.BaseClass;
import com.myBank.utility.Utils;


public class FinalExamPOC extends BaseClass {
	
	@Test
    public void myBank_01() throws Exception {
    	//MyBank_01
    	//Step 1: Launch MyBank app using .apk file.
    	//Step 2: Click on View accounts
    	//Step 3: Validate Banking System is displayed on Top
    	//Step 4: Log the number of account displayed in TestNg report.
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 1 Start",true);
    	
    	utils.waitApptoLoad();
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	Reporter.log("Verify 'Banking System' text from header if Displayed:",true);
    	utils.assertTextIsDisplayed(appObjects.BankingSystemtxt);
    	Reporter.log("Get and log the accounts listed in the page:",true);
    	appObjects.getAccountNum();    	
    	
    	Reporter.log("Test case 1 : Finished",true);
    	Reporter.log("    ",true);
    }
    
    @Test
    public void myBank_02() {
    	//MyBank_02
    	//Step 1: Launch MyBank app using .apk file.
    	//Step 2: Click on View accounts
    	//Step 3: Click on any of the one of the user 
    	//Step 4: Validate below fields are displayed. (enhancement add assert equals)
    	//    		Name 
    	//    		Account Number 
    	//    		Email id:
    	//    		Mobile Number 
    	//    		IFSC Code
    	//    		Current Balance 
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 2 Start",true);
    	
    	utils.waitApptoLoad();
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	Reporter.log("Navigate User: Nikita",true);
    	appObjects.clickOnElement(appObjects.NikitaAccountNum);
    	
    	Reporter.log("Validate Data if displayed:",true);
    	utils.assertTextIsDisplayed(appObjects.Nikita_Name);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_Email);
    	utils.assertTextIsDisplayed(appObjects.Nikita_MobileNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_IFSC);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountBalance);
    	
    	Reporter.log("Test case 2 : Finished",true);
    	Reporter.log("    ",true);
    
    }
    
    @Test
    public void myBank_03() throws Exception {
    	//MyBank_03
    	//Step 1: Launch MyBank app using .apk file.
    	//Step 2: Click on View accounts
    	//Step 3: Click on any of the one of the user 
    	//Step 4: Click on Transfer money 
    	//Step 5: Click on Enter amount 
    	//Step 6: Enter the amount 
    	//Step7: Click on Send 
    	//Step 8: Select one of the user 
    	//Step 9: Validate Transaction successful message is displayed.
    	
    	Reporter.log("    ",true);
    	Reporter.log("Test case 3 Start",true);
    	
    	utils.waitApptoLoad();
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	Reporter.log("Navigate User: Nikita as the Sender",true);
    	appObjects.clickOnElement(appObjects.NikitaAccountNum);
    	appObjects.clickOnElement(appObjects.TransferMoneyBtn);

    	//String amount = "500";
    	String amount = testData.excelTestData(1, 5, 0);
    	Reporter.log("Send money with amount:" + amount,true);
    	appObjects.sendkeys(amount);
    	appObjects.clickOnElement(appObjects.SendMoneyBtn);
    	Reporter.log("Navigate User: Shebon as the Receiver",true);
    	appObjects.clickOnElement(appObjects.ShebonAccountNum);
    	
    	String toastMessage = appObjects.getToastMessage();
    	String expectedToastMessage = "Transaction Successful!";
        assert toastMessage.equals(expectedToastMessage) : "Toast message verification failed";
    	
        String senderName = appObjects.getSenderName().substring(15);
        String receiverName = appObjects.getReceiverName().substring(15);
        
        Reporter.log("Money from " +senderName+ " is sent to "+receiverName+" with amount of " + amount + " is transfered successfully",true);
        
        Reporter.log("Test case 3 : Finished",true);
        Reporter.log("    ",true);
    	
        Reporter.log("    ",true);
        Reporter.log("Test case 4 Start",true);

        Reporter.log("Navigate Transaction History Page",true);
    	appObjects.clickOnElement(appObjects.History);
    	
        String sender = appObjects.getSender();
    	String receiver = appObjects.getReceiver();
    	String moneySent = appObjects.moneySent();
    	String transferStatus = appObjects.transferStatus();
    	
    	String Nikita = testData.excelTestData(0, 5, 0);
    	String Shebon = testData.excelTestData(0, 3, 0);
    	if(sender.equalsIgnoreCase(Nikita) && 
    	   receiver.equalsIgnoreCase(Shebon) &&
    	   moneySent.equalsIgnoreCase(amount) &&
    	   transferStatus.equalsIgnoreCase("Success")
    			  )
    			 {
    		Reporter.log("Transaction : Money with amount of " +moneySent+ " from " +sender+ " that sent to " +receiver+
    				 " is Displayed in Transaction History Page.",true);
    			 }
    	else {
    		Reporter.log("Transaction is FAILED to Display in Transaction History Page. ",true);
    	}
    	    	    	
    	Reporter.log("Test case 4 : Finished",true);
    	Reporter.log("    ",true);

    }	
     
    
    
}
    
    
    
    
 
    
    
    
    
    
    




