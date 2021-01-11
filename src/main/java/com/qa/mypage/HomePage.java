/**
 * 
 */
package com.qa.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	//page locators
	private By headerTxt= By.xpath("//h1[contains(.,'Sales Dashboard')]/parent::span");
	
	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	public WebElement getHeaderTxt() {
		return getElement(headerTxt);
	}
	
	public String getHomeTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() throws InterruptedException {
		Thread.sleep(5000);
	  return getPageHeader(headerTxt);
	}
}
