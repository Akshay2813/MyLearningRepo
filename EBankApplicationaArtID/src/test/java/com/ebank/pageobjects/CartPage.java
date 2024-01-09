package com.ebank.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CartPage {
	
	
	//WebDriver driver;
	
//	public CartPage(WebDriver driver)
//	{
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
	
	
//	@FindBy(xpath="//div[@class='products']/div")
//	WebElement allItems;
	
	
	
	
	public void addItem() throws InterruptedException
	{
		
		String[] requiredItem= {"Cucumber","Tomato"};
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> allItem=driver.findElements(By.xpath("//div[@class='products']/div"));
		
		for(int i=0;i<allItem.size();i++)
		{
			WebElement itemName = allItem.get(i).findElement(By.tagName("h4"));
			String[] item=itemName.getText().split("-");
			String formatItemName=item[0].trim();
			
			List<String> requiredItemList=Arrays.asList(requiredItem);
			if(requiredItemList.contains(formatItemName))
			{
				//div[@class='products']/div[1]/div/button
				
				WebElement button = allItem.get(i).findElement(By.xpath("div/button"));
				button.click();
				wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='products']/div["+i+"]/div/button"),"ADD TO CART"));
//				Thread.sleep(5000);
				System.out.print(formatItemName+" ");

			}

	
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		CartPage c= new CartPage();
		c.addItem();
	}
	
	
}
