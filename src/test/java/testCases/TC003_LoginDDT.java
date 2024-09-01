package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.TestDataProviders;

public class TC003_LoginDDT extends BaseClass {
    
    @Test(dataProvider="LoginData",dataProviderClass=TestDataProviders.class,groups="Datadriven") // Getting data from multiple classes
    public void verify_loginDDT(String username, String password, String exp) throws InterruptedException
    {
        try {
        	
            logger.info("***** Starting TC003_LoginDDT *****");

            // Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            Thread.sleep(3000);
            hp.clickLogin();

            // Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(username);
            lp.setPassword(password);
            lp.clickonLogin();

            // MyAccount Page
            MyAccountPage myacc = new MyAccountPage(driver);
            boolean targetPage = myacc.isMyAccountPageExist();

            if(exp.equalsIgnoreCase("Valid")) {
                if(targetPage) {
                    myacc.clickLogout();
                    Assert.assertTrue(true);
                }else {
                    Assert.assertTrue(false, "Expected valid login but login failed.");
                }
            } else if (exp.equalsIgnoreCase("Invalid")) {
                if(targetPage) {
                    myacc.clickLogout();
                    Assert.assertTrue(false, "Expected login failure but login succeeded.");
                }else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
        	Thread.sleep(3000);
        	logger.error("Exception occurred in TC003_LoginDDT: " + e.getMessage());
            Assert.fail();
        } finally {
            logger.info("***** Finished the TC003_LoginDDT *****");
        }
    }
}
