package com.pages;

import org.openqa.selenium.WebDriver;

import com.Objects.PageObject;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage{

	public HomePage(AppiumDriver<MobileElement> driver) {
	
		super(driver);
		System.out.println("Home Page --constructor");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Select Country and langauage
	 */
	
	
	public void selectCountryLang()
	{
		elementClick(PageObject.homepage_dd_CountrySelection);
		getElementList(PageObject.homepage_cb_CountryName).get(1).click();
		
		// Select the language
		elementClick(PageObject.homepage_cb_LanguageName);
				
				// Click on Continue
		elementClick(PageObject.homepage_btn_Continue);
		
		
	}

}
