package ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FinalPage extends Utillities{
	WebDriver driver;
	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	private WebElement message;
	
	public void getMessage(String actual) {
		String messg = message.getText();
		System.out.println(messg);
		Assert.assertTrue(messg.equalsIgnoreCase(actual));
		

	}
}
