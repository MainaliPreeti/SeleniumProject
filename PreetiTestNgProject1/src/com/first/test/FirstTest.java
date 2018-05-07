package com.first.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTest {
	 public String baseUrl = "http://demo.guru99.com/test/newtours/";
	    String driverPath = "F:\\PreetiTrainingMaterials\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	    public WebDriver driver ; 
	
	    @Test
	    public void verifyHomepageTitle() {
	        String expectedTitle = "Welcome: Mercury Tours";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle);
	        driver.close();
	    }
	    
	    @BeforeTest
	    public void makeParameterReadyForTest(){
	    	 System.out.println("launching firefox browser"); 
	          System.setProperty("webdriver.gecko.driver", driverPath);
	          driver = new FirefoxDriver();
	          driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	          driver.get(baseUrl);
	    }
	    
	    @AfterTest
	    public void closeConnections(){
	    	driver.close();
	    }
	    
	    @Test(priority = 3)
	    public void failTest() {
	    	Assert.fail();
	    }
	    
	    @Test(priority = 1)
	    public void trueTest(){
	    	Assert.assertTrue(Boolean.TRUE);
	    }
	    
	    @Test(priority = 7)
	    public void skipTest() {
	    	throw new SkipException("Skipping test case ");
	    }
	    
	    @Test
	    public void verifySum() {
	    	int a = 3; 
	    	int b = 5;
	    	Assert.assertEquals(a+b, 8);
	    }
}
