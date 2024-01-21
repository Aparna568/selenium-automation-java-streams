package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utillities{
 WebDriver driver;
 
 public LoginPage(WebDriver driver) {
	 super(driver);
	 this.driver =driver;
	 PageFactory.initElements(driver, this);
 }
	
	@FindBy(id="userEmail")
	private WebElement email;
	
	@FindBy(id="userPassword")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement login;
	
	public void enterEmail(String id) {
		email.sendKeys(id);
	}
	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
		
	}
	public void enterClick() {
		login.click();
	}
	
	
}
