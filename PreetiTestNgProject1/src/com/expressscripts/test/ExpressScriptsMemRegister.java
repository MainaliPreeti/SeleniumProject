package com.expressscripts.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpressScriptsMemRegister {
	private static final String  testUrl = "https://www.express-scripts.com/frontend/registration-ui/#/lookup/";
	private WebDriver webDriver;
	private String driverPath = "C:\\ExternalJars\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	
	@BeforeMethod
	public void setTestEnvVariables() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    webDriver.get(testUrl);
	}
	@AfterMethod
	public void clearTestEnvVariables(){
		webDriver.quit();
		
	}
	@Test
	public void register(){
	webDriver.findElement(By.name("firstName")).sendKeys("nkjgkjgkjkg");
	webDriver.findElement(By.name("lastName")).sendKeys("kkkkkkkk");
    webDriver.findElement(By.id("dateOfBirth")).sendKeys("01/02/1990");
	webDriver.findElement(By.name("emailAddress")).sendKeys("ghjhghjgjh@gmail.com");
	WebDriverWait explicitWait = new WebDriverWait(webDriver,30);
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-lookup-ssn-rdo"))).click();
	//webDriver.findElement(By.id("user-lookup-ssn-rdo"));
	webDriver.findElement(By.name("ssn")).sendKeys("709232312");
	webDriver.findElement(By.id("touAccepted")).click();
	webDriver.findElement(By.className("Reg-registration-lookup-btn-AA btn btn-primary btn-block")).click();
	webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	
	
	}
}
