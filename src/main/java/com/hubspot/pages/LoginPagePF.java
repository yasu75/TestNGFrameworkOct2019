package com.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtilPF;

public class LoginPagePF extends BasePage{
	
	//Two pattern
	//First pattern is NPF which is called by locator
	//Second pattern is Page Factory (PF) which is used @FindBy in this approach 
	
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	
	//PF pattern: with the help of @FindBy
	@FindBy(how=How.ID,using= "username")
	@CacheLookup//if you don't have dynamic element you can use this for stable elements
	WebElement emailId;
	
	@FindBy(how=How.ID,using= "password")
	@CacheLookup
    WebElement password;
	
	@FindBy(how=How.ID,using= "loginBtn")
	WebElement loginButton;
	
	public LoginPagePF(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilPF = new ElementUtilPF(driver);
	}
	
	public void doLogin(String username, String pwd){
		elementUtilPF.waitForElementPresent(emailId);
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
}
