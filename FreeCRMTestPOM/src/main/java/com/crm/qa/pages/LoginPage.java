package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR (Object repo)
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement LoginB;
	
	@FindBy(xpath = "//a[@title='free crm home']")
	WebElement crmLogo;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button' and contains(text(),'Login')]")
	WebElement LoginBtn;
	
	//Initilizating the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLogingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		
		LoginB.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	
	}	

}
