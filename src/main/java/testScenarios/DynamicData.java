package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicData {
	
	WebDriver driver;
	
	@Test
	public void MathCal() {
	
	driver = new ChromeDriver();
	driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
	driver.manage().window().maximize();
	String str = driver.findElement(By.id("ebcaptchatext")).getText();
	String str1 = str.substring(8, 9);
	String str2= str.substring(12, 13);
	
	System.out.println(str1+":"+str2);
	Integer res = Integer.valueOf(str1) + Integer.valueOf(str2);
	driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
	
	Boolean chckbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
	
	if (chckbutton == true)
	{
		
		System.out.println("Value entered is correct");
		
	}
	
	else 
	{
		System.out.println("Value entered is incorrect");
		
	}
	
	driver.quit();
		
		
	}

}
