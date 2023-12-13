package com.myBank.methods;

import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;

public class UserDetailsPageMethods extends Utils{
	public AndroidDriver driver;
	
	public UserDetailsPageMethods(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void clickOnUser(String[] userDetails) throws IOException {
		String usersName = userDetails[0];
		String userDetail = "Customer Name: " + usersName;

		try {
			Utils.scollToText(userDetail);
			
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '" +userDetail+ "')]"));
			if (elem.isDisplayed()) 
				elem.click();
				Reporter.log(" - PASSED : " +usersName + " was clicked", true);	
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : User not found",true);
			softAssert.fail(" - FAILED : User not found");
			utils.getScreenShot();
		}
	}
	
	
	public void clickOnReceiver(String[] userDetails) throws IOException {
		String usersName = userDetails[0];
			
		try {
			Utils.scollToText(usersName);
		
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '" +usersName+ "')]"));	
			if(elem.isDisplayed()) 
				
				elem.click();
				Reporter.log(" - PASSED : " + usersName + " was clicked", true);
			}
		catch(NoSuchElementException e) {
			Reporter.log(" - FAILED : User not found",true);
			softAssert.fail(" - FAILED : User not found");
			utils.getScreenShot();
		}
	}
	
	public void validateUserDetails(String[] userDetails) throws IOException {
		validateUsername(userDetails);
		validateAccountNum(userDetails);
		validateEmailId(userDetails);
		validateMobileNum(userDetails);
		validateIfscCode(userDetails);
		validateCurrentBalance(userDetails);
	}
	
	public void validateUsername(String[] userDetails) throws IOException {
		String usersDetail = userDetails[0];
		String fieldText = testData.HeaderField[0];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed())  {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}
		
	public void validateAccountNum(String[] userDetails) throws IOException {
		String usersDetail = userDetails[1];
		String fieldText = testData.HeaderField[1];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed()) {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}
		
	
	public void validateEmailId(String[] userDetails) throws IOException {	
		String usersDetail = userDetails[2];
		String fieldText = testData.HeaderField[2];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed())  {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}

	
	public void validateMobileNum(String[] userDetails) throws IOException {
		String usersDetail = userDetails[3];
		String fieldText = testData.HeaderField[3];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed())  {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}
	
	public void validateIfscCode(String[] userDetails) throws IOException {
		String usersDetail = userDetails[4];
		String fieldText = testData.HeaderField[4];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed())  {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}

	public void validateCurrentBalance(String[] userDetails) throws IOException {
		String usersDetail = userDetails[5];
		String fieldText =  testData.HeaderField[5];
		
		try {
			WebElement elem = driver.findElement(By.xpath(".//*[contains(@text, '"+ usersDetail +"')]"));
			
			if (elem.isDisplayed())  {
				Reporter.log(" - PASSED : Field " + fieldText + " with data " + usersDetail + " is Displayed",true);
				}
			}
			catch (IndexOutOfBoundsException | NoSuchElementException e) {
				Reporter.log(" - FAILED : "+usersDetail+" data is not present on the page ",true);
				softAssert.fail(" - FAILED : "+usersDetail+" data is not present on the page ");
				utils.getScreenShot();
				}
		}
	
	public void transferMoney(float amount,String[] sender,String[] receiver) throws IOException {
			
		String amountStr = String.valueOf(amount);
		String userBalanceStr = sender[5].replaceAll("[^0-9.]", "");
		float userBalance = Float.parseFloat(userBalanceStr); 
		
		appObjects.clickOnElement(appObjects.TransferMoneyBtn);
		
	    if (amount < userBalance) {
	    	
	    	Reporter.log(" - PASSED : Send money with amount: " + amountStr,true);
		    utils.sendTextToField(appObjects.AmountField,amountStr);
		    appObjects.clickOnElement(appObjects.SendMoneyBtn);
		    
	  		Reporter.log(" - PASSED : Navigate User: "+ receiver[0]+" as the Receiver",true);
	   		clickOnReceiver(receiver);
	    	
	   		String toastMessage = getToastMessage();
	   		String expectedToastMessage = "Transaction Successful!";
	   		
	    	try {
	    		Assert.assertEquals(toastMessage, expectedToastMessage);
	    		Reporter.log(" - PASSED : Toast message verified",true);
	    	}
	    	catch(AssertionError e) {
	    		Reporter.log(" - FAILED : Toast message verification failed",true);
	    		softAssert.fail(" - FAILED : Toast message verification failed");
	    		utils.getScreenShot();
	    	}
        	
	    	String senderName = sender[0];
	   		String receiverName = receiver[0];
	        
	    	Reporter.log(" - PASSED : Money from " +senderName+ " is sent to "+receiverName+" with amount of " + amount + " is transfered successfully",true);
	    	}
	    
	    else if(amount > userBalance) {
				Reporter.log(" - FAILED : Insufficient User Balance",true);
				appObjects.clickOnElement(appObjects.CancelBtn);
				appObjects.clickOnElement(appObjects.ModalYesBtn);
				utils.navigateBack();
				
				softAssert.fail(" - FAILED : Insufficient User Balance");
				utils.getScreenShot();
				}
	    	
	    else {
	    		Reporter.log(" - FAILED : No Data found for User Balance or Amount to send ",true);
	    		appObjects.clickOnElement(appObjects.CancelBtn);
				appObjects.clickOnElement(appObjects.ModalYesBtn);
				utils.navigateBack();
				
				softAssert.fail(" - FAILED : No Data found for User Balance or Amount to send ");
				utils.getScreenShot();
	    	}
	    	
	}
	
	public String getToastMessage() {
		WebElement toastElem;
		
		try{
			toastElem = driver.findElement(By.xpath(".//*[contains(@text,'Transaction Successful!')]"));
			return toastElem.getText();
		}
		catch (StaleElementReferenceException e) {
			toastElem = driver.findElement(By.xpath(".//*[contains(@text,'Transaction Successful!')]"));
			return toastElem.getText();
		}
	
 	    
	}
    	
}		


	
		


