package com.ebank.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	public String getBaseURL()
	{
		String baseURL=pro.getProperty("BaseUrl");
		return baseURL;
	}
	public String getUserName()
	{
		String UserName=pro.getProperty("userName");
		return UserName;
	}
	public String getPassword()
	{
		String password=pro.getProperty("pwd");
		return password;
	}

	public String getedgeDriverPath()
	{
		String path=pro.getProperty("edgeDriverPath");
		return path;
	}
	
	public String getChromeDriverPath()
	{
		String path=pro.getProperty("chromeDriverPath");
		return path;
	}
}
