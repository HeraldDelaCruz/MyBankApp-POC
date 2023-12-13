package com.myBank.pages;

import org.openqa.selenium.support.PageFactory;
import com.myBank.utility.Utils;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppObjects extends Utils{
	public AndroidDriver driver;
	
	public AppObjects(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String[] ViewAccountsBtn = {"id","com.sleepingpandaaa.bankingsystem:id/btnViewUsers","View Account"};
	
	public String[] BankingSystem = {"xpath",".//*[contains(@text, 'Banking System')]","Banking System"};
	
	public String[] TransferMoneyBtn = {"id","com.sleepingpandaaa.bankingsystem:id/transfer_button","Transfer Money"};
	public String[] AmountField = {"id","com.sleepingpandaaa.bankingsystem:id/enter_money","Amount"};
	public String[] SendMoneyBtn = {"id","android:id/button1","Send Money"};
	public String[] CancelBtn = {"id","android:id/button2","Cancel"};
	
	public String[] History = {"id","com.sleepingpandaaa.bankingsystem:id/action_history","History"};
	public String[] ModalNoBtn = {"xpath",".//*[contains(@text, 'NO')]","No"};
	public String[] ModalYesBtn = {"xpath",".//*[contains(@text, 'YES')]","Yes"};
	
	
}

