package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
		
		//Locators	​
		By header = By.xpath("//h1[text()='Sales Dashboard']");
		By companyInfo = By.xpath("//span[contains(@class,'account-name')]");
		//to navigate to contacts page
		By contactsMainTab =By.id("nav-primary-contacts-branch");
		By contactsChildTab = By.id("nav-secondary-contacts");
		
		//Constructor
		
		public HomePage(WebDriver driver){
			this.driver =driver;
			elementUtil=new ElementUtil(driver);
		}
		
		//Methods
		
		public String getHomePageTitle(){
			//return driver.getTitle();
			
			return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
		}
		
		public boolean verifyLoggedCompanyName(){
			//return driver.findElement(userInfo).isDisplay();
			return elementUtil.isElementDisplayed(companyInfo);
		}
		
		public String getHomePageHeaderValue(){
			//return driver.findElement(header).getText();
			return elementUtil.doGetText(header);
		}
		
		public String getLoggedCompanyName(){
			//return driver.findElement(companyInfo).getText();
			return elementUtil.doGetText(companyInfo);
				
	}
		private  void clickOnContacts(){
			elementUtil.doClick(contactsMainTab);
			elementUtil.doClick(contactsChildTab);
		}
		public ContactsPage gotoContactsPage(){
			clickOnContacts();
			return new ContactsPage(driver);
		}
	}



	


