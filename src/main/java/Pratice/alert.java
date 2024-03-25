package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alert {

WebDriver driver;

@Test
public void alertTest() {

	driver = new ChromeDriver();
	driver.get("https://letcode.in/test");
	String title =driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/header/p")).getText();
	Assert.assertEquals(title, "Alert");
	driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a")).click();
	driver.findElement(By.id("accept")).click();
	driver.switchTo().alert().accept();

	driver.findElement(By.id("confirm")).click();
	driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	driver.findElement(By.id("prompt")).click();
	driver.switchTo().alert().sendKeys("This is alert test");
	driver.switchTo().alert().accept();
	
	
	
	
}

}
