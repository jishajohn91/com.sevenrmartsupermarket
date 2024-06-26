package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement userProfileElement;
	@FindBy(xpath = "//p[text()='Push Notifications']")
	private WebElement pushNotificationTabElement;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {

		return userProfileElement.getText();

	}
	public void openPushNotificationTab() {

		pushNotificationTabElement.click();
	}
}
