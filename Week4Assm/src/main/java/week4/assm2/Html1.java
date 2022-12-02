package week4.assm2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://html.com/tags/table/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class ='attributes-list']/tbody/tr"));
		System.out.println("No. of rows: "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class ='attributes-list']/tbody/tr[2]/td"));
		System.out.println("No. of columns: "+columns.size());
		

	}

}
