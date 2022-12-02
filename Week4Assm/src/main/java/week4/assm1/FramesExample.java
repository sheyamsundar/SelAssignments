package week4.assm1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id = 'topic']/following-sibling::input")).sendKeys("Not a friendly topic");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		//driver.switchTo().defaultContent();
		
		//driver.switchTo().frame("frame2");
		Select animals = new Select(driver.findElement(By.id("animals"))); 
		animals.selectByVisibleText("Avatar");
		driver.switchTo().defaultContent();
		
		driver.close();

	}

}
