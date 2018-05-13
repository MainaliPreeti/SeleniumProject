package com.w3schools.tests;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Table1 {
	
	private static final String  testUrl = "https://www.w3schools.com/html/html_tables.asp";
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
  public void browseTables() {
	  //get title of the table
	  WebElement tableTitle = webDriver.findElement(By.xpath("//*[contains(text(),'HTML Table Example')]"));
	  assertTrue(tableTitle.getText().equals("HTML Table Example"));
	  //get contact header of the table using absolute path
	  WebElement contactAbsPath = webDriver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/th[2]"));
	  assertTrue(contactAbsPath.getText().equals("Contact"));
	  
	  //get header of the table using rel path
	  WebElement contactRelPath = webDriver.findElement(By.xpath("//th[contains(text(),'Contact')]"));
	  assertTrue(contactRelPath.getText().equals("Contact"));
	  
	  //select td elements - mexico and germany
	  
	  List<WebElement> twoCountries = webDriver.findElements(By.xpath("//td[contains(text(),'Austria') or contains(text(),'Mexico')]"));
	  //get each element
	  //use of enhanced for loop pleae note it 
	  System.out.println("***********Use of enhanced for loop ****************");
	  for(WebElement country: twoCountries) {
		  System.out.println("The country name is " + country.getText());
	  }
	  
	  System.out.println("****Use of iteration*******");
	  Iterator<WebElement> webElementIterator = twoCountries.iterator();
	  while(webElementIterator.hasNext()){
		  WebElement currentWebElement = webElementIterator.next();
		  System.out.println("The country name is " + currentWebElement.getText());
	  }
	  
	  System.out.println("********Use of classical for loop **************");
	  for(int i=0; i<twoCountries.size();i++) {
		  System.out.println("The country name is " + twoCountries.get(0).getText());
	  }

	  
	  
	  
	  
  }
}
