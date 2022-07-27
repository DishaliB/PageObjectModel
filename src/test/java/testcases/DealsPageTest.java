package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	DealsPage dp;
	TestUtil tu;
	String sheetName = "Deals";

	public DealsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtil();
		lp = new LoginPage();
		dp = new DealsPage();
		
		hp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
		dp = hp.clickOndealsLink();
	}
	
	@Test (priority=1)
	public void dealsLabelTest() {
		boolean lable = dp.dealsLabel();
		Assert.assertTrue(lable, "Deals Label is not Available");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException {
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority=2, dataProvider = "getCRMTestData")
	public void validateNewDealsTest(String title, String company, String primaryContact, String type, String source) {
	hp.clickOnNewDelasLink();
	dp.createNewDeal(title, company, primaryContact, type, source);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
