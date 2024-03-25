package Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class javaStream {
	
	WebDriver driver;
	
	@Test
	public void jStream() {
	
	ArrayList<String> names = new ArrayList<String>();
	names.add("Henry14");
	names.add("Dennis10");
	names.add("Sanchez7");
	names.add("jesus9");
	names.add("Toney4");
	
	names.stream().forEach(s->System.out.println(s));
	

	}
	
	@Test
	public void usingStreamList() {
		
	Stream.of("Nekeitah14","Saka7","Rowe10","Rice31","Saliba2")	.filter(s->s.contains("a")).forEach(s->System.out.println(s));
	
	List<String> lname = Arrays.asList("Eddie","Bokayo","Smith","Declane","William");
	
	lname.stream().filter(s->s.endsWith("e")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		
		
		
	}

}
