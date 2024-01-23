package ecommerce.pageObjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OrdersPage extends Utillities {

public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);	
		}
@FindBy(xpath="//tr//td[2]")
private List<WebElement> orders;

//@FindBy(xpath="//tbody//tr[1]//td[2]")
//private WebElement purchasedProduct;




public boolean desiredOrder(String productPurchased) {
	return orders.stream().anyMatch(s->s.getText().equalsIgnoreCase(productPurchased));
	
}


}
