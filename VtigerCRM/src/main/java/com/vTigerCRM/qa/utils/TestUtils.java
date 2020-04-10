package com.vTigerCRM.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.vTigerCRM.qa.Base.TestBase;

public class TestUtils extends TestBase {
	public static long PAGE_LOAD_TIMEOUT =30;
	public static long IMPLICIT_WAIT = 30;

	public static void handlingDropdownByVisibleText(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	public static void handlingDropdownByValue(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByValue(text);
	}

	public static void moveToElement(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}
	
	public static void AlertAccept() {
		 driver.switchTo().alert().accept();
	}
	
	public static String windowHandles()
    {
    	Set<String> ids = driver.getWindowHandles();
        Iterator<String> itr = ids.iterator();
        String pid = itr.next();
        String cid = itr.next();
        driver.switchTo().window(cid);
       // AlertAccept();
		return pid;
    }
	public static  Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName,String testDataSheetPath )
	{
	FileInputStream file= null;
	try {
		file=new FileInputStream(testDataSheetPath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	}
	 catch (IOException e) {
			e.printStackTrace();
		}
	   sheet = book.getSheet(sheetName);
	  int row = sheet.getLastRowNum();
	  int column=sheet.getRow(0).getLastCellNum();
	  Object[][] data= new Object[row][column];
	  for (int i = 0; i < row; i++) {
		  for (int j = 0; j < column; j++) {
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	}
	
	public static void takeScreenShotAtEndOfTest() throws IOException {
		String date=new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
	   // String methodName=result.getMethod().getMethodName();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File("./Screenshot/"+date+".png");
		FileUtils.copyFile(src, dest);
 }
	
}
