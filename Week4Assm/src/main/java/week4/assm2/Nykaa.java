package week4.assm2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//div[@id = 'brand_arrowUp']/preceding-sibling::a"));
		Actions action = new Actions(driver);
		action.moveToElement(brands).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		//Click L'Oreal Paris
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println(driver.getTitle().contains("L'Oreal Paris"));
		Thread.sleep(3000);
		//Click sort By and select customer top rated
		driver.findElement(By.xpath("//button[contains(@class , 'css-n0ptfk')]")).click();
		driver.findElement(By.xpath("//label[contains(@for , 'radio_customer')]")).click();
		Thread.sleep(3000);
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//div[@id = 'first-filter']/div")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair']/parent::div")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair Care']/parent::div[contains(@class , 'css-b5p5ep')]")).click();
		driver.findElement(By.xpath("//label[@for = 'checkbox_Shampoo_316']")).click();
		Thread.sleep(3000);
		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[contains(text(), 'Concern')]/parent::div")).click();
		driver.findElement(By.xpath("//span[text() = 'Color Protection']")).click();
		//check whether the Filter is applied with Shampoo
		List<WebElement> filters = driver.findElements(By.xpath("//span[@class = 'filter-value']"));
		System.out.println(filters.get(0).getText().contains("Shampoo"));
		System.out.println(filters.get(1).getText().contains("Color Protection"));
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.className("css-1rd7vky")).click();
		//GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Select mlSize = new Select(driver.findElement(By.className("css-2t5nwu")));
		mlSize.selectByVisibleText("175ml");
		//Print the MRP of the product
		System.out.println(driver.findElement(By.className("css-1jczs19")).getText());
		//Click on ADD to BAG
		driver.findElement(By.xpath("//span[@class = 'btn-text']/parent::button")).click();
		//Go to Shopping Bag 
		driver.findElement(By.className("cart-count")).click();
		//Print the Grand Total amount
		WebElement iframe = driver.findElement(By.xpath("//div[@id = 'portal-root']//iframe"));
		driver.switchTo().frame(iframe);
		String grandTotal = driver.findElement(By.xpath("//span[contains(@class , 'css-n8gwxi e171rb9k3')]")).getText();
		System.out.println(grandTotal);
		//Click Proceed
		driver.findElement(By.xpath("//span[text() = 'Proceed']")).click();
		Thread.sleep(3000);
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[text() = 'Continue as guest']")).click();
		//Check if this grand total is the same in step 14
		String total = driver.findElement(By.xpath("//p[contains(@class , 'css-5t7v9l eka6zu20')]")).getText();
		System.out.println(total.contains(grandTotal));
		//Close all windows
		driver.quit();

	}

}
