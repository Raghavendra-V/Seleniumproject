package com.vTigerCRM.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.qa.Base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name = "user_name")
	WebElement userName;
	
	@FindBy(name = "user_password")
	WebElement userPassword;

	@FindBy(id = "submitButton")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement vTigerLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateVtigerLogo() {
		return vTigerLogo.isDisplayed();
	}
	public Homepage login(String un, String pwd) {
		
		userName.sendKeys(un);
		userPassword.sendKeys(pwd);
		loginBtn.click();
		return new Homepage();
	}
	
}
