package week4.assm2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.chittorgarh.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on stock market
		driver.findElement(By.linkText("STOCK MARKET")).click();
		
		// Click on NSE bulk Deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		//Get all the Security names
		List<WebElement> secuWebs = driver.findElements(By.xpath("//div[@class = 'table-responsive']/table//tbody/tr/td[3]"));
		List<String> secNames = new ArrayList<String>();
		System.out.println("Security Names:\n");
		for (WebElement secuWeb : secuWebs) {
			String secName = secuWeb.getText();
			System.out.println(secName);
			secNames.add(secName);
		}
		Set<String> hash = new HashSet<String>(secNames);
		
		//Ensure whether there are duplicate Security names
		if(secNames.size() == hash.size())
			System.out.println("\nThere are no duplicates");
		else
			System.out.println("\nThere are some duplicates");

	}

}
