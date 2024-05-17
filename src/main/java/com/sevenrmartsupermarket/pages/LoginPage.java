package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(name ="username" )
	private WebElement userNameField;
	@FindBy(name ="password" )
	private WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginButtonField;
	
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
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSigninButton();
	}
	public void login(String userName,String password) {
		
		enterUserName(userName);
		enterPassword(password);
		clickSigninButton();
	}
	public void getErrorMessage()
	{
		
	}
}

	
