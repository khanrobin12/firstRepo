package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";

	
	
	public ContactsPageTest() {
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactLink();
		}
	
	
	@Test(priority=1)
	public void veryfyContactsPageTitleTest() {
		String CTtitle =contactsPage.veryfyContactsPageTitle();
		Assert.assertEquals(CTtitle, "CRMPRO");
		}
	
	@Test(priority=2)
	public void veryfyContactPageLabelTest() {
		boolean CPlabel=contactsPage.veryfyContactPageLabel();
		Assert.assertEquals(CPlabel, true);
		}
	
	@Test(priority=3)
	public void selectContactsByNameTest() {
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui ui");
		}
	
	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
		}
	
	@Test(priority=4, dataProvider ="getTestData")
	public void createNewContactTest(String title, String firstName, String lasName, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Robin", "khan", "Ebay");
		contactsPage.createNewContact(title, firstName, lasName, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}
	

}
