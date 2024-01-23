package selenium;

import org.testng.annotations.Test;
import org.testng.Assert;

import ecommerce.pageObjects.CartPage;
import ecommerce.pageObjects.CheckoutPage;
import ecommerce.pageObjects.FinalPage;
import ecommerce.pageObjects.OrdersPage;
import ecommerce.pageObjects.ProductsPage;
import ecommerce.tests.BaseTest;

public class ErrorValidation extends BaseTest {
	String productName = "ZARA COAT 3";
String country= "India";
String actual ="THANKYOU FOR THE ORDER.";
@Test
public void loginValidationTest() {
	
login.enterEmail("apar@gmail.com");
login.enterPassword("qwertyuiop@1A");
login.enterClick();
login.errorWake();
Assert.assertEquals("Incorrect email or password.",login.errorWake());

}
@Test(groups= {"ErrorHandling"})

public void productValidationTest() {

	 login.enterEmail("michaelscott@gmail.com");
	 login.enterPassword("12345678A@a");
	 ProductsPage prod =login.enterClick();
	prod.selectProduct(productName);
		prod.addToCartIcon();
		prod.visibiltyOfElement();
		CartPage cartPage = prod.cart(); 
		Boolean match = cartPage.listCart("ZARA COAT 33");
		Assert.assertFalse(match);
		CheckoutPage checkout = cartPage.checkoutButton();
		FinalPage finalPage = checkout.selection(country);
		String confirmationMessage =finalPage.getMessage();
		Assert.assertEquals(confirmationMessage, actual);
 }
@Test(dependsOnMethods="productValidationTest")
public void orderValidation() {
	 login.enterEmail("michaelscott@gmail.com");
	 login.enterPassword("12345678A@a");
	 ProductsPage prod =login.enterClick();
	 OrdersPage orderPage =prod.ordervalid();
	 Assert.assertTrue(orderPage.desiredOrder(productName));
	
}
}
