package com.browserstack;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import com.myBank.pages.AppObjects;


public class BaseClass {
	protected AndroidDriver driver;
	protected AppObjects appObjects;
	
	
	//local
	//public String userName = "heralddelacruz_DjwAuz"; // heralddelacruz_DjwAuz
	//public String accessKey = "GprQ3CPzVt9qb8F6pxpx";  // GprQ3CPzVt9qb8F6pxpx
	//public String buildName_myBank = "H local run";
	//public String app_myBank = "bs://dfc767e8d4ff36dd63883d8439be773df5c5937d";
	
	//jenkins config
	public String userName = System.getenv("BROWSERSTACK_USERNAME"); // heralddelacruz_DjwAuz
	public String accessKey = System.getenv("BROWSERSTACK_ACCESSKEY");  // GprQ3CPzVt9qb8F6pxpx
	public String buildName_myBank = System.getenv("BROWSERSTACK_BUILD_NAME"); 
	public String app_myBank = System.getenv("BROWSERSTACK_APP_ID_myBank"); 
	//mybank : bs://dfc767e8d4ff36dd63883d8439be773df5c5937d
	
	//static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL"); 
	//static String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
    
	
	
	
    public String URL = "http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
		
    @BeforeTest(alwaysRun = true)
    public void setUp() throws IOException {
    	 
    	
    	MutableCapabilities capabilities = new UiAutomator2Options();
    	
    	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    	browserstackOptions.put("appiumVersion", "2.0.1");
    	capabilities.setCapability("bstack:options", browserstackOptions);
    	
		//jenkins 
		capabilities.setCapability("deviceName", "Samsung Galaxy S21");
		capabilities.setCapability("os_Version", "12.0");
		capabilities.setCapability("Project","MyBank App:(POC) - Android"); 
		capabilities.setCapability("build", buildName_myBank); 
		capabilities.setCapability("name", buildName_myBank);
		capabilities.setCapability("app", app_myBank); 

        driver = new AndroidDriver(new URL(URL), capabilities);
      	
    }
    
	/*
	 * @Test public void testPassed () { System.out.print("test integration pass");
	 * 
	 * }
	 */
    
	 
   
   
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    	System.out.print("test done");
    }
}