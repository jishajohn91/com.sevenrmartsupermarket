package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(name ="username" )
	private WebElement userNameField;
	@FindBy(name ="password" )
	private WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginButtonField;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginAlertElement;
	
	By homePageWaitElement=By.xpath("//a[@class='d-block']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	try {
		FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
		properties.load(fs);

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickSigninButton()
	{
		loginButtonField.click();
	}
	public void login() {
		WaitUtility waitutility=new WaitUtility(driver);
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSigninButton();
		//waitutility.waitForElementToBeVisible(homePageWaitElement, 10);
	}
	public void login(String userName,String password) {
		
		
		enterUserName(userName);
		enterPassword(password);
		clickSigninButton();
	}
	public boolean getErrorMessage()
	{
		String alertText= loginAlertElement.getText();
		System.out.println(loginAlertElement.getText());
		boolean status;
		if(alertText.contains("Invalid Username/Password"))
		{
			status= true;
		}
		else {
			status=false;
	}
		return status;
	
	}
	
}

	
