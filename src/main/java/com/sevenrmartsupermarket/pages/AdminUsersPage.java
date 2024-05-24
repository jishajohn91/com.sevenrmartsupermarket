package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalUtility = new GeneralUtility();
	PageUtility pageUtility;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(name = "username")
	private WebElement userNameElement;
	@FindBy(name = "password")
	private WebElement passwordElement;
	@FindBy(id = "user_type")
	private WebElement userTypeElement;
	@FindBy(name = "create")
	private WebElement saveButtonElement;

	@FindBy(xpath = "//tbody//tr//td[1]")
	private List<WebElement> nameElements;

	public void inputNewAdminUserDetails(String name, String password, String typeValue) {
		newButtonElement.click();
		userNameElement.sendKeys(name);
		passwordElement.sendKeys(password);

		Select obj = new Select(userTypeElement);
		obj.selectByValue(typeValue);
		saveButtonElement.click();

	}

	public void listNameOfUsers() {
		for (WebElement e : nameElements) {
			System.out.println(e.getText());
		}
	}

	public String deactivateUser(String name) {
		pageUtility = new PageUtility(driver);
		int index = 0;
		List<String> namesData = new ArrayList<String>();
		namesData = generalUtility.getTextofElements(nameElements);
		System.out.println(namesData);
		for (index = 0; index < namesData.size(); index++) {
			if (namesData.get(index).equals(name)) {
				index++;

				break;
			}
		}
		System.out.println(index);
		WebElement deactivateElement = driver.findElement(By.xpath("//tbody//tr[" + index + "]//td[5]//a[1]"));
		pageUtility.scrollAndClick(deactivateElement);
		WebElement statusElement = driver.findElement(By.xpath("//tbody//tr[" + index + "]//td[3]"));
		String actualStatus= statusElement.getText();
		return actualStatus;
	}

	
}