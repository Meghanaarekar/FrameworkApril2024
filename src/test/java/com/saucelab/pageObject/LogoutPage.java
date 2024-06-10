package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	//create obj of the webdriver
    WebDriver driver;	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="react-burger-menu-btn")
	WebElement OpenMenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement Logout;
	
	public void clickOnOpenMenu()
	{
		OpenMenu.click();
	}
	public void clickOnLogoutBtn()
	{
		Logout.click();
	}
}
