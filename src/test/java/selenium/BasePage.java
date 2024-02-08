package selenium;


import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ecommerce.pageObjects.CartPage;
import ecommerce.pageObjects.CheckoutPage;
import ecommerce.pageObjects.FinalPage;
import ecommerce.pageObjects.LoginPage;
import ecommerce.pageObjects.ProductsPage;
import ecommerce.tests.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage extends BaseTest{

@Test
	public void testMethod() throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		String productName = "ZARA COAT 3";
		String country = "India";
		String actual ="THANKYOU FOR THE ORDER.";
		LoginPage login = new LoginPage(driver);
		login.goTo();
		login.enterEmail("dwight@gmail.com");
		login.enterPassword("Dwight1@");
		login.enterClick();
		ProductsPage prod = new ProductsPage(driver);
		prod.getProductByName(productName);
		prod.addToCartIcon(productName);
		prod.visibiltyOfElement();
		prod.cart();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.listCart(productName);
		Assert.assertTrue(match);
		cartPage.checkoutButton();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.selection(country);
		FinalPage finalPage = new FinalPage(driver);
		String confirmationMessage =finalPage.getMessage();
		Assert.assertEquals(confirmationMessage, actual);
	}

}