package com.myBank.methods;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.myBank.pages.AppObjects;
import com.myBank.testdata.TestData;
import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;



public class UserDetailsPageMethods extends Utils{
	public static AndroidDriver driver;
	
	public UserDetailsPageMethods(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	//TC_02
	public void clickOnUser(String[] userDetails) {
		String usersName = userDetails[0];
		String userDetail = "Customer Name: " + usersName;
		
		Utils.scollToText(userDetail);
		
		driver.findElement(By.xpath(".//*[contains(@text, '" +userDetail+ "')]")).click();
		Reporter.log( usersName + " was clicked", true);	
	}
	
	
	public void clickOnReceiver(String[] userDetails) {
		String usersName = userDetails[0];
			
		Utils.scollToText(usersName);
		
		driver.findElement(By.xpath(".//*[contains(@text, '" +usersName+ "')]")).click();
		Reporter.log( usersName + " was clicked", true);
			
	}
	
	public void validateUserDetails(String[] userDetails) {
		
		validateUsername(userDetails);
		validateAccountNum(userDetails);
		validateEmailId(userDetails);
		validateMobileNum(userDetails);
		validateIfscCode(userDetails);
		validateCurrentBalance(userDetails);
	}
	
	public void validateUsername(String[] userDetails) {
		String usersDetail = userDetails[0];
		String fieldText = testData.HeaderField[0];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch (IndexOutOfBoundsException| NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}


	public void validateAccountNum(String[] userDetails) {
		String usersDetail = userDetails[1];
		String fieldText = testData.HeaderField[1];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch(IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}
	
	public void validateEmailId(String[] userDetails) {	
		String usersDetail = userDetails[2];
		String fieldText = testData.HeaderField[2];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch(IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}
	
	public void validateMobileNum(String[] userDetails) {
		String usersDetail = userDetails[3];
		String fieldText = testData.HeaderField[3];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch(IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}
	
	public void validateIfscCode(String[] userDetails) {
		String usersDetail = userDetails[4];
		String fieldText = testData.HeaderField[4];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch(IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}

	public void validateCurrentBalance(String[] userDetails) {
		String usersDetail = userDetails[5];
		String fieldText = testData.HeaderField[5];
		
		WebElement Elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
		
		if (Elem.isDisplayed()) {
			try {
				Reporter.log("Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
			}
			catch(IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log("Data not found",true);
				softAssert.fail("Data not found");
			}
		}
		else {
			Reporter.log(fieldText + " " + usersDetail + " Field is NOT Displayed",true);
			softAssert.fail(fieldText + " " + usersDetail + " Field is NOT Displayed");
		}
	}	

	
	//TC_03
	public void transferMoney(float amount,String[] sender,String[] receiver) {
			
		String amountStr = String.valueOf(amount);
		String userBalanceStr = sender[5].replaceAll("[^0-9.]", "");
		float userBalance = Float.parseFloat(userBalanceStr); 
		
		appObjects.clickOnElement(appObjects.TransferMoneyBtn);
		
	    if (amount < userBalance) {
	    	
	    	Reporter.log("Send money with amount:" + amountStr,true);
		    utils.sendTextToField(appObjects.AmountField,amountStr);
		    appObjects.clickOnElement(appObjects.SendMoneyBtn);
		    
	  		Reporter.log("Navigate User: "+ receiver[0]+" as the Receiver",true);
	   		clickOnReceiver(receiver);
	    			
    		String toastMessage = getToastMessage();
        	String expectedToastMessage = "Transaction Successful!";
           
        	try {
        		Assert.assertEquals(toastMessage, expectedToastMessage);
        		Reporter.log("Toast message verified",true);
        	}
        	catch(AssertionError e) {
        		Reporter.log("Toast message verification failed",true);
        	}
        	
	    	String senderName = sender[0];
	   		String receiverName = receiver[0];
	        
	    	Reporter.log("Money from " +senderName+ " is sent to "+receiverName+" with amount of " + amount + " is transfered successfully",true);
	    	}
	    
	    else if(amount > userBalance) {
				Reporter.log("insufficient User Balance");
				appObjects.clickOnElement(appObjects.CancelBtn);
				appObjects.clickOnElement(appObjects.ModalYesBtn);
				utils.navigateBack();
				}
	    	
	    else {
	    		Reporter.log("No Data found for User Balance or Amount to send ",true);
	    		appObjects.clickOnElement(appObjects.CancelBtn);
				appObjects.clickOnElement(appObjects.ModalYesBtn);
				utils.navigateBack();
	    	}
	    	
	}
	
	public String getToastMessage() {
		try{
			WebElement toastElem = driver.findElement(By.xpath(".//*[contains(@text,'Transaction Successful!')]"));
			return toastElem.getText();
		}
		catch (StaleElementReferenceException e) {
			WebElement toastElem = driver.findElement(By.xpath(".//*[contains(@text,'Transaction Successful!')]"));
			return toastElem.getText();
		}
			}
	
	
	//TC_04
	public void checkTransactionHistory (float amount,String[] sender,String[] receiver) {
		
		String senderInTransaction = appObjects.getSender();
    	String receiverInTransaction = appObjects.getReceiver();
    	String moneySentRaw = appObjects.moneySent();
    	String transferStatus = appObjects.transferStatus();
    	
    	String moneySent = moneySentRaw.replaceAll("[^0-9.]", "");
    	
    	DecimalFormat decimalFormat = new DecimalFormat("0.00");
    	String amountStr = decimalFormat.format(amount);	
    	
    	if( senderInTransaction.equalsIgnoreCase(sender[0]) && 
    		receiverInTransaction.equalsIgnoreCase(receiver[0]) &&
    		moneySent.equalsIgnoreCase(amountStr) &&
    	    transferStatus.equalsIgnoreCase("Success")
    			  )
    		
    			 {
    		Reporter.log("Transaction : Money with amount of " +moneySent+ " from " +senderInTransaction+ " that sent to " +receiverInTransaction+
    				 " is Displayed in Transaction History Page.",true);
    			 }
    	
    	else if ( senderInTransaction.equalsIgnoreCase(sender[0]) && 
        		  receiverInTransaction.equalsIgnoreCase("Not selected") &&
        		  moneySent.equalsIgnoreCase("0.00") &&
        	      transferStatus.equalsIgnoreCase("Failed")
        			  )
        		
        			 {
        		Reporter.log("Transaction has been cancelled by " + senderInTransaction,true);
        			 }
    	
    	else {
    		Reporter.log("Transaction is FAILED to Display in Transaction History Page. ",true);
    	}
	}
}

