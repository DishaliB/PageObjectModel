package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;

	public LoginPageTest() throws IOException {
		super();
		}
	
	@BeforeMethod 
	public void setUp() throws IOException, InterruptedException {
		initialization();
		lp= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = lp.validateTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void logo() {
		boolean logo = lp.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void login() throws InterruptedException, IOException {
		hp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
