package com.browserstack;

import org.testng.annotations.Test;

import com.myBank.pages.AppObjects;
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
    	
    	System.out.println("    ");
    	System.out.println("Test case 1 Start");
    	
    	//Step 1: Launch MyBank app using .apk file.
    	utils.waitApptoLoad();
    	
    	//Step 2: Click on View accounts
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//Step 3: Validate Banking System is displayed on Top
    	//appObjects.bankingSystemTextIsDisplayed();
    	System.out.println("Verify Banking System text from top if Displayed:");
    	utils.assertTextIsDisplayed(appObjects.BankingSystemtxt);
    	
    	//Step 4: Log the number of account displayed in TestNg report.
    	System.out.println("Get and log the accounts listed in the page:");
    	appObjects.getAccountNum();
    	
    	System.out.println("Test case 1 : Finished");
    	System.out.println("    ");
    }
    
    @Test
    public void myBank_02() {
    	//MyBank_02
    	//Step 1: Launch MyBank app using .apk file.
    	//Step 2: Click on View accounts
    	//Step 3: Click on any of the one of the user 
    	//Step 4: Validate below fields are displayed.
    	//    		Name 
    	//    		Account Number 
    	//    		Email id:
    	//    		Mobile Number 
    	//    		IFSC Code
    	//    		Current Balance 
    	
    	System.out.println("    ");
    	System.out.println("Test case 2 Start");
    	
    	//Step 1: Launch MyBank app using .apk file.
    	utils.waitApptoLoad();
    	
    	//Step 2: Click on View accounts
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//Step 3: Click on any of the one of the user : Nikita
    	System.out.println("Navigate User: Nikita");
    	appObjects.clickOnElement(appObjects.NikitaAccountNum);
    	
    	//Step 4: Validate below fields are displayed.
    	System.out.println("Validate Data if displayed:");
    	utils.assertTextIsDisplayed(appObjects.Nikita_Name);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_Email);
    	utils.assertTextIsDisplayed(appObjects.Nikita_MobileNum);
    	utils.assertTextIsDisplayed(appObjects.Nikita_ifsc);
    	utils.assertTextIsDisplayed(appObjects.Nikita_AccountBalance);
    	
    	System.out.println("Test case 2 : Finished");
    	System.out.println("    ");
    
    }
    
    @Test
    public void myBank_03() {
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
    	
    	System.out.println("    ");
    	System.out.println("Test case 3 Start");
    	
    	//Step 1: Launch MyBank app using .apk file.
    	utils.waitApptoLoad();
    	
    	//Step 2: Click on View accounts
    	appObjects.clickOnElement(appObjects.ViewAccountsBtn);
    	
    	//Step 3: Click on any of the one of the user , User: Nikita
    	System.out.println("Navigate User: Nikita as the Sender");
    	appObjects.clickOnElement(appObjects.NikitaAccountNum);
    	
    	//Step 4: Click on Transfer money 
    	appObjects.clickOnElement(appObjects.TransferMoneyBtn);
    	
    	//Click on Enter amount 
    	String amount = "500";
    	System.out.println("Send money with amount:" +amount);
    	appObjects.sendkeys(amount);
    	
    	//Step7: Click on Send
    	appObjects.clickOnElement(appObjects.SendMoneyBtn);
    	
    	//Step 8: Select one of the user  , User: Shebon
    	System.out.println("Navigate User: Shebon as the Receiver");
    	appObjects.clickOnElement(appObjects.ShebonAccountNum);
    	
    	
    	//Step 9: Validate Transaction successful message is displayed.
    	String toastMessage = appObjects.getToastMessage();
    	
    	//check toast message if correct
    	String expectedToastMessage = "Transaction Successful!";
        assert toastMessage.equals(expectedToastMessage) : "Toast message verification failed";
    	
        String senderName = appObjects.getSenderName().substring(15);
        String receiverName = appObjects.getReceiverName().substring(15);
        
        System.out.println("Money from " +senderName+ " is sent to "+receiverName+" with amount of " + amount + " is transfered successfully");
        
    	System.out.println("Test case 3 : Finished");
    	System.out.println("    ");
    	
    	
    	
    	System.out.println("    ");
    	System.out.println("Test case 4 Start");

    	//Step 3: Click on arrows on right side 
    	appObjects.clickOnElement(appObjects.History);
    	
    	//Step 4: Validate the transaction you did in Test case 03 is displayed. With success message
    	String sender = appObjects.getSender();
    	String receiver = appObjects.getReceiver();
    	String moneySent = appObjects.moneySent();
    	String transferStatus = appObjects.transferStatus();
    
    	
    	if(sender.equalsIgnoreCase("Nikita") && 
    	   receiver.equalsIgnoreCase("Shebon") &&
    	   moneySent.equalsIgnoreCase("500.00") &&
    	   transferStatus.equalsIgnoreCase("Success")
    			  )
    			 {
    		System.out.println("Transaction : Money with amount of " +moneySent+ " from " +sender+ " that sent to " +receiver+
    				 " is Displayed in Transaction History Page.");
    			 }
    	else {
    		System.out.println("Transaction is NOT Displayed in Transaction History Page. ");
    	}
    	    	
    	
    	System.out.println("Test case 4 : Finished");
    	System.out.println("    ");
    	
    }	
     
    
    
}
    
    
    
    
 
    
    
    
    
    
    




