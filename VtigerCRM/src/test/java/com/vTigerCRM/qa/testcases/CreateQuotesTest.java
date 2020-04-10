package com.vTigerCRM.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.pages.Homepage;
import com.vTigerCRM.qa.pages.LoginPage;
import com.vTigerCRM.qa.pages.QuotesPage;
import com.vTigerCRM.qa.utils.TestUtils;

public class CreateQuotesTest extends TestBase {

	public static String sheetName = "Quote_Data";
	public static String testDataSheetPath = "G:\\Eclipse_New_Instance\\VtigerCRM\\src\\main\\java\\com\\vTigerCRM\\qa\\testdata\\VtigerExcelData.xlsx";

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestData(sheetName, testDataSheetPath);
		return data;
	}

	@Test(priority = 5, dataProvider = "getCRMTestData")
	public void CreateQuotes(String subject, String marketingGroupDropdownText, String quotestageDropdownText,
			String bill_streetText, String ship_streetText, String descriptionText, String qtyText)
			throws InterruptedException
	{
		Homepage homepage = new Homepage();
		QuotesPage quotesPage = new QuotesPage();
	
		homepage.moreOptions();
		homepage.clickOnQuotesLink();
		
		String title = quotesPage.validateQuotesPageTitle();
		Assert.assertEquals(title, "Administrator - Quotes - vtiger CRM 5 - Commercial Open Source CRM");
	
		boolean flag = quotesPage.validateQuotesLink();
		Assert.assertTrue(flag);
		
		quotesPage.clickOnCreateQuotesBtn();
		quotesPage.createQuotes(subject, marketingGroupDropdownText, quotestageDropdownText, bill_streetText,
				ship_streetText, descriptionText, qtyText);
	}

}
