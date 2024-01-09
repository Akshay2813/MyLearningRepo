package com.ebank.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(uname);
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement name;
	
	

	
	public void setUserName(String uname)
	{
		//input [@name = 'uid']
		//driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(uname);
		name.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	}
	
	
	public void clickSubmit()
	{
		
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

	}
	
	public void Logout()
	{
		driver.findElement(By.partialLinkText("Log out")).click();
	}
	
	
	
	
	

}
