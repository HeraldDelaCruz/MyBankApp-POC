package com.myBank.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public void BankingSystemTextIsDisplayed () {
	String actualText = BankingSystemtxt.getText();
		if (BankingSystemtxt.isDisplayed()) {
			System.out.println("Text validation passed. Expected: " + verifyBankSystemtxt + ", Actual: " + actualText);
		}
		else {
			System.out.println("Text validation failed. Expected: " + verifyBankSystemtxt + ", Actual: " + actualText);
       }
	}
}
