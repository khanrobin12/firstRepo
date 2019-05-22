package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="title")
	WebElement titleName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	//@FindBy(xpath="//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	//WebElement contactsLabel;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String veryfyContactsPageTitle() {
		return driver.getTitle();
		}
	
	public boolean veryfyContactPageLabel() {
		return contactsLable.isDisplayed();
		}
	
	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}
	
	public void createNewContact(String title,String fName, String lName, String comp) {
		Select select = new Select(titleName);
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
		
		}
	
	
	
}
