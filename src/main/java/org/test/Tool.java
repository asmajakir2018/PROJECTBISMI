package org.test;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tool {
	static WebDriver driver;
	static Select s;
	public static void browserLanch() {
		{
			try {
				System.setProperty("webdriver.chrome.driver", "E:\\java\\Asma\\drivers\\chromedriver.exe");
				driver=new ChromeDriver();
				System.out.println("Browser lanched successfully");
			
			}
			catch(Exception e)
			{
				e.getMessage();
				System.out.println("browser not lanched");
			}
			
			
		}

	}
	public static void maximize() {
		driver.manage().window().maximize();
		}
	public static void loadurl(String url) {
		driver.get(url);
	}
	public static void getTitle(){
		String title = driver.getTitle();
		System.out.println(title);
		

	}
	public static void fill(WebElement ele,String value) {
		
ele.sendKeys(value);
	}
	public static void getAttribute(WebElement ele,String value) 
	{
		
String attribute = ele.getAttribute(value);

	System.out.println(attribute);
}

	
	
	public static String getData(int row,int cell) throws IOException {
		File loc=new File("E:\\java\\Asma\\data\\tools.xlsx");
		FileInputStream stream=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s=w.getSheet("Sheet1");
		Row r=s.getRow(row);
		Cell c=r.getCell(cell);
		String value=null;
		int cellType=c.getCellType();
		if(cellType==1)
		{
			value=c.getStringCellValue();
		}
		else if(cellType==0)
		{
			if(DateUtil.isCellDateFormatted(c))
			{
				Date d=c.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("MM/dd/yyyy");
				value=sd.format(d);
				
			}
			else
			{
				double numericCellValue=c.getNumericCellValue();
				long l=(long) numericCellValue;
				value=String.valueOf(l);
				
				
			}
		}
		
		return value;
		

	}
public static void click(WebElement ele)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",ele);
	

}

public static void selectVisibleText(String value) {
	s.selectByVisibleText(value);
}

public static void select(WebElement ele)
{
	s=new Select(ele);
}
public static boolean checkmultiple(WebElement ele)
{
	boolean multiple=s.isMultiple();
	return multiple;
}
}













