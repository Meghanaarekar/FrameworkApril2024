package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//create object of webdriver
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		//Webelement objects will be called by method so to initialise method below code
		PageFactory.initElements(driver,this);
	}
	//define elements
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement Loginbtn;
	
	public void username()
	{
		username.sendKeys("standard_user");
	}
	public void password()
	{
		password.sendKeys("secret_sauce");
	}
	public void ClickOnLoginBtn()
	{
		Loginbtn.click();
	}
}
