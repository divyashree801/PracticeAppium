 package com.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	protected AppiumDriver<MobileElement> driver;
	DesiredCapabilities cap;
	
	public void createDriver()
	{
		cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\src\\test/java/com/Backup/redBus.apk");
		try {
			driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@BeforeTest (alwaysRun = true)
	
	public void init()
	{
		createDriver();
		driver.resetApp();
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() 
	{
		driver.quit();
	}

}
