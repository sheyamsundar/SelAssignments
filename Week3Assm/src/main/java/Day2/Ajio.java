package Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To close the allow location pop up
		//driver.findElement(By.className("ic-close-quickview")).click();
		
		//In the search box, type as "bags" and press enter
		driver.findElement(By.xpath("//div[@class = 'searchbar-view']//input")).sendKeys("bags",Keys.ENTER);
		
		//To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		
		//Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for = 'Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		
		//Print the count of the items Found.
		String numofItems = driver.findElement(By.className("length")).getText();
		System.out.println("No. of items: "+numofItems);
		
		//Get the list of brand of the products displayed in the page and print the list.
		List<WebElement> brandsList = driver.findElements(By.className("brand"));
		System.out.println("Total no of brands displayed: "+brandsList.size());
		
		System.out.println("\nBrands List:");
		for (WebElement webElement : brandsList) {
			
			String brand = webElement.getText();
			System.out.println(brand);
		}
		
		//Get the list of names of the bags and print it
		List<WebElement> bagNames = driver.findElements(By.className("nameCls"));
		System.out.println("\nBag Names:");
		
		for (WebElement webElement : bagNames) {
			
			String bagName = webElement.getText();
			System.out.println(bagName);
		}

	}

}
