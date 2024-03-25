package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actionsMousenKeyboard {
	
WebDriver driver;

@Test
public void ecommerce() {

	driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.getTitle();
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).clickAndHold().build().perform();
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[5]/span"))).click().build().perform();
	
	act.moveToElement(driver.findElement(By.id("ap_email"))).keyDown(Keys.SHIFT).sendKeys("henrythe14").build().perform();
	
	
}

}
