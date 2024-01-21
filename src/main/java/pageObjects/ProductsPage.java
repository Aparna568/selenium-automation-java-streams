package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends Utillities {
WebDriver driver;
public ProductsPage(WebDriver driver) {
	super(driver);
	this.driver = driver;	
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="\"//div[contains(@class,'mb-3')]\"")
	private List<WebElement> products;
	
//	 By product =By.cssSelector("b");
	public  List<WebElement> getList(){
		implicitWait();
		return products;
	}

	public void selectProduct(String productName) {
		getList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);		
		
	}


}
