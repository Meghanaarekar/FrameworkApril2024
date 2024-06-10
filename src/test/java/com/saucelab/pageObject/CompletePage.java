package com.saucelab.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompletePage {
	//create obj of the webdriver
    WebDriver driver;	
	public CompletePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement successMsg;
	
	public void getsuccessmsg()
	{
		String msg =successMsg.getText();
		System.out.println("Overview text msg is"+msg);
		if(msg.equals("Thank you for your order!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("success msg not displaying");
		}
		}
	
}
