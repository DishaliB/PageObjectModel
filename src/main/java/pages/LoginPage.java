package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import base.TestBase;

public class LoginPage extends TestBase{
	

	public LoginPage() throws IOException {
		super();
		
		
	}
	
	public String validateTitle() {
		 return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
	}
	
	public HomePage validateLogin(String un, String pwd) throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return new HomePage();
		
	}

}
