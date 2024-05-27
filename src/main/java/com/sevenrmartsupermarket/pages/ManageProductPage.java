package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtility generalUtility = new GeneralUtility();
	PageUtility pageUtility;
	
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
			}
	
	
	@FindBy(xpath = "//tbody//tr//td[1]")
	private List<WebElement> pdtNameElements;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertElement;
	
	public boolean makeItemFeatured(String name) {
		pageUtility = new PageUtility(driver);
		int index = 0;
		
		List<String> pdtNameData = new ArrayList<String>();
		
		pdtNameData = generalUtility.getTextofElements(pdtNameElements);
		System.out.println(pdtNameData);
		for (index = 0; index < pdtNameData.size(); index++) {
			if (pdtNameData.get(index).equals(name)) {
				index++;

				break;
			}
		}
		System.out.println(index);
		WebElement featureElementBtn = driver.findElement(By.xpath("//tbody//tr[" + index + "]//td[8]//a"));
		pageUtility.scrollAndClick(featureElementBtn);
		WebElement featureElementTile = driver.findElement(By.xpath("//tbody//tr[" + index + "]//td[8]"));
		String actualStatus= featureElementTile.getText();
		System.out.println(actualStatus);
		Boolean pdtState=(alertElement.getText()).contains("Status Changed");
		return pdtState;

	}
	
	public void getFeturedButtonColor()
	{Boolean b;
		for(int i=1;i<20;i++)
		{
		WebElement featureElementBtn = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[8]//a//span"));
		System.out.println(featureElementBtn.getText());
		String color =generalUtility.get_CssValue(featureElementBtn,"background-color");
		System.out.println(color);
		
		if((color.equals("(rgba(255, 193, 7, 1))")||(color.equals("(rgba(40, 167, 69, 1))"))))
				{
		b=true;
				}
		else 
			 b=false;
		}
		
		
		
		}
	}
	
	


