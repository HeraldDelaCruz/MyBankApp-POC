package com.myBank.methods;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;

public class TransferPageMethods extends Utils{
	public AndroidDriver driver;
	
	public TransferPageMethods(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public String getUserBalance() {
		WebElement Elem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/AccBal"));
		try {
			return Elem.getText();	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : "+Elem+"Element not found");
			return null;
		}
		
	}
	
	public String getSender() {
		WebElement Elem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/name1"));
		try {
			return Elem.getText();	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : "+Elem+"Element not found");
			return null;
		}
		
	}
	
	public String getReceiver() {
		WebElement Elem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/name2"));
		try {
			return Elem.getText();	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : "+Elem+"Element not found");
			return null;
		}
	}
	
	public String moneySent() {
		WebElement Elem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/AccBal"));
		try {
			return Elem.getText();	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : "+Elem+"Element not found");
			return null;
		}
	}
	
	public String transferStatus() {
		WebElement Elem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/transaction_status"));
		try {
			return Elem.getText();	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : "+Elem+"Element not found");
			return null;
		}
	}
	
	//TC_04
	public void checkTransactionHistory (float amount,String[] sender,String[] receiver) {
		
		String senderInTransaction = getSender();
    	String receiverInTransaction = getReceiver();
    	String moneySentRaw = moneySent();
    	String transferStatus = transferStatus();
    	
    	String moneySent = moneySentRaw.replaceAll("[^0-9.]", "");
    	
    	DecimalFormat decimalFormat = new DecimalFormat("0.00");
    	String amountStr = decimalFormat.format(amount);	
    	
    	if( senderInTransaction.equalsIgnoreCase(sender[0]) && 
    		receiverInTransaction.equalsIgnoreCase(receiver[0]) &&
    		moneySent.equalsIgnoreCase(amountStr) &&
    	    transferStatus.equalsIgnoreCase("Success")
    			  )
    		
    			 {
    		Reporter.log(" Sender : " + senderInTransaction,true);
    		Reporter.log(" Receiver : " + receiverInTransaction,true);
    		Reporter.log(" Amount : " + moneySent,true);
    		Reporter.log(" Status : " + transferStatus,true);
    		Reporter.log(" - PASSED : Transaction : Money with amount of " +moneySent+ " from " +senderInTransaction+ " that sent to " +receiverInTransaction+
    				 " is Displayed in Transaction History Page.",true);
    			 }
    	
    	else if ( senderInTransaction.equalsIgnoreCase(sender[0]) && 
        		  receiverInTransaction.equalsIgnoreCase("Not selected") &&
        		  moneySent.equalsIgnoreCase("0.00") &&
        	      transferStatus.equalsIgnoreCase("Failed")
        			  )
        		
        			 {
    		Reporter.log(" Sender : " + senderInTransaction,true);
    		Reporter.log(" Receiver : No User is selected",true);
    		Reporter.log(" Amount : " + moneySent,true);
    		Reporter.log(" Status : " + transferStatus,true);
        		Reporter.log(" - FAILED : Transaction has been cancelled by " + senderInTransaction,true);
        		softAssert.fail(" - FAILED : Transaction has been cancelled by " + senderInTransaction);
        			 }
    	
    	else {
    		Reporter.log(" Sender : No User is selected",true);
    		Reporter.log(" Receiver : No User is selected",true);
    		Reporter.log(" Amount : 0.00 " ,true);
    		Reporter.log(" Status : Failed",true);
    		Reporter.log(" - FAILED : Transaction is FAILED to Display in Transaction History Page. ",true);
    		softAssert.fail(" - FAILED : Transaction is FAILED to Display in Transaction History Page. ");
    	}
	}
}
