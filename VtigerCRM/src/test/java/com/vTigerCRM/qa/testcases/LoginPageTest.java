package com.vTigerCRM.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.pages.Homepage;
import com.vTigerCRM.qa.pages.LoginPage;
    
	public class LoginPageTest extends TestBase {

		
		@Test(priority=1)
		public void loginPageTitleTest() {
			LoginPage loginPage= new LoginPage();
			
			String title = loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "vtiger CRM 5 - Commercial Open Source CRM");
			Reporter.log("validateLoginPageTitle successfully", true);
			
			boolean flag = loginPage.validateVtigerLogo();
			Assert.assertTrue(flag);
			Reporter.log("validateVtigerLogo successfully", true);
			
		    loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
			Reporter.log("login successfully", true);

		}
		
	}



