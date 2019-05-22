package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public  HomePage login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(5000);
		loginbtn.click();
		return new HomePage();
		}
	

}
