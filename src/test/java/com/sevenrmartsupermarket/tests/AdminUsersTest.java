package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotifications;

public class AdminUsersTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
  @Test(groups="smoke")
  public void navigateToAdminUseraTab() {
	  loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.openAdminUsersTab();
		adminUsersPage.inputNewAdminUserDetails("jisha", "pass", "Admin");
		
		
  }
  @Test(groups={"smoke","sanity"})
  public void verifyDeactivatedUser() {
	  loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.openAdminUsersTab();
		adminUsersPage.listNameOfUsers();
		String actualStatus= adminUsersPage.deactivateUser("Venice Hammes");
		String expectedStatus= "Inactive";
		Assert.assertEquals(actualStatus, expectedStatus);
		
		
  }
}
