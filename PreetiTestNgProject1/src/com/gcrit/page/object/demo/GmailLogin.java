package com.gcrit.page.object.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLogin {
 WebDriver webdriver;
 By email= By.name("identifier");
 By next=By.className("RveJvd snByac");
 By password=By.name("password");
 By next1=By.className("CwaK9");
 
 public GmailLogin(WebDriver webdriver){
	 this.webdriver=webdriver;
 }
 public void SetEmailAddress(String emailText){
	 webdriver.findElement(email).sendKeys(emailText);
 }
 public void clickNext(){
	 webdriver.findElement(next).click();
 }
 public void SetPassowrd(String passwordText){
	 webdriver.findElement(password).sendKeys(passwordText);
 }
 public void clickNext1(){
	 webdriver.findElement(next1).click();
 }
 public void loginToGamail(String strEmailAddress,String click,String strPassword,String click1){
	 this.SetEmailAddress(strEmailAddress);
	 this.clickNext();
	 this.SetPassowrd(strPassword);
	 this.clickNext1();
 }
}

