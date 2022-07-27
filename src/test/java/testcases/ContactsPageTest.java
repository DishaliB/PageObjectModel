package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	String sheetName = "Contacts";


	public ContactsPageTest() throws IOException {
		super();
		}
	
	@BeforeMethod 
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtil();
		lp = new LoginPage();
		cp = new ContactsPage();
		
		hp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
		cp = hp.clickOncontactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		boolean label = cp.contactsLabel();
		Assert.assertTrue(label);
	}
	
	@Test(priority=2)
	public void selectSingleContactTest() {
		cp.selectContactsByName("Dhruv Jivani");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		cp.selectContactsByName("Dhruv Jivani");
		cp.selectContactsByName("xyz abc");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException {
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider = "getCRMTestData")
	public void validateCreatNewContactTest(String title, String firstName, String lastName, String company) {
		hp.clickOnNewContactLink();
		cp.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
