package com.first.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FbTitleCheck {

	public static void main(String[] args) {
		String driverPath = "F:\\PreetiTrainingMaterials\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	    WebDriver driver ;
		String baseUrl = "https://www.facebook.com/";
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle =  driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        
        driver.close();
        
        
        
	}
	
	
}
