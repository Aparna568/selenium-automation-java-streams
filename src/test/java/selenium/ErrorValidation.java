package selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import ecommerce.pageObjects.CartPage;
import ecommerce.pageObjects.CheckoutPage;
import ecommerce.pageObjects.FinalPage;
import ecommerce.pageObjects.OrdersPage;
import ecommerce.pageObjects.ProductsPage;
import ecommerce.tests.BaseTest;

public class ErrorValidation extends BaseTest {
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
@Test(groups= {"ErrorHandling","purchase"},dataProvider="dataP")

public void productValidationTest(HashMap<String,String> input) {

	 login.enterEmail(input.get("email"));
	 login.enterPassword(input.get("password"));
	 ProductsPage prod =login.enterClick();
	prod.getProductByName(input.get("product"));
		prod.addToCartIcon(input.get("product"));
		prod.visibiltyOfElement();
		CartPage cartPage = prod.cart(); 
		Boolean match = cartPage.listCart(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkout = cartPage.checkoutButton();
		FinalPage finalPage = checkout.selection(country);
		String confirmationMessage =finalPage.getMessage();
		Assert.assertEquals(confirmationMessage, actual);
 }
@Test(dependsOnMethods="productValidationTest")
public void orderValidation() {
	String productName = "ZARA COAT 3";
	 login.enterEmail("michaelscott@gmail.com");
	 login.enterPassword("12345678A@a");
	 ProductsPage prod =login.enterClick();
	 OrdersPage orderPage =prod.ordervalid();
	 Assert.assertTrue(orderPage.desiredOrder(productName));
	
}

@DataProvider(name ="dataP")
public Object[][]  getData() throws IOException {

List<HashMap<String,String>> data = 	getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ecommerce//data//PurchaseOrder.json");
return new Object[][] {{data.get(0)}, {data.get(1)}};
}
public void configuration() {
String path = System.getProperty("user.dir"+"\\reports\\index.html");
ExtentSparkReporter reporter = new ExtentSparkReporter(path);
reporter.config().setReportName("Automation Results");
reporter.config().setDocumentTitle("Test Report");
}

}