package com.saucelab.testcases;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucelab.pageObject.CartPage;
import com.saucelab.pageObject.CompletePage;
import com.saucelab.pageObject.InformationPage;
import com.saucelab.pageObject.LoginPage;
import com.saucelab.pageObject.LogoutPage;
import com.saucelab.pageObject.OverviewPage;
import com.saucelab.pageObject.ProductPage;

public class RegressionTestCase extends BaseClass {
    @Test
	public void verifyLoginPageFuntionality() throws IOException
	{
    	//WebDriver driver=new ChromeDriver();
	driver.get(url);
	LoginPage lp = new LoginPage(driver);
	lp.username();
	lp.password();
	lp.ClickOnLoginBtn();
	String Title= driver.getTitle();
	System.out.println("Login Page Title is"+Title);
	
	if(Title.equals("Swag Labs"))
	{
		Assert.assertTrue(true);
		System.out.println("Login Page test Case passed");
	}
	else{
		captureScreenShot(driver,"Verify login page");
		Assert.assertTrue(false);
		System.out.println("Login page Test Case Failed");
	}

    //Product page functionality
    ProductPage prodPage=new ProductPage(driver);
    prodPage.clickOnProductLink();
    prodPage.clickOnaddToCart();
    String ProductPageUrl= driver.getCurrentUrl();
	System.out.println("ProductPageUrl is"+ProductPageUrl);
	
	if(ProductPageUrl.equals("https://www.saucedemo.com/inventory-item.html?id=4"))
	{
		Assert.assertTrue(true);
		System.out.println("ProductPageUrl test Case passed");
	}
	else{
		captureScreenShot(driver,"Verify ProductPageUrl page");
		Assert.assertTrue(false);
		System.out.println("ProductPageUrl Test Case Failed");
	}
	//Cart page Functionality
	
	CartPage cartPage= new CartPage(driver);
	cartPage.clickOnCartIcon();
	cartPage.clickOncheckOutBtn();

	
	//checkout funtionality
	InformationPage informationpage= new InformationPage(driver);
	informationpage.enterLastName();
	informationpage.enterFirstName();
	informationpage.enterzipCode();
	informationpage.clickOnContinueBtn();
	String informationPageUrl= driver.getCurrentUrl();
	System.out.println("informationPageUrl is"+informationPageUrl);
	
	if(informationPageUrl.equals("https://www.saucedemo.com/checkout-step-two.html"))
	{
		Assert.assertTrue(true);
		System.out.println("informationPageUrl test Case passed");
	}
	else{
		captureScreenShot(driver,"Verify informationUrl page");
		Assert.assertTrue(false);
		System.out.println("informationPageUrl Test Case Failed");
	}
	//Overview funtionality
	OverviewPage overviewpage=new OverviewPage(driver);
	overviewpage.clickOnFinishBtn();
	String ordercompletepageUrl= driver.getCurrentUrl();
	System.out.println("overviewpage is"+ordercompletepageUrl);
	
	if(ordercompletepageUrl.equals("https://www.saucedemo.com/checkout-complete.html"))
	{
		Assert.assertTrue(true);
		System.out.println("ordercompletepageUrl test Case passed");
	}
	else{
		captureScreenShot(driver,"Verify ordercompletePageUrl page");
		Assert.assertTrue(false);
		System.out.println("ordercompletepageUrl Test Case Failed");
	}
	//complete page funcationality]
	CompletePage completePage= new CompletePage(driver);
	completePage.getsuccessmsg();
	
	//Logout page functionality
	LogoutPage logoutPage= new LogoutPage(driver);
	logoutPage.clickOnOpenMenu();
	logoutPage.clickOnLogoutBtn();
	String LogInpageUrl= driver.getCurrentUrl();
	System.out.println("overviewpage is"+LogInpageUrl);
	
	if(LogInpageUrl.equals("https://www.saucedemo.com/"))
	{
		Assert.assertTrue(true);
		System.out.println("Logoutpagetest Case passed");
	}
	else{
		captureScreenShot(driver,"Verify LogoutPageUrl page");
		Assert.assertTrue(false);
		System.out.println("LogoutpageUrl Test Case Failed");
	}
	
}}