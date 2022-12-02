package week4.assm1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ssnceyfd5mtq1u38yu3inp0zh436503.node0");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click and Confirm new Window Opens
		driver.findElement(By.id("j_idt88:new")).click();
		Set<String> first = driver.getWindowHandles();
		List<String> firstList = new ArrayList<String>(first);
		System.out.println(driver.switchTo().window(firstList.get(1)).getTitle());
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(firstList.get(0));
		 
		//Find the number of opened tabs
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		
		Set<String> second = driver.getWindowHandles();
		List<String> secondList = new ArrayList<String>(second);
		System.out.println("Number of opened tabs:"+second.size());
		driver.switchTo().window(secondList.get(1));
		driver.close();
		driver.switchTo().window(secondList.get(2));
		driver.close();
		Thread.sleep(3000);
		
		//Close all windows except Primary
		//Wait for 2 new tabs to open
		driver.switchTo().window(secondList.get(0));
		driver.findElement(By.xpath("//span[text() = 'Open with delay']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		driver.quit();

	}

}
