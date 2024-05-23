package com.sevenrmartsupermarket.base;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();
	ScreenshotCapture screenshotcapture=new ScreenshotCapture();	//screenshotcapture.takeScreenshot(driver, "screenshot1");

	/** base class constructor **/
	public Base() {

		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialising browser **/

	public void intialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
@Parameters("browser") // use when running as suite
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) {
	String url = properties.getProperty("url");
	intialize( browser,  url);
}
@BeforeMethod(enabled=true,alwaysRun=true)// use when we run a class
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		intialize( browser,  url);
	}

	@AfterMethod(alwaysRun=true)
	public void terminateBrowser(ITestResult itestresult)
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			screenshotcapture.takeScreenshot(driver, itestresult.getName());
		}
	}

}
