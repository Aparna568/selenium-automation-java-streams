package selenium;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
driver.findElement(By.xpath("//tr/th[1]")).click();
List<String> priceList;
do {
List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
priceList = list.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
priceList.forEach(a->System.out.println(a));
if (priceList.size()<1) {
	driver.findElement(By.cssSelector("[aria-label='Next']")).click();
}
}while(priceList.size()<1) ;



}
	private static String getPrice(WebElement s) {
	String price =s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return price;
	}
}
