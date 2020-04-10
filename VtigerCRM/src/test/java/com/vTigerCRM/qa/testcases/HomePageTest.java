package com.vTigerCRM.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.pages.Homepage;

public class HomePageTest extends TestBase {

	@Test(priority = 2)
	public void verifyHomePageTest() {
		Homepage homepage = new Homepage();
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		Reporter.log("validateHomePageTitle successfully", true);
		boolean flag = homepage.validateHomeLink();
		Assert.assertTrue(flag);
		Reporter.log("validateHomeLink successfully", true);
	}

}
