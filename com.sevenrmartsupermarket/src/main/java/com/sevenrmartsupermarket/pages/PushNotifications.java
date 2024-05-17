package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotifications {
	WebDriver driver;
	@FindBy(name = "titlep")
	private WebElement titleElement;
	@FindBy(name = "description")
	private WebElement descriptionElement;
	@FindBy(name = "create")
	private WebElement sendButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertElement;

	public PushNotifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitle(String title)
	{
		titleElement.sendKeys(title);
	}
	public void enterDescription(String description)
	{
		descriptionElement.sendKeys(description);
	}
	public void clickSendButton()
	{
		sendButtonElement.click();
	}
	
	public void sendNotification(String t,String d)
	{
		enterTitle(t);
		enterDescription(d);
		clickSendButton();
	}
	public String getAlertMessage()
	{	System.out.println(alertElement.getText());
		return alertElement.getText();
		
	}

}
