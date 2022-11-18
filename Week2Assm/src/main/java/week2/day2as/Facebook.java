package week2.day2as;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		driver.findElement(By.xpath("//div[@class = '_6ltg']/a")).click();
		
		//Enter the first name
		driver.findElement(By.xpath("//div[@id = 'fullname_field']//input[@name = 'firstname']")).sendKeys("Sheyam");
		//Enter the last name
		driver.findElement(By.xpath("//div[@id = 'fullname_field']//input[@name = 'lastname']")).sendKeys("Sundar");
		//Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		//Enter the password
		driver.findElement(By.xpath("//div[@id = 'password_field']//input")).sendKeys("@Sheyam123");
		
		//Date
		Select date = new Select (driver.findElement(By.id("day")));
		date.selectByIndex(5);
		
		//Month
		Select month = new Select (driver.findElement(By.id("month")));
		month.selectByVisibleText("Apr");
		
		//Year
		Select year = new Select (driver.findElement(By.id("year")));
		year.selectByValue("1999");
		
		//Gender Radio button
		driver.findElement(By.xpath("//label[text() = 'Male']")).click();

	}

}
