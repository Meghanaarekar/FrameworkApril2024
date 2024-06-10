package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
	//create obj of the webdriver
    WebDriver driver;	
	public InformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement zipCode;
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public void enterFirstName()
	{
		firstName.sendKeys("FName");
	}
	public void enterLastName()
	{
		lastName.sendKeys("LName");
	}
	public void enterzipCode()
	{
		zipCode.sendKeys("00000");
	}
	public void clickOnContinueBtn()
	{
		continueBtn.click();
	}
}
