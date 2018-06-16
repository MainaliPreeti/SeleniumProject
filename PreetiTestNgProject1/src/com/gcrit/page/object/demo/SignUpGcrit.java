package com.gcrit.page.object.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpGcrit {
	WebDriver webdriver;
	By firstname = By.name("firstname");
	By lastname= By.name("lastname");
	By dateOfBirth=By.id("dob");
	By emailaddress=By.name("email_address");
	By companyname=By.name("company");
	By streetaddress=By.name("street_address");
	By postcode=By.name("postcode");
	By city1=By.name("city");
	By state_1=By.name("state");
	By country_1=By.name("country");
	By telephone_1=By.name("telephone");
	By newsLetter_1=By.name("newsletter");
	By password_1=By.name("password");
	By passwordConfirmation_1=By.name("confirmation");
	By continuee_1=By.id("tdb4");
	By gender_1 = By.name("gender");

	public SignUpGcrit(WebDriver webdriver){
		this.webdriver=webdriver;
	
	}

	public void setFirstName(String firstName) {
		webdriver.findElement(firstname).sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		webdriver.findElement(lastname).sendKeys(lastName);
	}
	
	public void setDOB(String dob) {
		webdriver.findElement(dateOfBirth).sendKeys(dob);
	}
	
	public void setEmailAddress(String emailAddress) {
		webdriver.findElement(emailaddress).sendKeys(emailAddress);
	}
	public void setCompanyName(String companyName) {
		webdriver.findElement(companyname).sendKeys(companyName);
	}
	public void setStreetAdd(String streetadd) {
		webdriver.findElement(streetaddress).sendKeys(streetadd);
	}
	public void setPostCode(String postCode) {
		webdriver.findElement(postcode).sendKeys(postCode);
	}
	public void setCity(String city) {
		webdriver.findElement(city1).sendKeys(city);
	}
	public void setState(String state1) {
		webdriver.findElement(state_1).sendKeys(state1);
	}
	public void setCountry(String country) {
		webdriver.findElement(country_1).sendKeys(country);
	}
	public void setTelephone(String telephone) {
		webdriver.findElement(telephone_1).sendKeys(telephone);
	}
	
	public void setNewsLetter(String newsLetter) {
		webdriver.findElement(newsLetter_1).sendKeys(newsLetter);
	}
	public void setPassword(String password) {
		webdriver.findElement(password_1).sendKeys(password);
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		webdriver.findElement(passwordConfirmation_1).sendKeys(passwordConfirmation);
	}
	public void setContinuee(String continuee) {
		webdriver.findElement(continuee_1).sendKeys(continuee);
	}
	public void setGender(String gender) {
		webdriver.findElement(gender_1).sendKeys(gender);
	}
	
	public void signUp(String firstName,String lastName,String dob,String emailAddress,String companyName,String streetadd,String postCode,String city,String state1,String country,String telephone,String newsLetter,String password,String passwordConfirmation,String continuee,String gender){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDOB(dob);
		this.setEmailAddress(emailAddress);
		this.setCompanyName(companyName);
		this.setStreetAdd(streetadd);
		this.setPostCode(postCode);
		this.setCity(city);
		this.setState(state1);
		this.setCountry(country);
		this.setTelephone(telephone);
		this.setNewsLetter(newsLetter);
		this.setPassword(password);
		this.setPasswordConfirmation(passwordConfirmation);
		this.setContinuee(continuee);
		this.setGender(gender);
	}
	

	
}
