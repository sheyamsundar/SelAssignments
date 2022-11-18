package week2.day1as;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter username and password using id locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login button using class locator
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter CompanyName, FirstName and LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Sheyam Sundar New");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sheyam");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sundar New");
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Sheyam");
		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		//Enter Description Field Using any Locator of your choice
		driver.findElement(By.name("description")).sendKeys("Broad minded Quality Analyst");
		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sundarsheyam@yopmail.com");
		//Select State/Province as NewYork Using Visible Text
		Select stateProvince = new Select (driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		stateProvince.selectByVisibleText("New York");
		//Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();
		//to get the page title
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
