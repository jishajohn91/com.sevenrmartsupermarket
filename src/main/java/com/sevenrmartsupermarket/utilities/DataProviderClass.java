package com.sevenrmartsupermarket.utilities;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	ExcelReader excelReader = new ExcelReader();
	
	@DataProvider(name="loginCredentials")
	
	public Object[][] LoginData()
	{
		excelReader.setExcelFile("LoginData", "DPdata");
		return excelReader.getMultidimentionalData(3, 2);
		
	}
	
	

}
