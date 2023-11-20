package com.myBank.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppObjects extends Utils{
	public AndroidDriver driver;
	
	public AppObjects(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	//page objects
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/btnViewUsers")
	public WebElement ViewAccountsBtn;
	
	String verifyBankSystemtxt = "Banking Systemz";
	@AndroidFindBy(xpath=".//*[contains(@text, 'Banking System')]")
	public WebElement BankingSystemtxt;

	
	
	//methods
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	//get banking system text and check if displayed
	public void bankingSystemTextIsDisplayed () {
	String actualText = BankingSystemtxt.getText();
		if (BankingSystemtxt.isDisplayed()) {
			System.out.println("Text validation passed. Expected: " + verifyBankSystemtxt + ", Actual: " + actualText);	 
		}
		else {
			System.out.println("Text validation failed. Expected: " + verifyBankSystemtxt + ", Actual: " + actualText);
       }
	}
	
	//get account number listed and log
	public void getAccountNum()  {
		List<WebElement> accountNum = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/CustName"));
		List<WebElement> accountName = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/AccNum"));
		
	 for (int i = 0; i < accountNum.size()-1 ; i++) {
		 WebElement accountNumbers = accountNum.get(i);
         String accountDetails = accountNumbers.getText();
         
         WebElement accountNames = accountName.get(i);
		 String accountNamess = accountNames.getText();
         
         
    	//System.out.println("Account number details : " + (i + 1) + " details: " + accountDetails);
    	Reporter.log("Account " + (i + 1) + " details : " + accountNamess + " " +accountDetails, true);
       
	 	}

	 }


}

