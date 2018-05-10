package com.fb.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginExplicit {
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
	
	

	@Test
  public void failedLogin() {
		WebDriverWait explicitWait = new WebDriverWait(webDriver,120);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("test@Test.com");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass"))).sendKeys("test123");
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_4"))).click();
		//webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	 	WebElement errorDivElement = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_box")));
		//WebElement errorDivElement = webDriver.findElement(By.id("error_box"));
		System.out.println(errorDivElement.getTagName());
		String exptectedTitle = "Test user login from external network";
		assertTrue(errorDivElement.getText().startsWith(exptectedTitle));
  }
	
	
	
}
