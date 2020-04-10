package com.vTigerCRM.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vTigerCRM.qa.Base.TestBase;
import com.vTigerCRM.qa.utils.TestUtils;

public class Homepage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeLink;

	@FindBy(xpath = "//img[contains(@src,'user')]")
	WebElement signOutLogo;

	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOutLink;

	@FindBy(xpath = "//a[text()='Organizations']")
	WebElement organizationsLink;

	@FindBy(xpath = "//a[text()='Products']")
	WebElement productsLink;

	@FindBy(xpath = "//a[text()='More']")
	WebElement moreLink;

	@FindBy(xpath = "//a[text()='Quotes']")
	WebElement quotesLink;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateHomeLink() {
		return homeLink.isDisplayed();
	}

	public void clickOnQuotesLink() {
		quotesLink.click();
	}

	public void clickOnOrganizationLink() {
		organizationsLink.click();
	}

	public void clickOnProductsLink() {
		productsLink.click();
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public void moreOptions() {
		TestUtils.moveToElement(moreLink);
	}
	public void signOut() {
		TestUtils.moveToElement(signOutLogo);
		signOutLink.click();	
	}
}