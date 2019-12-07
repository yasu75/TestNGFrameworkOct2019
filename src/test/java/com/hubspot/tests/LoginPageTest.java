package com.hubspot.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.hubspot.listeners.TestAllureListener.class)

public class LoginPageTest {
	
	Logger log=Logger.getLogger("LoginPageTest");
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	
	public void setUp(){
		
	basePage=new BasePage();
	log.info("Browser is launching");
	prop=basePage.initialize_properties();
	driver=basePage.initialize_driver(prop);
	loginPage=new LoginPage(driver);
	log.info("setUp confg");
	}
	
	@Test(priority=1, description="This method is getting title")
	public void loginPageTitle(){
		String title=loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"this is incorect");
		
			
		}
	@Test(priority=2, description="Valid username,valid password")
	@Description("Login test with correct user and correct pass")// allure report un descripton i
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest1() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
		
	}
	@Test(priority=3, description="invalid username,invalid password")
	public void loginTest2() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
	}
	@Test(priority=4, enabled=true,description="YaseminValid username")
	public void loginTest3() throws InterruptedException{
		loginPage.doLogin("yaseminyenipazar@gmail.com", "123567");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	}


