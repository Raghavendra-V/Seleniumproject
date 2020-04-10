package com.vTigerCRM.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTigerCRM.qa.pages.Homepage;
import com.vTigerCRM.qa.pages.LoginPage;
import com.vTigerCRM.qa.utils.TestUtils;
import com.vTigerCRM.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public WebDriverWait wait;
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"G:\\Eclipse_New_Instance\\vTigerCRMTest\\src\\main\\java\\com\\vTigerCRM\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeClass
	public void configBC() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webDriver.chrome.driver", "G:\\Eclipse_New_Instance\\VtigerCRM\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// else if (browserName.equals("FireFox")) {
		// driver.new firefoxDriver();}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    wait= new WebDriverWait(driver, 30);
		driver.get(prop.getProperty("url"));
	}
	@BeforeMethod
	public void configBM() {
	    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	    loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void configAC() {
		Homepage homepage= PageFactory.initElements(driver, Homepage.class);
		homepage.signOut();
	}
	@AfterClass
	public void configaAM() {
		driver.close();
	}
	
}