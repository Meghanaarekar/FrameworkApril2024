package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement productlink;
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addToCart;
	
	public void clickOnProductLink()
	{
		productlink.click();
		
	}
	public void clickOnaddToCart()
	{
		addToCart.click();
		
	}
}
