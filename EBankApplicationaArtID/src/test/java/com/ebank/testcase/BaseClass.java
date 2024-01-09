package com.ebank.testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ebank.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readCon= new ReadConfig();
	public String Baseurl = readCon.getBaseURL();
	public String username = readCon.getUserName();
	public String pwd = readCon.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {
		// System.("webdriver.chrome.driver",
		// "C:\\Users\\Akshay\\API_Automation_Scratch\\EBankApplicationaArtID\\Drivers\\msedgedriver.exe");
		
		
		
//System/setPropertystem.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "Drivers\\msedgedriver.exe");
		//System.setProperty("webdriver.edge.driver",readCon.getedgeDriverPath() );
		
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		
		logger = Logger.getLogger("EBankApplicationaArtID");
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
	
	}
	
	
	//Run TC on desired Browser
//	@Parameters("browser")
//	@BeforeClass
//	public void setUp(String br) {
//		
//		logger = Logger.getLogger("EBankApplicationaArtID");
//		BasicConfigurator.configure();
//
//		PropertyConfigurator.configure("log4j.properties");
//		
//		if(br.equals("edge"))
//		{
//			System.setProperty("webdriver.edge.driver",readCon.getedgeDriverPath() );
//
//			driver = new EdgeDriver();
//		}
//		
//		else if(br.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver",readCon.getChromeDriverPath());
//			driver = new ChromeDriver();
//		} 
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//Example paractise
	public void takeScrnShot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target= new File("Location");
		FileUtils.copyFile(src, target);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("script", "arguments");
	}

}
