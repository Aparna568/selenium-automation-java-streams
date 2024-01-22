package selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ecommerce.pageObjects.CartPage;
import ecommerce.pageObjects.CheckoutPage;
import ecommerce.pageObjects.FinalPage;
import ecommerce.pageObjects.LoginPage;
import ecommerce.pageObjects.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://rahulshettyacademy.com/client");
		String productName = "ZARA COAT 3";
		String country = "India";
		String actual ="THANKYOU FOR THE ORDER.";
		LoginPage login = new LoginPage(driver);
		login.goTo();
		login.enterEmail("aparnasabb@gmail.com");
		login.enterPassword("qwertyuiop@1A");
		login.enterClick();
		ProductsPage prod = new ProductsPage(driver);
		prod.selectProduct(productName);
		prod.addToCartIcon();
		prod.visibiltyOfElement();
		prod.cart();
		CartPage cartPage = new CartPage(driver);
		cartPage.listCart(productName);
		cartPage.checkoutButton();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.selection(country);
		FinalPage finalPage = new FinalPage(driver);
		finalPage.getMessage(actual);
		driver.quit();
		

	}

}