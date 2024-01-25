	package ecommerce.pageObjects;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class duplicate extends Utillities {
	WebDriver driver;
	WebElement listadded;
	public duplicate(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//div[contains(@class,'mb-3')]")
		private List<WebElement> products;
		
		@FindBy(xpath="//div[@class='container']//div[1]//div[1]//div[1]//button[2]")
		private WebElement addToCart;
		
		private By container = By.id("toast-container");
		 private By backDrop= By.cssSelector(".ng-animating");
		 @FindBy(xpath="//button[@routerlink='/dashboard/cart']")
		 private WebElement cart;
//		 By product =By.cssSelector("b");
		 
		 @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
		 private WebElement orderButton;
		public  List<WebElement> getList(){
			implicitWait();
			return products;
		}

		public WebElement getProductByName(String productName) {
		WebElement prod =getList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
		return prod;
		}
		
	public duplicate addToCartIcon(String productName) {
	 WebElement product =getProductByName(productName);
	 product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	 return this;
	}
	public duplicate visibiltyOfElement() {
		explicitWait(driver,container, 5);
		explicitWaitby(driver,driver.findElement(backDrop),5);
		return this;
		}

	public CartPage cart() {
		clickMethod(cart);
		return new CartPage(driver);
		
	}
	public OrdersPage ordervalid() {
		clickMethod(orderButton);
		return new OrdersPage(driver);
		
	}
	}


