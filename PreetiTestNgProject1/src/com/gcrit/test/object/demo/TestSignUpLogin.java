package com.gcrit.test.object.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gcrit.page.object.demo.GcritHomePage;
import com.gcrit.page.object.demo.GcritLogin;
import com.gcrit.page.object.demo.SignUpGcrit;

public class TestSignUpLogin {
	private WebDriver webdriver;
	private SignUpGcrit signUpGcrit;
	
	private String driverPath = "C:\\ExternalJars\\geckodriver-v0.20.1-win64\\geckodriver.exe";

	@BeforeTest

	public void setup() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		webdriver = new FirefoxDriver();
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webdriver.get("http://www.gcrit.com/build3/create_account.php?osCsid=up5f889r2ja9dbfu23qqjut9j6");

	}
	@Test
	public void testGcritSignUp(){
	signUpGcrit=new SignUpGcrit(webdriver);
	signUpGcrit.signUp("Bibha", "Dhungel","01/01/2000","bibhadhungel@yahoo.com", "xyx","Westknoll cove","63017","Chesterfield","Missouri","UnitedStates","3145413331","click","Gcrit123", "Gcrit123","click", "female");
	
	

	}
	}
