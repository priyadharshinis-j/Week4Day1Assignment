package week4Day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {
//	https://www.leafground.com/window.xhtml
//        Click Open Multiple 
//        Get the size of available Windows
//        switch to last window 
//        Get the Title of the Window
//         Close all the windows except last window
	
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.leafground.com/window.xhtml");
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Total number of windows===> "+windowHandles.size());
		List<String> window = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(window.get(window.size()-1));
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println("Title of the window is====> "+title);
		
		for(int i=0;i<=window.size()-2;i++)
		{
			driver.switchTo().window(window.get(i));
			driver.close();
		}
	
		
		
		
		
	}

}
