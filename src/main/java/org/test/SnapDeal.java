package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SnapDeal extends Tool {

	public static void main(String[] args) throws InterruptedException {
		browserLanch();
		loadurl("https://www.snapdeal.com/");
		getTitle();
		WebElement search=driver.findElement(By.id("inputValEnter"));
		fill(search,"iphones" );
		WebElement searchkey=driver.findElement(By.className("searchTextSpan"));
		click(searchkey);
		Thread.sleep(10000);
		List<WebElement> phones=driver.findElements(By.xpath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']"));
		for (int i = 0; i < phones.size(); i++) {
			System.out.println(phones.get(i).getText());
			
			
		}
		
			
		}
		
			
			
		}
	
	

