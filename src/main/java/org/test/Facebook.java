package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

//import org.apache.poi.common.usermodel.Fill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Facebook extends Tool {
	public static void main(String[] args) throws IOException, AWTException {
		browserLanch();
		maximize();
		loadurl("https://www.toolsqa.com/automation-practice-form");
		getTitle();
		//firstname
		
		WebElement firstname=driver.findElement(By.name("firstname"));
		fill(firstname,getData(1,0));
	    getAttribute(firstname,"value");
		//lastname
		
		WebElement lastname=driver.findElement(By.id("lastname"));
		fill(lastname,getData(1,1));
		getAttribute(lastname,"value");
		//date
		
		WebElement date=driver.findElement(By.id("datepicker"));
		fill(date,getData(1,2));
		getAttribute(date,"value");
		
		WebElement radio=driver.findElement(By.id("sex-1"));
		click(radio);
		WebElement exp=driver.findElement(By.id("exp-3"));
		click(exp);
		
		WebElement profession=driver.findElement(By.id("profession-1"));
		click(profession);
		
		WebElement autotool=driver.findElement(By.id("tool-1"));
		click(autotool);
		
		WebElement continent =driver.findElement(By.id("continents"));
	    select(continent);
	    selectVisibleText("Asia");
	    Robot r=new Robot();
	    WebElement multicont=driver.findElement(By.id("continentmultiple"));
	    select(multicont);
	    System.out.println("muti select drop down"+checkmultiple(multicont));
	    if(checkmultiple(multicont)==true)
	    {
	    	selectVisibleText("Asia");
	    	r.keyPress(KeyEvent.VK_CONTROL);
	    	selectVisibleText("North America");
	    	r.keyRelease(KeyEvent.VK_CONTROL);
	    	
	    }
	    WebElement sele=driver.findElement(By.id("selenium_commands"));
	    select(sele);
	    selectVisibleText("browser commands");
		
	}
	
	
		
		
		
		
				
			
		}
		
		
		
		
		
		
		
		
		
	

