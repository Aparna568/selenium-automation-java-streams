package ecommerce.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerce.pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	   WebDriver driver;

	  public LoginPage login;
   public WebDriver browserInit() throws IOException {	
	   Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("/Users/shishir/eclipse-workspace/Selenium/src/main/java/ecommerce/resources/globalProperties.properties");
	properties.load(fis);
	String browserName = System.getProperty("browser")!=null?System.getProperty("browser"): properties.getProperty("browser");
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

   
   
   public List<HashMap<String,String>>  getJsonDataToMap(String filePath) throws IOException {
		String jsonContentLocation = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data =mapper.readValue(jsonContentLocation, new TypeReference<List<HashMap<String, String>>>(){});
		return  data;
		
		}
public String takeScreenshotMethod(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	
}
public void nameDesired() throws MalformedURLException {
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setBrowserName("Chrome");
	caps.setPlatform( Platform.WINDOWS);
	
	WebDriver driver = new RemoteWebDriver(new URL("https:192.168.1.139:4444"),caps);
	driver.get("https://www.google.com");
}
}
