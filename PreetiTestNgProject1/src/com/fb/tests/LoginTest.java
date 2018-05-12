package com.fb.tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
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
	}
	
	

	@Test(groups = { "group2" })
  public void failedLogin() {
		webDriver.findElement(By.id("email")).sendKeys("test@Test.com");
		webDriver.findElement(By.name("pass")).sendKeys("test123");
		webDriver.findElement(By.id("u_0_4")).click();
		webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		WebElement errorDivElement = webDriver.findElement(By.id("error_box"));
		System.out.println(errorDivElement.getTagName());
		String exptectedTitle = "Test user login from external network";
		assertTrue(errorDivElement.getText().startsWith(exptectedTitle));
  }
	
	
	
	@Test(groups = { "group1","group2" })
	public void failedRandomUserId(){
		webDriver.findElement(By.name("email")).sendKeys("erereeere@drere.dfd");
		webDriver.findElement(By.id("pass")).sendKeys("pass223232");
		webDriver.findElement(By.id("u_0_4")).click();
		webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebElement errorMessageDiv = webDriver.findElement(By.linkText("Sign up for an account."));
		assertEquals(errorMessageDiv.getText(), "Sign up for an account.");
		
	}
	
	
}
