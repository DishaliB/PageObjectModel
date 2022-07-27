package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: Dishali Balar')]")
	WebElement headerText;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath = "//a[text()= 'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[text()='New Deal']")
	WebElement newDealsLink;
	
	@FindBy(xpath = "//a[text()= 'Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[text()='New Task']")
	WebElement newTasksLink;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean headerText() {
		return headerText.isDisplayed();
	}
	
	public ContactsPage clickOncontactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOndealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOntasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	public void clickOnNewDelasLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
	}
	
	public void clickOnNewTasksLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(tasksLink).build().perform();
		newTasksLink.click();
	}

}
