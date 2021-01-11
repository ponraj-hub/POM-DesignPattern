
package com.qa.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	//page locators declare as private to achieve not access out of the class
	private By emailId=By.id("username");
	private By password=By.id("password");
	private By loginBtn=By.id("loginBtn");
	private By headerTxt=By.xpath("//div[@class='signup-link']/i18n-string");
	private By forgotPasswordLnk=By.xpath("//small[@id='password-description']");
	
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	//getters
	//how to access private variable of class with public variable using encapsulation
		
	
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	
	public WebElement getPassword() {
		return getElement(password);
	}
	
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	
	public WebElement getHeaderTxt() {
		return getElement(headerTxt);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
	  return getPageHeader(headerTxt);
	}
	
	
	public String verifyForgotPasswordLnk() {
		return getLinkTxt(forgotPasswordLnk);
	}

	public String clickForgotPasswordLink() {
		return clickLink(forgotPasswordLnk);
	}


	//method overloading--with same method name and different parameters
	public HomePage doLogin(String username,String pwd) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();	
		return getInstance(HomePage.class);	
	}
	
	public HomePage doLogin() {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();	
		return getInstance(HomePage.class);	
	}
	
	//username: ponraj8785@gmail.com : Naindira@4436562
	
	public void doLogin(String userCred) {
		if(userCred.contains("username")) {
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		}else if(userCred.contains("pwd")) {
			getPassword().sendKeys(userCred.split(":")[2].trim());
		}
	}
}
