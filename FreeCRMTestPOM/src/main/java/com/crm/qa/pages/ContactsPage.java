package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement contactsLable;
	
	@FindBy(xpath = "//button[contains(text(),'Show Filters')]")
	WebElement showFilterbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createbtn;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastNameField;
	
	@FindBy(xpath = "//div[@name='company']//input[@type='text']")
	WebElement companyField;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement savebtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}
	
	public void clickOnShowFilter() {
		showFilterbtn.click();
	}
	
	public void clickOnCreate(String fName, String lName, String Company) {
		createbtn.click();
		firstNameField.sendKeys(fName);
		lastNameField.sendKeys(lName);
		companyField.sendKeys(Company);
		savebtn.click();
		
		
	}
	

}
