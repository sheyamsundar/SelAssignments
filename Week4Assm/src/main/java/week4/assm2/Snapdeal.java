package week4.assm2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Mens Fashion
		WebElement mensFashion = driver.findElement(By.xpath("//span[text() = \"Men's Fashion\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensFashion).perform();
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text() = 'Sports Shoes']")).click();
		
		//Get the count of the sports shoes
		String numSpShoes = driver.findElement(By.xpath("//h1[@class = 'category-name']/following-sibling::span")).getText();
		System.out.println("Number of sports shoes displayed: "+numSpShoes);
		
		//Click Training shoes
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		Thread.sleep(3000);
		
		//Sort by Low to High
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//ul[@class = 'sort-value']//li[@data-index = '1']")).click();
		Thread.sleep(3000);
		
		//Check if the items displayed are sorted correctly
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> priceList = new ArrayList<String>();
		for (WebElement idvPrice : prices) {
			priceList.add(idvPrice.getText());
		}
		
		Iterator<String> iter = priceList.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) > 0) {
	            System.out.println("Prices are not sorted");
	        }
	        previous = current;
	    }
	    System.out.println("Prices are in sorted order");
	    
	    //Select the price range (900-1200)
	    WebElement fromp = driver.findElement(By.name("fromVal"));
	    fromp.clear();
	    fromp.sendKeys("900", Keys.ENTER);
	    WebElement top = driver.findElement(By.name("toVal"));
	    top.clear();
	    top.sendKeys("1200", Keys.ENTER);
	    //driver.findElement(By.xpath("//div[contains(text() , 'GO')]")).click();
	    Thread.sleep(3000);
	    
	    //Filter with color Navy 
	    //Navy colour is disabled in the UI. Only one product in yellow colour is displayed
	    
	    // Mouse Hover on first resulting Training shoes
	    WebElement resultShoe = driver.findElement(By.className("picture-elem"));
	    action.moveToElement(resultShoe).perform();
	    
	    //click QuickView button
	    driver.findElement(By.xpath("//div[contains(@class , 'quick-view-bar')]")).click();
	    
	    //Print the cost and the discount percentage
	    String shoePrice = driver.findElement(By.className("payBlkBig")).getText();
	    System.out.println("Payable amount: "+shoePrice);
	    String discount = driver.findElement(By.xpath("//span[contains(@class , 'percent-desc ')]")).getText();
	    System.out.println("Discount applied: "+discount);
	    
	    //Take the snapshot of the shoes.
	    WebElement image = driver.findElement(By.className("cloudzoom"));
		File source = image.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/shoe.png");
		FileUtils.copyFile(source, dest);
		
		//Close the current window
		driver.findElement(By.xpath("//div[contains(@class , 'close ')]/i")).click();
		Thread.sleep(3000);
		//Close the main window
		driver.close();
	    
	    
	}

}
