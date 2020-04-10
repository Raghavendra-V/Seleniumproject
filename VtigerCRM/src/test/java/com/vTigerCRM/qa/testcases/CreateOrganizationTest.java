package com.vTigerCRM.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.pages.Homepage;
import com.vTigerCRM.qa.pages.OrganizationsPage;
import com.vTigerCRM.qa.utils.TestUtils;

public class CreateOrganizationTest extends TestBase{
	public static String sheetName = "Organisation_Data";
	public static String testDataSheetPath = "G:\\Eclipse_New_Instance\\VtigerCRM\\src\\main\\java\\com\\vTigerCRM\\qa\\testdata\\VtigerExcelData.xlsx";

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestData(sheetName, testDataSheetPath);
		return data;
	}
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateOrganizationTest(String organizationName, String dropdownText, String descriptionText) {
		Homepage homepage= new Homepage();
		OrganizationsPage organizationsPage = new OrganizationsPage();
		
		homepage.clickOnOrganizationLink();
		
		String title = organizationsPage.validateOrganizationsPageTitle();
		Assert.assertEquals(title,"Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		
		Reporter.log("validateOrganizationsPageTitle successfully", true);
		
		boolean flag = organizationsPage.validateOrganizationsLink();
		Assert.assertTrue(flag);
		
		Reporter.log("validateOrganizationsLink successfully", true);
		
		organizationsPage.clickOnCreateOrganizationBtn();
		organizationsPage.createOrganization(organizationName, dropdownText, descriptionText);
		Reporter.log("createOrganization successfully", true);
	
	}
}
