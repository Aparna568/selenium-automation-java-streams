package ecommerce.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerce.pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	   WebDriver driver;

	  public LoginPage login;
   public WebDriver browserInit() throws IOException {	
	   Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("/Users/shishir/eclipse-workspace/Selenium/src/main/java/ecommerce/resources/globalProperties.properties");
	properties.load(fis);
	String browserName = properties.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")){ 
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	
}
   @BeforeMethod(alwaysRun=true)
   public LoginPage launchApplication() throws IOException {
	   driver = browserInit();
	   login = new LoginPage(driver);
		login.goTo();
		return login;
	   
   }
   @AfterMethod(alwaysRun=true)
   public void closeApplication() {
		driver.quit();
   }
}
