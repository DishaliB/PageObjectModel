package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.TestUtil;
import utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

public TestBase() throws IOException {
	
	FileInputStream f = new FileInputStream("C:\\Selenium_WorkSpace\\PageObjectModelPractise\\src\\main\\java\\config\\config.properties");
	prop = new Properties();
	prop.load(f);
	
}

public static void initialization() throws InterruptedException, IOException {
	String browser = prop.getProperty("browser");
	if(browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	} else if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver(); 
	} else {
		System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
		driver = new SafariDriver(); 
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}



}