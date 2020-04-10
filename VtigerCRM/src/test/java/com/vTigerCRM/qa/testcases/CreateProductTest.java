package com.vTigerCRM.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.pages.Homepage;
import com.vTigerCRM.qa.pages.ProductPage;
import com.vTigerCRM.qa.utils.TestUtils;

public class CreateProductTest extends TestBase {
	public static String sheetName = "Product_Data";
	public static String testDataSheetPath = "G:\\Eclipse_New_Instance\\VtigerCRM\\src\\main\\java\\com\\vTigerCRM\\qa\\testdata\\VtigerExcelData.xlsx";

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestData(sheetName, testDataSheetPath);
		return data;
	}
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateProductTest(String productName,String dropdownText,String descriptionText) {
		ProductPage	productPage= new ProductPage();
		Homepage homepage = new Homepage();
		homepage.clickOnProductsLink();
		String title = productPage.validateProductPageTitle();
		Assert.assertEquals(title,"Administrator - Products - vtiger CRM 5 - Commercial Open Source CRM");
		
		Reporter.log("validateProductPageTitle successfully", true);
		
		boolean flag = productPage.validateProductsLink();
		Assert.assertTrue(flag);
		
		Reporter.log("validateProductsLink successfully", true);

		//productPage.clickOnCreateProductBtn();
		//productPage.createProduct("Redmi", "4", "xyzxyzxyz");
		productPage.createProduct(productName, dropdownText, descriptionText);
		
		Reporter.log("createProduct successfully", true);

	}
	
}
