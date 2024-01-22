package ecommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;


public class CartPage extends Utillities {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//div[@class='cartSection']//h3")
private List<WebElement> cartList;
@FindBy(xpath="//button[text()='Checkout']")
private WebElement checkout;

public CartPage listCart(String productName) {
	Boolean match = cartList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	return this;
}
public void checkoutButton() {
	clickMethod(checkout);
}

}
