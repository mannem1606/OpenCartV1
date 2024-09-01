package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	
	public void verify_account_registration() {
		
		
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regipage=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer details");
		regipage.setFirstName(randomString().toUpperCase());
		regipage.setLastName(randomString().toUpperCase());
		regipage.setEmail(randomString()+"@gmail.com");
		regipage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regipage.setPassword(password);
		regipage.setConfirmPassword(password);
		//regipage.setPassword(randomAlphaNumeric());
		
		regipage.setPrivacyPolicy();
		regipage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg=regipage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			
		}else 
		{
			    logger.error("Test Failed...");
			   // logger.debug("Debug logs...");// For debug log
			    Assert.assertTrue(false);
			
		}
			
		//Assert.assertEquals(confmsg, "Your Account has been created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		  }
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	
}
