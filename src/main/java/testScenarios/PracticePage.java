package testScenarios;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticePage {
	
	WebDriver driver = new ChromeDriver();
	ArrayList<String> act_data = new ArrayList<String>();
	ArrayList<String> exp_data = new ArrayList<String>();
	File f;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	String src = "/Users/sanjayshrestha/eclipse-workspace/Seli@2024//TextFile.txt";
			
	
	
	   @Test (description= "radiobutton")
	
	   public void RadioButton() throws InterruptedException {
		
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.findElement(By.id("bmwradio")).click();
	     }
	
		@Test(description= "checkbox")
		public void CheckBox() {
		driver.get("https://www.letskodeit.com/practice");
		driver.findElement(By.id("bmwcheck")).click();
		driver.findElement(By.id("benzcheck")).click();
		driver.findElement(By.id("hondacheck")).click();
		
		}
		
		@Test(description= "switchwindows")
		public void SwitchWindow() throws InterruptedException {
		driver.get("https://www.letskodeit.com/practice");
		driver.findElement(By.id("openwindow")).click();
		Set<String> allWinIds = driver.getWindowHandles();
		String win1= null;
		String win2= null;
		
		Iterator<String> itr= allWinIds.iterator();
		if (itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
			
		}
		
		driver.switchTo().window(win2);
		System.out.println("Window 2="+driver.getTitle());
		driver.close();
		
		Thread.sleep(5000);
		driver.switchTo().window(win1);
		}
		
        @Test(description= "dropdown", priority =4)
		public void DropDown() {
			ArrayList<String> exp_data = new ArrayList<String>();
			exp_data.add("BMW");
			exp_data.add("Benz");
			exp_data.add("Honda");
		driver.get("https://www.letskodeit.com/practice");
		Select option = new Select (driver.findElement(By.id("carselect")));
		option.selectByIndex(0);
		List<WebElement> alloptions = option.getOptions();

		for(int i=0;i<alloptions.size();i++) 
		{
			System.out.println(alloptions.get(i).getText());
			if(exp_data.get(i).equals(alloptions.get(i).getText()))
			{
				System.out.println("Items Matched");
				
			}
			else
			{
				System.out.println("Items not Matched");
				
			}
		}
        }
		
		@Test(description= "multipleSelect", priority =5)
		
		public void MultipleSelect() {
		ArrayList<String> exp_data = new ArrayList<String>();
		exp_data.add("Apple");
		exp_data.add("Orange");
		exp_data.add("Peach");
		driver.get("https://www.letskodeit.com/practice");
		Select opts = new Select (driver.findElement(By.id("multiple-select-example")));
		driver.findElement(By.xpath("//*[@id=\"multiple-select-example\"]/option[3]")).click();
		List<WebElement> allopts = opts.getOptions();
		for(int i=0;i<allopts.size();i++)
		{
			System.out.println(allopts.get(i).getText());
			if (exp_data.get(i).equals(allopts.get(i).getText()))
			{
				System.out.println("Item Matched");
			}
	
			else 
			{
				System.out.println("Item not Macthed");
				
			}
		}
		}
			@Test (description="Enabled", priority=6)
		public void EnableDisable() {
			
			driver.get("https://www.letskodeit.com/practice");
			driver.findElement(By.id("disabled-button")).click();
			Boolean button = driver.findElement(By.id("enabled-example-input")).isEnabled();
			if(button == false) 
			{
				System.out.println("Textbox is disabled");
				driver.findElement(By.id("enabled-button")).click();
				Boolean enabledbuttn =driver.findElement(By.id("enabled-example-input")).isEnabled();
				if(enabledbuttn==true)
				{
					driver.findElement(By.id("enabled-example-input")).sendKeys("Test");
					
					
				}
			}
			}
			
			@Test (description= "switchalert", priority=7)
			
		public void switchalrt() throws InterruptedException {
			
			driver.get("https://www.letskodeit.com/practice");
			driver.findElement(By.id("alertbtn")).click();
			String alrt=driver.switchTo().alert().getText();
			System.out.println(alrt);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
			driver.findElement(By.id("confirmbtn")).click();
			String alrt1=driver.switchTo().alert().getText();
			System.out.println(alrt1);
			driver.switchTo().alert().dismiss();
			
				
			}
			
			@Test(description="mousehover", priority=8)
		public void mouseHover() {
			
			driver.get("https://www.letskodeit.com/practice");
			WebElement hovr= driver.findElement(By.id("mousehover"));
			Actions act = new Actions(driver);
			act.moveToElement(hovr).build().perform();
			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]"))).click().build().perform();
			
			}
			
			@Test( priority=9)
		public void writeWT () throws IOException {
		
		fw= new FileWriter(src);
		bw= new BufferedWriter(fw);
		
		driver.get("https://www.letskodeit.com/practice");
		WebElement alldata = driver.findElement(By.id("product"));
		List<WebElement> myRows = alldata.findElements(By.tagName("tr"));
		
		for (int i=1;i<myRows.size();i++)
		{
			List<WebElement> myClomns = myRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<myClomns.size();j++)
			
			bw.write(myClomns.get(j).getText());
			bw.newLine();
			//System.out.println(myClomns.get(j).getText());
		}
		
		bw.close();
						
						
	}
	   @Test (priority=10)
	    public void ReadWT() throws IOException {
	    
	    	fr = new FileReader(src);
	    	br= new BufferedReader(fr);
	    	
	    	String content = null;
	    	
	    	while((content= br.readLine()) !=null)
	    	{
	    		
	    	 exp_data.add(content);
	    	//System.out.println(content);
	    	 
	    	}
	    	
	    	br.close();
	    	
	    	 }
	   @Test(priority=11)
	    public void Webtabledata() {
	    	 
	    	driver.get("https://www.letskodeit.com/practice");
	    	driver.manage().window().maximize();
	    	WebElement alldata = driver.findElement(By.id("product"));
	    	List<WebElement> allRows = alldata.findElements(By.tagName("tr"));
	    	
	    	for(int i=1;i<allRows.size();i++)
	    	{
	    		List<WebElement>allColmns = allRows.get(i).findElements(By.tagName("td"));
	    		for(int j=0;j<allColmns.size();j++)
	    		{
	    		
	    			act_data.add(allColmns.get(j).getText());
	    		}
	    		
	    	}
	    	
	    	
	    	
	     }
	     @Test(priority=12)
	    public void compareData(){
	    	 
	    	for(int i=0;i<exp_data.size();i++)
	    	{
	    		if(exp_data.get(i).equals(act_data.get(i)))
	    			
	    		{
	    			Reporter.log("Data Macthed with TextFile");
	    		}
	    		else
	    		{
	    			Reporter.log("Data not Matched with TextFile");
	    			
	    		}
	    		
	    	}
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	     }
	   
	   
					
					
					
	}
				
				
				
				
				
				
			

			
			
			

			
			
			

		
	
		
		
		
	


	
	



