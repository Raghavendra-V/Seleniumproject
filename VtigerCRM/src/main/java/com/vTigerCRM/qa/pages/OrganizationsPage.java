package com.vTigerCRM.qa.pages;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.utils.TestUtils;

public class OrganizationsPage extends TestBase {
	
	@FindBy(xpath="//td[@class='moduleName']/a[text()='Organizations']")
	WebElement organizationsLink;

	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement createOrganizationBtn;
	
	@FindBy(xpath="//input[@name='accountname']")
	WebElement organizationNameTxtBox;
	
	@FindBy(xpath="//td[text()='Assigned To 			']/following-sibling::td/input[@value='T']")
	WebElement groupRadioBtn;

	@FindBy(xpath="//select[@name='assigned_group_id']")
	WebElement marketingGroupDropdown;
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBox' and @name=\"description\"]")
	WebElement descriptionTxtBox;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	WebElement saveBtn;
	
	public OrganizationsPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOrganizationsLink() {
		 organizationsLink.click();;
	}
	public boolean validateOrganizationsLink() {
		 return organizationsLink.isDisplayed();
	}
	public void clickOnCreateOrganizationBtn() {
		 createOrganizationBtn.click();
	}
	public String validateOrganizationsPageTitle() {
		return driver.getTitle();
	}
	public void createOrganization(String organizationName,String dropdownText,String descriptionText) {
		
		organizationNameTxtBox.sendKeys(organizationName);
		groupRadioBtn.click();
		marketingGroupDropdown.click();
	    TestUtils.handlingDropdownByVisibleText(marketingGroupDropdown, dropdownText);
	    descriptionTxtBox.sendKeys(descriptionText);	
	    saveBtn.click();
	}
}
