package ecommerce.tests;

import org.testng.annotations.Test;
import java.io.IOException;


import org.testng.Assert;

import ecommerce.pageObjects.CartPage;
import ecommerce.pageObjects.CheckoutPage;
import ecommerce.pageObjects.FinalPage;
import ecommerce.pageObjects.ProductsPage;

public class TestOrder extends BaseTest {
	@Test
		public void testMethod() throws IOException {
		String productName = "ZARA COAT 3";
		String country = "India";
		String actual ="THANKYOU FOR THE ORDER.";
		login.enterEmail("aparnasabb@gmail.com");
		login.enterPassword("qwertyuiop@1A");
		ProductsPage prod =login.enterClick();
		prod.selectProduct(productName);
		prod.addToCartIcon();
		prod.visibiltyOfElement();
		CartPage cartPage  = prod.cart();
		Boolean match = cartPage.listCart(productName);
		Assert.assertTrue(match);
		CheckoutPage checkout = cartPage.checkoutButton();
		FinalPage finalPage = checkout.selection(country);
		String confirmationMessage =finalPage.getMessage();
		Assert.assertEquals(confirmationMessage, actual);
		driver.quit();
	}
}
