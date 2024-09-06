package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
	
	//@Test(groups= {"master"})
	@Test
	public void verify_productSearch()throws InterruptedException
	{
	logger.info("***** Starting TC004_SearchProductTest *****");
	
	try
	{
		HomePage hm=new HomePage(driver);
		
		//hm.enterProductName("iPhone");
		hm.enterProductName("mac");
		
		hm.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		//boolean productExists = sp.isProductExist("MacBook");
		//Assert.assertEquals(productExists, true);
		
		sp.isProductExist("MacBook");
		Assert.assertEquals(sp.isProductExist("MacBook"),true);
		
	}
	catch (Exception e)
	{
		Assert.fail();
		
	}
	
	logger.info("***** Finished TC004_SearchProductTest *****");
	
	
	}	

}
