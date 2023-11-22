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
	public WebElement NikitaAccountNum;
	
	//Nikita details
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/CustName")
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
	
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement SendMoneyBtn;
	
	@AndroidFindBy(id="android:id/button2")
	public WebElement CancelBtn;
	
	//@AndroidFindBy(className ="android.widget.Toast")
	//public WebElement ToastMessage;
	
	@AndroidFindBy(xpath=".//*[contains(@text, '9111234562567')]")
	public WebElement ShebonAccountNum;
	
	
	@AndroidFindBy(accessibility= "Search")
	public WebElement History;
	
	@AndroidFindBy(id= "com.sleepingpandaaa.bankingsystem:id/name1")
	public WebElement Sender;
	
	@AndroidFindBy(id= "com.sleepingpandaaa.bankingsystem:id/name2")
	public WebElement Receiver;
	
	@AndroidFindBy(id= "com.sleepingpandaaa.bankingsystem:id/AccBal")
	public WebElement MoneySent;
	
	@AndroidFindBy(id= "com.sleepingpandaaa.bankingsystem:id/transaction_status")
	public WebElement TransferStatus;
	
	
	
	
	
	//methods
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public String getToastMessage() {
		WebElement toastElem = driver.findElement(By.xpath(".//*[contains(@text, 'Transaction Successful!')]"));
		return toastElem.getText();
	}
	
	public String getSender() {
		WebElement senderElem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/name1"));
		return senderElem.getText();
	}
	
	public String getReceiver() {
		WebElement receiverElem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/name2"));
		return receiverElem.getText();
	}
	
	public String moneySent() {
		WebElement moneySentElem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/AccBal"));
		return moneySentElem.getText();
	}
	
	public String transferStatus() {
		WebElement transferStatusElem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/transaction_status"));
		return transferStatusElem.getText();
	}
	
	public String getSenderName() {
		WebElement senderNameElem = driver.findElement(By.xpath(".//*[contains(@text, 'Customer Name: Nikita')]"));
		return senderNameElem.getText();
	}
	
	public String getReceiverName() {
		WebElement receiverNameElem = driver.findElement(By.xpath(".//*[contains(@text, 'Customer Name: Shebon')]"));
		return receiverNameElem.getText();
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
		
		
	//get account number listed and log
	public void getAccountNum()  {
		List<WebElement> accountNum = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/CustName"));
		List<WebElement> accountName = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/AccNum"));
		
		int accountCount = accountNum.size();
		String accountCountstr = Integer.toString(accountCount);
		
		Reporter.log("number of accounts listed: " + accountCountstr);
		
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

