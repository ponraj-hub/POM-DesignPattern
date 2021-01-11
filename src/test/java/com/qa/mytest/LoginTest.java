package com.qa.mytest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.mypage.HomePage;
import com.qa.mypage.LoginPage;

public class LoginTest extends BaseTest {
	Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 0, enabled = true)
	public void verifyLoginPageTitleTest() {
		// inherit page class reference in login Test
		log.info("Verify both actaul and expected title of login page");
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageHeaderTest() {
		// inherit page class reference in login Test
		log.info("verify actual and expected page header text");
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
	}

	@Test(priority = 3, enabled = true)
	public void verifyForgotPasswordLinkTest() {
		log.info("verify forgot password link displayed");
		String forgotPasswordTxt = page.getInstance(LoginPage.class).verifyForgotPasswordLnk();
		System.out.println(forgotPasswordTxt);
		Assert.assertEquals(forgotPasswordTxt, "Forgot my password");
		page.getInstance(LoginPage.class).clickForgotPasswordLink();

	}

	@Test(priority = 4, enabled = true)
	@Parameters(value = { "userName", "passWord" })
	public void doLoginTest(String username, String pwd) throws InterruptedException {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, pwd);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("verify both actaul and expected home page header");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "Sales Dashboard");
	}
}
