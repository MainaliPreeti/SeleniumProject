package com.gcrit.page.object.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GmailHomePage {
 WebDriver webdriver;
 By googleAccount=By.className("gb_db gbii");
 
public  GmailHomePage(WebDriver webdriver){
	 this.webdriver=webdriver;
 }
 public String getGoogleAccount(){
	 return webdriver.findElement(googleAccount).getText();
	 
 }
}
