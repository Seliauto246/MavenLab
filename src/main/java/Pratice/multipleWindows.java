package Pratice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



@Test
public class multipleWindows {
	WebDriver driver;

	public void mulWindows() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	String exp_title ="Window Handles Practice";
	String act_title =driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div[1]/div/div[1]/div[1]/div/h1")).getText();
	if (exp_title.equals(act_title))
	{
		System.out.println("Title macthed");
	}
	else
	{
		System.out.println("Title not macthed");
	}
	
	driver.findElement(By.id("name")).sendKeys("Test before Swtc Window");
	 
	driver.findElement(By.id("newWindowBtn")).click();
	Thread.sleep(3000);
	 Set <String> allWinds = driver.getWindowHandles(); 
	 System.out.println(allWinds.size());
	 Iterator<String> it = allWinds.iterator();
	 String Win1= it.next();
	 System.out.println("Window 1 title="+driver.getTitle());
	 String Win2=it.next();
	 driver.switchTo().window(Win2);
	 System.out.println("Window 2 title="+driver.getTitle());
	 driver.manage().window().maximize();
	 String textsp =driver.findElement(By.xpath("//*[@id=\"Feed1_feedItemListDisplay\"]/ul/li[1]/span[1]/a")).getText();
	 String enterWin1 =driver.findElement(By.xpath("//*[@id=\"Feed1_feedItemListDisplay\"]/ul/li[1]/span[1]/a")).getText().split(":")[1].trim();
	 driver.switchTo().window(Win1);
	 driver.findElement(By.name("name")).sendKeys(enterWin1);
	 
	 
	 
	 
	 
	 

	
	 
	
	 

	
	 
	 
		
		
	}

}
