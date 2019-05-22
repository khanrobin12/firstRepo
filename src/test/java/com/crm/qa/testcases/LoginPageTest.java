package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String titletxt=loginPage.validateLoginPageTitle();
		Assert.assertEquals(titletxt, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean falg=loginPage.validateCRMImage();
		Assert.assertTrue(falg);
		}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
