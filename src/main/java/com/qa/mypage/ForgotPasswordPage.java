package com.qa.mypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	private By forgotPasswordLnk=By.xpath("//a[contains(.,'Forgot my password')]");
	private By forgotPasswordTxt=By.xpath("//i18n-string[contains(.,'Reset your password')]/parent::h1");
	private By clickgobackLoginLnk=By.xpath("//a[contains(.,'hubspot.com/login')]");
	
	public String clickLink() {
		return clickLink(forgotPasswordLnk);
	}
	
	public WebElement getForgotPasswordTxt() {
		return getElement(forgotPasswordTxt);
	}

	public String getClickgobackLoginLnk() {
		return clickLink(clickgobackLoginLnk);
	}
}
