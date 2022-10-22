package week4Day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomer {
//	Salesforce Customer service:
//		1.Launch the browser
//		2.Load the url as " https://login.salesforce.com/ "
//		3.Enter the username as " ramkumar.ramaiah@testleaf.com "
//		4. Enter the password as " Password#123 "
//		5.click on the login button
//		6.click on the learn more option in the Mobile publisher
//		7.Switch to the next window using Windowhandles.
//		8.click on the confirm button in the redirecting page
//		9.Get the title
//		10.Get back to the parent window
//		11.close the browser
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.xpath("//div[@id='idcard-container']/following-sibling::input")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(window.get(1)); 
		
		driver.findElement(By.xpath("//p[@class='warning']/following-sibling::button[2]")).click();
		String title = driver.getTitle();
		System.out.println("Title of the page is===> "+title);
		
		driver.switchTo().window(window.get(0));
		Thread.sleep(2000);
		
		driver.quit();
	}
	

}
