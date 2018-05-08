package com.fb.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
  
	
	private static final String  testUrl = "https://www.facebook.com/";
	private WebDriver webDriver;
	private String driverPath = "F:\\PreetiTrainingMaterials\\geckodriver-v0.20.1-win64\\geckodriver.exe";
  
	@BeforeMethod
	public void setTestEnvVariables() {
		ProfilesIni profileObj = new ProfilesIni();
		FirefoxProfile yourFFProfile = profileObj.getProfile("SeleniumProfile");
		FirefoxOptions fireFoxOptions = new FirefoxOptions();
		fireFoxOptions.setProfile(yourFFProfile);
		//driver = new FirefoxDriver(yourFFProfile);
		System.setProperty("webdriver.gecko.driver", driverPath);
		webDriver = new FirefoxDriver(fireFoxOptions);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    webDriver.get(testUrl);
	}
	
	
	@AfterMethod
	public void clearTestEnvVariables(){
		webDriver.close();
		//webDriver.quit();
	}
	@Test
    public void signUp() {
		webDriver.findElement(By.name("firstname")).sendKeys("dfdd");
		webDriver.findElement(By.name("lastname")).sendKeys("dfddlast");
		webDriver.findElement(By.name("reg_email__")).sendKeys("dfdd@dfd.com");
		webDriver.findElement(By.name("reg_email_confirmation__")).sendKeys("dfdd@dfd.com");
		webDriver.findElement(By.xpath("//*[@id=\"u_0_p\"]")).sendKeys("test1234!");
		WebElement birthMonthSelect = webDriver.findElement(By.name("birthday_month"));
		//passing select webelement in the constructor
		Select birthMonth = new Select(birthMonthSelect);
		birthMonth.selectByIndex(1);
		
		//passing webelement directly into the constructor
		Select birthDay = new Select(webDriver.findElement(By.name("birthday_day")));
		birthDay.selectByIndex(1);
		
		Select birthYear = new Select(webDriver.findElement(By.name("birthday_year")));
		birthYear.selectByValue("1990");
		
		WebElement genderRadio = webDriver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
		genderRadio.click();
		
		//above same steps can be written as 
		// webDriver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
		
		webDriver.findElement(By.name("websubmit")).click();
		
		webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		WebElement headerElement = webDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div[1]/div[1]/div/div[2]/h2"));
		System.out.println(headerElement.getText());
		
		
    }
}
