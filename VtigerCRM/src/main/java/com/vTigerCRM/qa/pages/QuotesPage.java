package com.vTigerCRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.utils.TestUtils;

public class QuotesPage extends TestBase{
	
	 //Administrator - Quotes - vtiger CRM 5 - Commercial Open Source CRM
	 
	 @FindBy(xpath="//a[text()='Quotes']/parent::td[@class='moduleName']")
	 WebElement quotesLink;

	@FindBy(xpath="//img[@title='Create Quote...']")
	WebElement createQuoteBtn;
	
	@FindBy(xpath="//input[@name='subject']")
	WebElement subjectTxtBox;
	
	@FindBy(xpath="//select[@name='quotestage']")
	WebElement quotestageDropdown;
	
	@FindBy(xpath="//td[text()='Assigned To 			']/following-sibling::td/input[@value='T']")
	WebElement groupRadioBtn;

	@FindBy(xpath="//select[@name='assigned_group_id']")
	WebElement marketingGroupDropdown;
	
	@FindBy(xpath="//td[text()='Organization Name 			']/following-sibling::td/descendant::img")
	WebElement organisationNameImgBtn;
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']/ancestor::tr/following-sibling::tr/td/a")
	WebElement organizationName;
    
	@FindBy(xpath="//textarea[@name='bill_street']")
	WebElement bill_streetTxtBox;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	WebElement ship_streetTxtBox;
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBox' and @name='description']")
	WebElement descriptionTxtBox;
	
	
	@FindBy(xpath="//img[@title='Products']")
	WebElement productsLink;

	@FindBy(xpath="//a[@class='listFormHeaderLinks']/ancestor::tr/following-sibling::tr/td[2]/a")
	WebElement productName;
	
	
	@FindBy(xpath="//input[@id='qty1']")
	WebElement qtyTxtBox;
	

	@FindBy(xpath="//input[@class='crmbutton small save']")
	WebElement saveBtn;
	
	
	public QuotesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateQuotesLink() {
		 return quotesLink.isDisplayed();
	}
	
	public String validateQuotesPageTitle() {
		return driver.getTitle();
	}
	public void clickOnCreateQuotesBtn() {
		 createQuoteBtn.click();
	}
	public void createQuotes(String subject,String marketingGroupDropdownValue,String quotestageDropdownValue,String bill_streetTxt,String ship_streetTxt,String descriptionTxt,String qtyTxt) {
		subjectTxtBox.sendKeys(subject);
		groupRadioBtn.click();
		marketingGroupDropdown.click();
	    TestUtils.handlingDropdownByVisibleText(marketingGroupDropdown, marketingGroupDropdownValue);
	 
	    quotestageDropdown.click();
	    
	    TestUtils.handlingDropdownByVisibleText(quotestageDropdown, quotestageDropdownValue);
	    
	    organisationNameImgBtn.click();
	    
	    String pid = TestUtils.windowHandles();
	    organizationName.click();
	    
	   // TestUtils.AlertAccept();
	    driver.switchTo().alert().accept();
	   
	    driver.switchTo().window(pid);
	    
	    bill_streetTxtBox.sendKeys(bill_streetTxt);
	    ship_streetTxtBox.sendKeys(ship_streetTxt);
	    
	    descriptionTxtBox.sendKeys(descriptionTxt);	
	    
	    productsLink.click();
	    
	    String pid2 = TestUtils.windowHandles();
	    productName.click();
	    
	    driver.switchTo().window(pid2);
	    
	    qtyTxtBox.sendKeys(qtyTxt);
	    
	    saveBtn.click();
	}	
	
}
