package com.testscripts;

import org.testng.annotations.Test;

import com.pages.HomePage;

public class TestSuit extends BaseTest {
	

	@Test
	public void testScript1() {
		// Open App
		HomePage homePage = new HomePage(driver);
		// Select country and language
		homePage.selectCountryLang();

}
}
