package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {
	

	LoginPage loginPage;
	HomePage homePage;
	ManageProductPage manageProductPage;
  @Test
  public void verifyChangeOfItemsFeturedState() {
	  loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			manageProductPage = new ManageProductPage(driver);
			loginPage.login();
			homePage.openManageProductsTab();
			Boolean pdtState= manageProductPage.makeItemFeatured("Pomogranate");
			Assert.assertTrue(pdtState);			
  }
  @Test
  public void verifyColourofFeaturedItem() {
	  loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageProductPage = new ManageProductPage(driver);
		loginPage.login();
		homePage.openManageProductsTab();
		manageProductPage.getFeturedButtonColor();
  }
}
