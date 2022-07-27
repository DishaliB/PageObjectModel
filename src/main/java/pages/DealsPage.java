package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(id = "title")
	WebElement titleOfComp;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(name = "contact_lookup")
	WebElement contact;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveBtn;

	public DealsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean dealsLabel() {
		return dealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String title, String company, String primaryContact, String type, String source) {
		titleOfComp.sendKeys(title);
		companyName.sendKeys(company);
		contact.sendKeys(primaryContact);
		WebElement typeDDBox = driver.findElement(By.name("type"));
		Select select = new Select(typeDDBox);
		select.selectByVisibleText(type);
		WebElement sourceDDBox = driver.findElement(By.name("source"));
		Select slct = new Select(sourceDDBox);
		slct.selectByVisibleText(source);
		saveBtn.click();
	}

}
