package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;

	@Test
	public void verifyUserLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}
	@Test
	public void verifyInvalidLoginErrorMessage() {
		loginPage = new LoginPage(driver);
		loginPage.login("jisha","admin");
		System.out.println(GeneralUtility.getRandomFullName());
			

	}
}
