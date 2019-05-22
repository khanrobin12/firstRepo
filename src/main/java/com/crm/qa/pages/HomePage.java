package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//td[contains(text(),'naveen k')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacstLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean userNameDisplay() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() {
		contacstLink.click();
		return new ContactsPage();
		}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		}
	
	public TasksPage clickOnTesksLink() {
		tasksLink.click();
		return new TasksPage();
		}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contacstLink).build().perform();
		newContactLink.click();
		
		
	}

}
