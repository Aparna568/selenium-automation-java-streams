package ecommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utillities {
WebDriver driver;

public Utillities(WebDriver driver) {
	this.driver = driver;
	
}

public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public WebElement explicitWait(WebDriver driver,By locator, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return driver.findElement(locator);
	
}
public WebElement explicitWaitby(WebDriver driver,WebElement element, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.invisibilityOf(element));
	return element;
	
}

public void clickMethod(WebElement element) {
	element.click();
	
}
public void openUrl(String URL) {
	driver.get(URL);
}
}
