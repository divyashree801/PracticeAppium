package com.pages;

import java.awt.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	
	protected AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
	}

	/*
	 * For Clicking webElement
	 */
	
	public MobileElement getElement(By by)
	{
		MobileElement element=null;
		try {
			element=driver.findElement(by);
			

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}


	/** Element send text
	 * 
	 * @param by
	 * Return null
	 */
	 public void sendText(By by, String text) 
	 {
		 MobileElement el=getElement(by);
		 el.clear();
				 el.sendKeys(text);
		 
	 }
	 
	 /** Element click
		 * 
		 * @param by
		 * Return null
		 */
		 public void elementClick(By by) 
		 {
			 MobileElement el=getElement(by);
			el.click();
			 
		 }
	 
/** Waiting for the element to load
 * 	 
 * @param by
 * 
 */
	 public void waitTillLoad(By by) {
		 
		 
		 WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		
	}
	 
	 /** Get the visible element list
	  * 
	  * @param by
	  *@return - ListElements
	  */
	 public java.util.List<MobileElement>getElementList(By by) 
	 {
		java.util.List<MobileElement> dropdownVales=driver.findElements(by);
		java.util.List<MobileElement> visibleValues=new ArrayList<MobileElement>();
		for(int i=0; i< dropdownVales.size(); i++)
		{
			if(dropdownVales.get(i).isDisplayed())
				visibleValues.add(dropdownVales.get(i));
		}
		return visibleValues;
		
	}
	 
	 
	 
}
