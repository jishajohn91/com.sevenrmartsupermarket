package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotifications;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationsTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	PushNotifications pushNotifications;
	GeneralUtility generalUtility = new GeneralUtility();
	 ExcelReader excelReader= new ExcelReader();

	@Test
	public void verifyThePushNotificationIsSent() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		pushNotifications = new PushNotifications(driver);
		loginPage.login();
		homePage.openPushNotificationTab();
		//pushNotifications.sendNotification("world", "helooooii");
		excelReader.setExcelFile("PushNotificationData", "Data1");
		String title= excelReader.getCellData(1, 0);
		String description= excelReader.getCellData(1, 1);
		pushNotifications.sendNotification(title,description);
		String actualAlertMsg= pushNotifications.getAlertMessage();
		String expectedAlertMsg ="Message send successfully";
		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMsg));


	}
	@Test
	public void checkExcel() {
		excelReader.setExcelFile("PushNotificationData", "Data1");
		String title= excelReader.getCellData(0, 0);
	}
	
}
