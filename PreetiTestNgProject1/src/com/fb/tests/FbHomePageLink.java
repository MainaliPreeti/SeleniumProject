package com.fb.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FbHomePageLink {
  
	private static final String  testUrl = "https://www.facebook.com/";
	private WebDriver webDriver;
	private String driverPath = "F:\\PreetiTrainingMaterials\\geckodriver-v0.20.1-win64\\geckodriver.exe";
  
	@BeforeMethod
	public void setTestEnvVariables() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    webDriver.get(testUrl);
	}
	
	
	@AfterMethod
	public void clearTestEnvVariables(){
		webDriver.close();
		//webDriver.quit();
	}
	
	
	@Test
  public void instragramLink() {
		webDriver.findElement(By.linkText("Instagram")).click();
		webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		List<String> browserTabs = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(browserTabs.get(1));
		assertEquals(webDriver.getCurrentUrl(), "https://www.instagram.com/");
  }
}
