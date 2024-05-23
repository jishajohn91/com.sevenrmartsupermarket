package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.DataProviderClass;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	
	 ExcelReader excelReader= new ExcelReader();

	@Test(groups="smoke",retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}
	@Test(groups="sanity")
	public void verifyInvalidLoginErrorMessage() {
		loginPage = new LoginPage(driver);
		loginPage.login("jisha1","admin");
		System.out.println(GeneralUtility.getRandomFullName());
		
			}
	@Test(dataProvider = "loginCredentials",dataProviderClass = DataProviderClass.class)
	public void verifyLoginWithDataProviderExcel(String user,String password)
	{
		loginPage = new LoginPage(driver);
	homePage = new HomePage(driver);
	loginPage.login(user, password);
	String actualProfileName= homePage.getProfileName();
	System.out.println(actualProfileName);
	excelReader.setExcelFile("LoginData", "DPdata");
	String expName= excelReader.getCellData(0, 2);
	System.out.println(expName);
	
	
		
	}
	
}
