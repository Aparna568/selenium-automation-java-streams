package ecommerce.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderTests {
	   WebDriver driver;

	
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
	return driver;
	
}
   public void launchApplication() throws IOException {
	   driver = browserInit();
	   
   }
}
