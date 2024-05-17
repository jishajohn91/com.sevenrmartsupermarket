package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void scrollIntoElement() {

	}

	public void doubleClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}
	}

	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
