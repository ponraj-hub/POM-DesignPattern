package com.qa.mypage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {	
	protected WebDriver driver;
	WebDriverWait wait;	
	
	//Using create constructor of abstract class is allowed in java but cant create object in abstact
	@SuppressWarnings("deprecation")
	public Page(WebDriver driver) {
		this.driver=driver;
		//we cant pass this like driver in args bcz webdriver wait we need driver
		this.wait=new WebDriverWait(this.driver,20);
	}
	
	//Using abstract methods
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	public abstract String getLinkTxt(By locator);
	public abstract String clickLink(By locator);
	
	
	//TPage is generic type reference will extends basepage and it will return the same page class instance and the 
	//method name is getinstance();
	//this getinstance is having class attribute with generic and page class reference created
	
	//using generics
	public <TPage extends BasePage> TPage getInstance(Class<TPage>pageclass){
		try {
		    return pageclass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class).newInstance(this.driver,this.wait);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
