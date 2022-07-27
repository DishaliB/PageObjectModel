package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;
import utilities.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	DealsPage dp;
	TasksPage tp;
	TestUtil tu;

	public HomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtil();
		lp = new LoginPage();
		cp = new ContactsPage();
		dp = new DealsPage();
		tp = new TasksPage();
		
		hp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = hp.validateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void headerTextTest() {
		tu.switchToFrame();
		boolean header = hp.headerText();
		Assert.assertTrue(header);
	}
	
	@Test(priority=3)
	public void contactsTest() throws IOException {
		tu.switchToFrame();
		cp = hp.clickOncontactsLink();
	}
	
	@Test(priority=4)
	public void dealsTest() throws IOException {
		tu.switchToFrame();
		dp = hp.clickOndealsLink();;
	}
	
	@Test(priority=5)
	public void tasksTest() throws IOException {
		tu.switchToFrame();
		tp = hp.clickOntasksLink();;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
