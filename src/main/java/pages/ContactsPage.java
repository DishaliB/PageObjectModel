package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveBtn;

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fName, String lName, String comp) {
		WebElement dropDownBox = driver.findElement(By.name("title"));
		Select select = new Select(dropDownBox);
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
	}

}
