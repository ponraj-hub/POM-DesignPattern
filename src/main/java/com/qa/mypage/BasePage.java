package com.qa.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);	
	}

	@Override//method over ridding (same method name with zero no of paraeter)
	public String getPageTitle(){
	     return driver.getTitle();	
	}
	
	@Override
	public String getLinkTxt(By locator) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      return getElement(locator).getText();	
	}

	@Override
	public String clickLink(By locator) {
	driver.findElement(locator).click();
		return null;
	}
	
	
	@Override
	public String getPageHeader(By locator) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      return getElement(locator).getText();	
	}

	@Override//this wrapper 
	public WebElement getElement(By locator) {
	WebElement element=null;
	try {
		element=driver.findElement(locator);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return element;
	}

	@Override
	public void waitForElementPresent(By locator) {	
    try {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     }catch(Exception e) {
	e.printStackTrace();
     }
	}

	
	@Override
	public void waitForPageTitle(String title) {
	try {
		wait.until(ExpectedConditions.titleContains(title));
	}catch(Exception e) {
		e.printStackTrace();
	}	
	}


}