package week4.assm2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dragAround = driver.findElement(By.className("ui-panel-title"));

		Actions action = new Actions(driver);
		//action.dragAndDropBy(dragAround, 0, 367);
		
		WebElement source = driver.findElement(By.xpath("//div[@id = 'form:drag_content']/parent::div[contains(@class , 'ui-draggable ui-draggable-handle')]"));
		WebElement target = driver.findElement(By.xpath("//div[@id = 'form:drop_header']/parent::div[contains(@class , 'ui-droppable')]"));
		action.dragAndDrop(source, target);
		
		WebElement sourceCol = driver.findElement(By.xpath("//div[@class = 'ui-datatable-tablewrapper']//thead//th[@aria-label = 'Category']"));
		WebElement targetCol = driver.findElement(By.xpath("//div[@class = 'ui-datatable-tablewrapper']//thead//th[@aria-label = 'Quantity']"));
		action.dragAndDrop(sourceCol, targetCol);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.className("ui-growl-title")).getText());
		
		WebElement sourceRow = driver.findElement(By.xpath("//tbody[@id = 'form:j_idt111_data']/tr[2]"));
		WebElement targetRow = driver.findElement(By.xpath("//tbody[@id = 'form:j_idt111_data']/tr[3]"));
		action.dragAndDrop(sourceRow, targetRow);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.className("ui-growl-title")).getText());
		

	}

}
