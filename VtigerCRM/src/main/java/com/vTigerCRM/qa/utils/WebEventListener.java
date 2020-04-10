package com.vTigerCRM.qa.utils;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.vTigerCRM.qa.Base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		Reporter.log("Before navigating to: '" + url + "'",true);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		Reporter.log("Navigated to:'" + url + "'",true);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		Reporter.log("Value of the:" + element.toString()
				+ " before any changes made",true);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		Reporter.log("Element value changed to: " + element.toString(),true);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Trying to click on: " + element.toString(),true);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Clicked on: " + element.toString(),true);
	}

	public void beforeNavigateBack(WebDriver driver) {
		Reporter.log("Navigating back to previous page",true);
	}

	public void afterNavigateBack(WebDriver driver) {
		Reporter.log("Navigated back to previous page",true);
	}

	public void beforeNavigateForward(WebDriver driver) {
		Reporter.log("Navigating forward to next page",true);
	}

	public void afterNavigateForward(WebDriver driver) {
		Reporter.log("Navigated forward to next page",true);
	}

	public void onException(Throwable error, WebDriver driver) {
		Reporter.log("Exception occured: " + error,true);
			try {
				TestUtils.takeScreenShotAtEndOfTest();;
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Trying to find Element By : " + by.toString(),true);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Found Element By : " + by.toString(),true);
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("After Alert Accepted",true);
	}

	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("After Alert Dismissed",true);
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String text, WebDriver driver) {
		Reporter.log("After Switching To Window : "+text,true);
	}

	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("Before Alert Accepted",true);
	}

	public void beforeAlertDismiss(WebDriver driver) {
		Reporter.log("Before Alert Dismissed ",true);
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String text, WebDriver driver) {
		Reporter.log("Before Switching To Window : "+text,true);
	}


}
