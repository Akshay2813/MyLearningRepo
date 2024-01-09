package com.ebank.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ebank.pageobjects.LoginPage;
import com.ebank.utility.XLUtils;

public class TC_LoginTest_01 extends BaseClass {

//	@Test
//	public void loginTest() {
//		driver.get(Baseurl); // driver coming from BaseClass as we are extending here
//		
//		LoginPage logInObj = new LoginPage(driver); // impore the package so that we can have class LoginPage
//		
//		logInObj.setUserName(username);
//		logger.info("UserName Entered " + username);
//		logInObj.setPassword(pwd);
//		logger.info("Password Entered sucessfully ");
//		logInObj.clickSubmit();
//		logger.info("Log in ButtonClicked");
//		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//			Assert.assertTrue(true);
//			logger.info("Logged In SucessFully");
//		} else {
//			Assert.assertTrue(false);
//			logger.info("Not able to  Login, please check");
//		}
//
//	}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String uname, String pwd) 
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(uname);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent())
		{
			//we get after logging if we enter invalid credetial for this website
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			Assert.assertTrue(false);  //this state that our TC fail
			
		}
		else
		{
			//we are able to log successfully log and we need to click on logout and enter again credetial
			lp.Logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true); //this states that out TC pass
		}
		
		
	}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/ebank/testdata/LoginData.xlsx";
		int row= XLUtils.getRowCount(path, "Sheet1");
		int col=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String[][] userData= new String[row][col];
		for(int i=1; i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				userData[i-1][j]=XLUtils.getcellData(path, "Sheet1", i, j);
			}
		}
		return userData;
	}
	
	

}
