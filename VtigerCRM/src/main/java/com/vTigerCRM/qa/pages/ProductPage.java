package com.vTigerCRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.utils.TestUtils;

public class ProductPage extends TestBase{
	
	@FindBy(xpath="//img[@title='Create Product...']")
	WebElement createProductBtn;
	
	@FindBy(xpath="//td[@class='moduleName']/a[text()='Products']")
	WebElement productsLink;
	
	@FindBy(xpath="//input[@name='productname']")
	WebElement productNameTxtBox;
	
	@FindBy(xpath="//td[text()='Handler 			']/following-sibling::td/input[@value='T']")
	WebElement groupRadioBtn;

	@FindBy(xpath="//select[@name='assigned_group_id']")
	WebElement marketingGroupDropdown;
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBox']")
	WebElement descriptionTxtBox;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	WebElement saveBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateProductsLink() {
		 return productsLink.isDisplayed();
	}
	public void clickOnCreateProductBtn() {
		 createProductBtn.click();
	}
	public String validateProductPageTitle() {
		return driver.getTitle();
	}
	public void createProduct(String productName,String dropdownText,String descriptionText) {
		clickOnCreateProductBtn();
		productNameTxtBox.sendKeys(productName);
		groupRadioBtn.click();
		marketingGroupDropdown.click();
	    TestUtils.handlingDropdownByVisibleText(marketingGroupDropdown, dropdownText);
	    descriptionTxtBox.sendKeys(descriptionText);	
	    saveBtn.click();
	}
}
