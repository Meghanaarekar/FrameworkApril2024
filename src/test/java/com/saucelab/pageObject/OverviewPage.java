package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	//create obj of the webdriver
    WebDriver driver;	
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="finish")
	WebElement FinishBtn;
	
	
	
	public void clickOnFinishBtn()
	{
		FinishBtn.click();
	}
	
}
