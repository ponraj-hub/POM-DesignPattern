/**
 * 
 */
package com.qa.mytest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.mypage.BasePage;
import com.qa.mypage.Page;

public class BaseTest {

	static WebDriver driver;//pass this driver at l.no 24 & l.no 27
	public Page page;//create page class variable //abstract class created
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setupTest(String browser) throws InterruptedException {
	 {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.silentOutput","true");
			System.setProperty("webdriver.chrome.driver","E:\\chrome drivers\\chromedriver.exe");
		     driver=new ChromeDriver();  //create a driver instance over here
		}else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.silentOutput","true");
			 System.setProperty("webdriver.gecko.driver","E:\\chrome drivers\\geckodriver.exe");
		     driver=new FirefoxDriver();  //create a driver instance over here
		}else {
			System.out.println("no browser defined in xml file");
		}
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(6000);
		page = new BasePage(driver); //we have to call the constructor of page class & how?
		//call the child class of page class			
	}
	}
	@AfterMethod()
		public void tearDown() {
			driver.quit();
		}
	}

