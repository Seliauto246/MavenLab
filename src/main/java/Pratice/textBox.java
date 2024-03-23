package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class textBox {
	WebDriver driver;
	
	@Test
	public void dropdown() throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		Thread.sleep(3000);
		
		String title = driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[1]/app-menu/div/header/p")).getText();
		
		System.out.println(title);
		Assert.assertEquals(title,"Input" );
		
		driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[1]/app-menu/div/footer/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("fullName")).sendKeys("Bayako Saka");
		driver.findElement(By.id("join")).clear();
		driver.findElement(By.id("join")).sendKeys("I am good here");
		driver.findElement(By.id("join")).sendKeys(Keys.TAB);
		driver.findElement(By.id("getMe")).getAttribute("value");
		Boolean check =driver.findElement(By.id("noEdit")).isEnabled();
		
		if(check == false)
		{
			System.out.println("Textbox is disabled");
			
		}
		else 
		{
			System.out.println("Textbox is enabled");
		}
	}
}
		
		


