package com.myBank.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;

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
	
	String expectedText = "Banking System";
	@AndroidFindBy(xpath=".//*[contains(@text, 'Banking System')]")
	public WebElement BankingSystemtxt;
	
	//User:Nikita
	@AndroidFindBy(xpath=".//*[contains(@text, 'Account Number: 9111234563473')]")
	public WebElement Nikita;
	

	//Nikita details
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/user_name")
	public WebElement Nikita_Name;
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/AccNum")
	public WebElement Nikita_AccountNum;
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/email")
	public WebElement Nikita_Email;
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/account_no")
	public WebElement Nikita_MobileNum;
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/ifsc_code")
	public WebElement Nikita_ifsc;
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/AccBal")
	public WebElement Nikita_AccountBalance;
	
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/transfer_button")
	public WebElement TransferMoneyBtn;
	
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/enter_money")
	public WebElement AmountField;
	
	
	//methods
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public void sendkeys(String str) {
		AmountField.sendKeys(str);
	}
	
	//get banking system text and check if displayed
	public void bankingSystemTextIsDisplayed () {
		String actualText = BankingSystemtxt.getText();
        if (actualText.equals(expectedText)) {
        	System.out.println("Text validation passed. Expected: " + expectedText + ", Actual: " + actualText);
        	//Reporter.log("Text validation passed. Expected: " + expectedText + ", Actual: " + actualText);
        	System.out.println("- - - - - - - - - - - - - - -");
        	} 
        else {
        	System.out.println("Text validation failed. Expected: " + expectedText + ", Actual: " + actualText);
        	//Reporter.log("Text validation failed. Expected: " + expectedText + ", Actual: " + actualText);
        	System.out.println("- - - - - - - - - - - - - - -");
        	}
		}	
	
	 
		
		//get banking system text and check if displayed using assert 
		//public static void assertTextIsDisplayed() { 
		//	  { 
		//	  String actualText = BankingSystemtxt.getText(); 
		//	  assert BankingSystemtxt.isDisplayed() : BankingSystemtxt +" is not displayed on the page /r /n - - - - - - - - - - - - - - -";
		  
		//System.out.println( actualText + "Text is displayed on the on the page");
		//System.out.println("- - - - - - - - - - - - - - -"); }
		//	}
		 	

		
		
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

