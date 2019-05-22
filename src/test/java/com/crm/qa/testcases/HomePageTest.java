package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("userName"),  prop.getProperty("passWord"));
		}
	
	@Test(priority=1)
	public void veryfyHomePageTitleTest() {
		String homePageTitle=homePage.homePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
		}
	
	@Test(priority=2)
	public void veryfyUserNameTest() {
		testUtil.switchToFrame();
		boolean displayUN=homePage.userNameDisplay();
		Assert.assertEquals(displayUN, true);
		}
	
	@Test(priority=3)
	public void veryfyContactLinkTesta() {
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactLink();
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
