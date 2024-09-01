package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
	@Test(groups={"Sanity","Master"})
	public void Verify_Login()
	{
		logger.info("***** Starting TC002_LoginTest *****");
		try
		{
		
		// Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickonLogin();
		Thread.sleep(5000);
		
		// MyAccount Page
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetPage=myacc.isMyAccountPageExist();
		
		//Assert.assertEquals(tagetPage,true, "Login Failed"); // U can use any one below
		Assert.assertTrue(targetPage);
		
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("***** Finished the TC002_LoginTest *****");	
		
	}

}
