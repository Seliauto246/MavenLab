package Pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test(enabled =false)
public class dropDown {
	WebDriver driver;
	
	public void select() {
	driver = new ChromeDriver();
	driver.get("https://letcode.in/test");
	driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[3]/app-menu/div/footer/a")).click();

	Select option = new Select (driver.findElement(By.id("fruits")));
	List<WebElement> options =option.getOptions();
	for(int i=1; i<options.size();i++)
	{
		System.out.println(options.get(i).getText());
		if(options.get(i).getText().equalsIgnoreCase("Mango"))
		{
			options.get(i).click();
			break;
			
		}
	}
	
	}
		
	
	@Test
	public void multipleOptions() {
		
		driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[3]/app-menu/div/footer/a")).click();
		Select opt = new Select (driver.findElement(By.id("superheros")));
		List <WebElement> opts =opt.getOptions();
		
		for(int i=0;i<opts.size();i++)
		{
			
			
			System.out.println(opts.get(i).getText());
			
		}
		
		Boolean bol =opt.isMultiple();
		System.out.println(bol);
		
		opt.selectByIndex(0);
		opt.selectByValue("ca");
		opt.selectByVisibleText("Doctor Strange");
		
	}
		
		
		
		
		
		
	}


