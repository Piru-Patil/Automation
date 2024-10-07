package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsLableTest() {
		Assert.assertTrue(contactsPage.verifyContactsLable(), "Contacts missing on the page");
	}
	
	@Test(priority = 2)
	public void clickOnShowFilterTest() {
		contactsPage.clickOnShowFilter();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void clickOnCreateTest(String fName, String lName, String Company) {
		contactsPage.clickOnCreate(fName,lName,Company);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
