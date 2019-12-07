package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class HomePageTest {
		
		WebDriver driver;
		Properties prop;
		BasePage basePage;
		HomePage homePage;
		LoginPage loginPage;
		
		@BeforeMethod
		public void setUp() throws InterruptedException{
			basePage = new BasePage();
			prop =basePage.initialize_properties();
			driver = basePage.initialize_driver(prop);
			loginPage = new LoginPage(driver);
			homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			Thread.sleep(5000);
			}
		
		@Test(priority=1, description="This method gets the title from homepage")
		public void verifyHomePageTitleTest(){
			String title = homePage.getHomePageTitle();
			System.out.println("page title is: "+ title);
			Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "title is incorrect");
		}
		@Test(priority=2,description="This method verifies homepage header")
		public void verifyHomePageHeaderTest(){
			String headerValue=homePage.getHomePageHeaderValue();
			System.out.println("Home page header: "+headerValue);
			Assert.assertEquals(headerValue,Constants.HOME_PAGE_HEADER, "incorrect header");
		}
		@Test(priority=3,description="This method verifies company information")
		public void verifyLoggedCompanyInfo(){
			String companyInfo = homePage.getLoggedCompanyName();
			System.out.println("Company name is: "+ companyInfo);
			Assert.assertEquals(companyInfo, prop.getProperty("companyInfo"));
		}
		
		@AfterMethod
		public void tearDown(){
			basePage.quitBrowser();
		}
		
		
}

	





