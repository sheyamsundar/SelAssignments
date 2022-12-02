package week4.assm1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id = 'partyIdFrom']/following::a")).click();
		
		//Click on First Resulting Contact
		Set<String> fwindowHandles = driver.getWindowHandles();
		List<String> fwindows = new ArrayList<String>(fwindowHandles);
		
		driver.switchTo().window(fwindows.get(1));
		driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell-inner')]/a")).click();
//		driver.close();
		
		//Click on Widget of To Contact
		driver.switchTo().window(fwindows.get(0));
		driver.findElement(By.xpath("//input[@id = 'partyIdTo']/following::a")).click();
		//List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class , 'x-grid3-row-table')]/tbody/tr/td[1]//a"));
		//WebElement firstElement = findElements.get(0);
		//firstElement.click();
		
		//Click on Second Resulting Contact
		Set<String> twindowHandles = driver.getWindowHandles();
		List<String> twindows = new ArrayList<String>(twindowHandles);
		
		driver.switchTo().window(twindows.get(1));
		List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class , 'x-grid3-row-table')]/tbody/tr/td[1]//a"));
		WebElement secondElement = findElements.get(1);
		secondElement.click();
		//driver.findElement(By.xpath("(//div[contains(@class, 'x-grid3-cell-inner')]/a)[2]")).click();
		//driver.close();
		
		//Click on Merge button using Xpath Locator
		driver.switchTo().window(twindows.get(0));
		driver.findElement(By.xpath("(//input[@id = 'partyIdTo']/following::a)[2]")).click();
		
		//Accept the Alert
		driver.switchTo().alert().accept();
		
		// Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		String myTitle = "View Contact";
		System.out.println(title.contains(myTitle));

	}

}
