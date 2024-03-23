package Pratice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;





public class button {

	WebDriver driver;
	
	public void buttonTest() throws InterruptedException {
	
		driver= new ChromeDriver();
		driver.get("https://letcode.in/test");
		Thread.sleep(3000);
		String title =driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[2]/app-menu/div/header/p")).getText();
        Assert.assertEquals(title,"Button");
        
        driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[2]/app-menu/div/footer/a")).click();
        driver.findElement(By.id("home")).click();
        
        
		
		
		
	}

}
