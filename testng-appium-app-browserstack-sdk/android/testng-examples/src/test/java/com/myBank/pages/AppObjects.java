package com.myBank.pages;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.myBank.utility.BaseClass;
import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppObjects extends Utils{
	public static AndroidDriver driver;
	
	public AppObjects(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/btnViewUsers")
	public String[] ViewAccountsBtn = {"id","com.sleepingpandaaa.bankingsystem:id/btnViewUsers","View Account"};
	
	@AndroidFindBy(xpath=".//*[contains(@text, 'Banking System')]")
	public String[] BankingSystem = {"xpath",".//*[contains(@text, 'Banking System')]","Banking System"};
	
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/transfer_button")
	public String[] TransferMoneyBtn = {"id","com.sleepingpandaaa.bankingsystem:id/transfer_button","Transfer Money"};
	
	@AndroidFindBy(id="com.sleepingpandaaa.bankingsystem:id/enter_money")
	public String[] AmountField = {"id","com.sleepingpandaaa.bankingsystem:id/enter_money","Amount"};
	
	@AndroidFindBy(id="android:id/button1")
	public String[] SendMoneyBtn = {"id","android:id/button1","Send Money"};
	
	@AndroidFindBy(id="android:id/button2")
	public String[] CancelBtn = {"id","android:id/button2","Cancel"};
	
	@AndroidFindBy(id= "com.sleepingpandaaa.bankingsystem:id/action_history")
	public String[] History = {"id","com.sleepingpandaaa.bankingsystem:id/action_history","History"};
	
	@AndroidFindBy(xpath=".//*[contains(@text, 'NO')]")
	public String[] ModalNoBtn = {"xpath",".//*[contains(@text, 'NO')]","No"};
	
	@AndroidFindBy(xpath=".//*[contains(@text, 'YES')]")
	public String[] ModalYesBtn = {"xpath",".//*[contains(@text, 'YES')]","Yes"};
	
	
	public String getUserBalance() {
		WebElement balElem = driver.findElement(By.id("com.sleepingpandaaa.bankingsystem:id/AccBal"));
		return balElem.getText();
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
}

