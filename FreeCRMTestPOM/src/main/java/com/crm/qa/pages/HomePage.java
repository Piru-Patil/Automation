package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'piru p')]")
	WebElement UserNameLable;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	//Initializing page objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return UserNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}
		
}
