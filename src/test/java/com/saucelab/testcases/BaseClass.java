package com.saucelab.testcases;


import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.saucelab.utilities.ReadConfig;


public class BaseClass {
	
	
	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readConfig= new ReadConfig();
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBROWSER();
	
	@BeforeClass
	public void setUp()
	{
		switch(browser.toLowerCase()){
		
		case "chrome":
		driver=new ChromeDriver();
		break;
		
		case "firefox":
		driver=new FirefoxDriver();
		break;
		
		case "edge":
		driver=new EdgeDriver();
		break;
		
		default:
		driver=null;
		break;	
		}
		driver.manage().window().maximize();
	
	}
	@AfterClass
	
		public void teardown()
		{
			driver.quit();
		}
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
	//convert webdribver obj to takescreenshot interface
	TakesScreenshot screenshot =((TakesScreenshot)driver);
	//call getscreenshotas method to create image file
	File src= screenshot.getScreenshotAs(OutputType.FILE);
	File dest =new File(System.getProperty("user.dir")+"./Screenshots/"+ testName+".png");
	//copy image file to destination
	FileUtils.copyFile(src,dest);
		}
}
