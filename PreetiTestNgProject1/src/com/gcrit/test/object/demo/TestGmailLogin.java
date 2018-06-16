package com.gcrit.test.object.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gcrit.page.object.demo.GmailHomePage;
import com.gcrit.page.object.demo.GmailLogin;



public class TestGmailLogin {

	private WebDriver webdriver;
	private GmailLogin gmailLogin;
	private GmailHomePage gmailHomeLogin;
	private String driverPath = "C:\\ExternalJars\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	
	@BeforeTest
 public void setUp(){
     System.setProperty("webdriver.gecko.driver", driverPath);
	 webdriver = new FirefoxDriver();
	 webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// webdriver.get("https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    webdriver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
 } 
 @Test
 public void testGamilLogin(){
  gmailLogin =new GmailLogin(webdriver);
  gmailLogin.loginToGamail("123mainalip@gmail.com","click","Shankhamool10","click");
  gmailHomeLogin=new GmailHomePage(webdriver);
  String googleAccount=gmailHomeLogin.getGoogleAccount();
  Assert.assertEquals(googleAccount, "preeti mainali");
  
 }
}
