package ecommerce.pageObjects;

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
	@FindBy(css ="[class*='flyInOut']")
	private WebElement errorMess;
	
	@FindBy(id="userEmail")
	private WebElement email;
	
	@FindBy(id="userPassword")
	private WebElement password;

	@FindBy(id="login")
	private WebElement login;
	
	public void goTo() {
		openUrl("https://rahulshettyacademy.com/client");
	}
	public LoginPage enterEmail(String id) {
		email.sendKeys(id);
		return this;
	}
	
	public LoginPage enterPassword(String passwd) {
		password.sendKeys(passwd);
		return this;
	}
	public ProductsPage enterClick() {
clickMethod(login);	
	return new ProductsPage(driver);
	}
	public String errorWake() {
		explicitWaitEle(driver, errorMess, 5);
		return errorMess.getText();

		
	}
	
}
