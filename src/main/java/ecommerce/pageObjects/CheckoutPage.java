package ecommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Utillities{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement countrySelect;
	By countryList =By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement selectCountry;
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	private WebElement submit;
	public FinalPage selection(String country) {
		Actions action = new Actions(driver);
		action.sendKeys(countrySelect,country).build().perform();
		explicitWait(driver, countryList, 5);
		clickMethod(selectCountry);
		clickMethod(submit);
		return new FinalPage(driver);
	}
	
	
	
}
