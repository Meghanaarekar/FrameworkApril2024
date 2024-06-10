package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	//create obj of the webdriver
    WebDriver driver;	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className="shopping_cart_link")
	WebElement cartIcin;
	
	@FindBy(id="checkout")
	WebElement checkOut;
	
	public void clickOnCartIcon()
	{
		cartIcin.click();
	}
	public void clickOncheckOutBtn()
	{
		checkOut.click();
	}
}
