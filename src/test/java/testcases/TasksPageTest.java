package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;
import utilities.TestUtil;

public class TasksPageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	TasksPage tp;
	TestUtil tu;
	String sheetName = "Tasks";

	public TasksPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtil();
		lp = new LoginPage();
		tp = new TasksPage();
		
		hp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
		tp = hp.clickOntasksLink();
	}
	
	@Test (priority=1)
	public void tasksLabelTest() {
		boolean lable = tp.tasksLable();
		Assert.assertTrue(lable, "Deals Label is not Available");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException {
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority=2, dataProvider="getCRMTestData")
	public void validatenewTasksTest(String title, String priority) {
		hp.clickOnNewTasksLink();
		tp.createNewTask(title, priority);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
