package com.myBank.methods;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.myBank.utility.Utils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class HomePageMethods extends Utils{
	public AndroidDriver driver;
	
	public HomePageMethods(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public void validateBankText() throws IOException {
		utils.assertTextIsDisplayed(appObjects.BankingSystem);
		isElementPresent(appObjects.BankingSystem);
	}
	
	public void getAccountNum()  {
		List<WebElement> accountNum = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/CustName"));
		List<WebElement> accountName = driver.findElements(By.id("com.sleepingpandaaa.bankingsystem:id/AccNum"));
		
		int accountCount = accountNum.size()-1;
		String accountCountstr = Integer.toString(accountCount);
		
		for (int i = 0; i < accountNum.size()-1 ; i++) {
			WebElement accountNumbers = accountNum.get(i);
			String accountDetails = accountNumbers.getText();
         
			WebElement accountNames = accountName.get(i);
			String accountNamess = accountNames.getText();
         	
			Reporter.log(" - PASSED : Account " + (i + 1) + " details : " + accountNamess + " " +accountDetails, true);
	 	}
		
		Reporter.log(" - PASSED : number of accounts listed: " + accountCountstr, true);
	 }

	
	public void isElementPresent(String[] element) throws IOException {
		Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();
       
        WebElement elem = driver.findElement(AppiumBy.xpath(element[1])); // (pixel 6 pro : 56, 196)

        Point elementLocation = elem.getLocation();
        
        float elementX = (float) elementLocation.getX() ;
        float elementY = (float) elementLocation.getY();
        
        float locXpercent = ((float) (elementX / screenWidth) * 100);
        float locYpercent = ((float) (elementY / screenHeight)* 100);
        
        float ExpectedXLoc = ((float) locXpercent /100 * screenWidth);
        float ExpectedYLoc = ((float) locYpercent /100 * screenHeight);
        
        if (Math.abs(elementX - ExpectedXLoc) <= 5 && Math.abs(elementY - ExpectedYLoc) <= 5) {
        	Reporter.log(" - PASSED : Text is at the correct position",true);
        }
        else {
        	Reporter.log(" - FAILED : Text is not present in the position",true);
        	softAssert.fail(" - FAILED : Text is not present in the position");
        	utils.getScreenShot();
        }
		
    	}
	}
        