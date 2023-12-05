package com.myBank.utility;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.myBank.methods.HomePageMethods;
import com.myBank.methods.TransferPageMethods;
import com.myBank.methods.UserDetailsPageMethods;
import com.myBank.pages.AppObjects;
import com.myBank.testdata.TestData;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BaseClass {
	protected static AndroidDriver driver;
	protected static AppObjects appObjects;
	protected static HomePageMethods homePageMethods;
	protected static Utils utils;
	protected static TestData testData;
	protected static UserDetailsPageMethods userDetailsPageMethods;
	protected static TransferPageMethods transferPageMethods;
	protected static SoftAssert softAssert;
	
	//jenkins config
	public static String userName = "heralddelacruz_DjwAuz"; //System.getenv("BROWSERSTACK_USERNAME");   //"heralddelacruz_DjwAuz"; 
	public static String accessKey = "GprQ3CPzVt9qb8F6pxpx"; //System.getenv("BROWSERSTACK_ACCESSKEY"); //"GprQ3CPzVt9qb8F6pxpx";  
	public static String buildName_myBank = System.getenv("BROWSERSTACK_BUILD_NAME"); 
	public static String app_myBank = "bs://dfc767e8d4ff36dd63883d8439be773df5c5937d"; //System.getenv("BROWSERSTACK_APP_ID"); //"bs://dfc767e8d4ff36dd63883d8439be773df5c5937d";
	
    public static String URL = "http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
	
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
    	 
    	MutableCapabilities capabilities = new UiAutomator2Options();
    	
    	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    	browserstackOptions.put("appiumVersion", "2.0.1");
    	capabilities.setCapability("bstack:options", browserstackOptions);
    	
		//jenkins config
		capabilities.setCapability("deviceName", "Google Pixel 6 Pro");
		capabilities.setCapability("os_Version", "14.0");
		capabilities.setCapability("Project","MyBank App:(POC) - Android"); 
		capabilities.setCapability("build", buildName_myBank); 
		capabilities.setCapability("name", buildName_myBank);
		capabilities.setCapability("app", app_myBank); 

        driver = new AndroidDriver(new URL(URL), capabilities);
      	
        appObjects = new AppObjects(driver);
        
        homePageMethods = new HomePageMethods(driver);
        userDetailsPageMethods = new UserDetailsPageMethods(driver);
        transferPageMethods = new TransferPageMethods(driver);
        
        utils = new Utils(driver);

        testData = new TestData();
        softAssert = new SoftAssert();
        
    }
    
    
	/*
	 * @Test public void testPassed () { System.out.print("test integration pass");
	 * 
	 * }
	 */
    
	
	@AfterMethod(alwaysRun = true)
    public void tearDown() {
		softAssert.assertAll();

    	Reporter.log(" ",true);
    	driver.quit();
    	
    }
}