package week4.assm1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonOneplus {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		//Get the price of the first product
		String firstMobPrice = driver.findElement(By.className("a-offscreen")).getText();
		System.out.println(firstMobPrice);
		//Print the number of customer ratings for the first displayed product
		String noofRatings = driver.findElement(By.xpath("//span[contains(@class , 'a-size-base')]")).getText();
		System.out.println(noofRatings);
		//Click the first text link of the first image
		driver.findElement(By.xpath("//div[contains(@class , 'a-section')]/img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		//Take a screen shot of the product displayed
		WebElement image = driver.findElement(By.xpath("//div[@id = 'imgTagWrapperId']/img"));
		File source = image.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/oneplus9pro.png");
		FileUtils.copyFile(source, dest);
		//Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		//Get the cart subtotal and verify if it is correct.
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println(subTotal.contains(firstMobPrice));
		//close the browser
		driver.quit();
		

	}

}
