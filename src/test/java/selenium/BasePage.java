package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class BasePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage login = new LoginPage(driver);
		login.enterEmail("aparnasabb@gmail.com");
		login.enterPassword("qwertyuiop@1A");
		login.enterClick();
		ProductsPage prod = new ProductsPage(driver);
		prod.selectProduct("\"ZARA COAT 3\"");
		
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		WebElement product = products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			

			product.findElement(By.xpath("//div[@class='container']//div[1]//div[1]//div[1]//button[2]")).click();
			
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))) ;    
			driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
			List<WebElement> cartItem = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
			Boolean match = cartItem.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
			
			Assert.assertTrue(match);
			driver.findElement(By.xpath("//button[text()='Checkout']")).click();
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
			String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
			System.out.println(message);
			Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			driver.quit();
	}

}
