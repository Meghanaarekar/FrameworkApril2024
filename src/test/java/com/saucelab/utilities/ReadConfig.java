package com.saucelab.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String Filepath="C:\\Users\\User\\workspace\\FrameworkApril2024\\Configurations\\Config.properties";
	
	public ReadConfig()
	{
		try{
			properties =new Properties();
			FileInputStream fs =new FileInputStream(Filepath);
			properties.load(fs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String urlValue= properties.getProperty("URL");
		//CHECK IF VALUE IS NULL
		if(urlValue !=null)
		{
			return urlValue;
		}
		else
		{
			throw new RuntimeException("URL NOT FOUND IN CONFIG FILE");
		}
	}
	public String getBROWSER()
	{
		String browserValue= properties.getProperty("browser");
		//CHECK IF VALUE IS NULL
		if(browserValue !=null)
		{
			return browserValue;
		}
		else
		{
			throw new RuntimeException("BrowserValue NOT FOUND IN CONFIG FILE");
		}
	}
}
