package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Utillities {
WebDriver driver;

public Utillities(WebDriver driver) {
	this.driver = driver;
	
}

public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

}
