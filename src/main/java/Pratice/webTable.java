package Pratice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.opentelemetry.sdk.metrics.data.SumData;

@Test
public class webTable {
	
	WebDriver driver;
	File f;
	FileWriter fw;
	BufferedWriter bw;
	String src = "/Users/sanjayshrestha/eclipse-workspace/Seli@2024//textnew.txt";
	
		public void readWebtable() throws IOException {
	
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		fw = new FileWriter (src);
		bw= new BufferedWriter (fw);
		WebElement content = driver.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[2]/div[1]"));
		List<WebElement> myRows =content.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        
		int sum =0;
		
	     for (int i=0;i<myRows.size();i++)
	     {
	    	 sum = sum+Integer.valueOf(myRows.get(i).getText());
	    	
	    	 
	     }
		
	     System.out.print(sum);
		}
		
		@Test
		public void dynamicData() {
	
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		String txt =driver.findElement(By.id("ebcaptchatext")).getText();
		String txt1 = txt.substring(8, 9);
		String txt2 = txt.substring(12,13);
		
		int add = Integer.valueOf(txt1) + Integer.valueOf(txt2);
		System.out.println(add);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(add));
		Boolean checkbox =driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
		
		if (checkbox == true)
			
		{
			System.out.println("Checkbox enabled");
		}
		
		else 
		{
			System.out.println("Checkbox disabled");
			
		}
		
		
		
	}
		
		
		
		
	}


