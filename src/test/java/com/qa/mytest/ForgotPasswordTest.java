package com.qa.mytest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.mypage.ForgotPasswordPage;


import junit.framework.Assert;

public class ForgotPasswordTest extends BaseTest {

	Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 0, enabled = true)
	public void verifyForgotTitleTest() {
		WebElement ForgotPasswordHeader = page.getInstance(ForgotPasswordPage.class).getForgotPasswordTxt();
		System.out.println(ForgotPasswordHeader);
		Assert.assertEquals(ForgotPasswordHeader, "Reset your password");
	}

	@Test(priority = 1, enabled = true)
	public void clickForgotlinkTest() {
		page.getInstance(ForgotPasswordPage.class).getClickgobackLoginLnk();
	}
}
