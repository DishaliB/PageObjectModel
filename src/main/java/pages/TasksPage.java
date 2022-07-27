package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class TasksPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Tasks')]")
	WebElement tasksLabel;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(name = "priority")
	WebElement priority;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveBtn;


	public TasksPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean tasksLable() {
		return tasksLabel.isDisplayed();
	}
	
	public void createNewTask(String titleName, String prior) {
		title.sendKeys(titleName);
		WebElement priorDDBox = priority;
		Select select = new Select(priorDDBox);
		select.selectByVisibleText(prior);
		saveBtn.click();
	}

}
